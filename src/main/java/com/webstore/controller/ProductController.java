package com.webstore.controller;

import com.webstore.domain.Product;
import com.webstore.exception.NoProductsFoundUnderCategoryException;
import com.webstore.exception.ProductNotFoundException;
import com.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.Map;

@RequestMapping("market")
@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setAllowedFields(
                "productId",
                "name",
                "unitPrice",
                "description",
                "manufacturer",
                "category",
                "unitsInStock",
                "condition",
                "productImage",
                "productManualFile",
                "language");
    }

    @RequestMapping("products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("products/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String categoryName) {
        List<Product> products = productService.getProductsByCategory(categoryName);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "products/add", method = RequestMethod.GET)
    public String getAddProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "products/add", method = RequestMethod.POST)
    public String processAddProductForm(
            @ModelAttribute("newProduct") @Valid Product newProduct,
            BindingResult result,
            HttpServletRequest request
    ) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        MultipartFile productImage = newProduct.getProductImage();
        if (productImage != null && !productImage.isEmpty()) {
            try {
                String path = rootDirectory + "resources/images/" + newProduct.getProductId() + ".jpg";
                productImage.transferTo(new File(path));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }

        MultipartFile productManualFile = newProduct.getProductManualFile();
        if (productManualFile != null && !productManualFile.isEmpty()) {
            try {
                String path = rootDirectory + "resources/pdf/" + newProduct.getProductId() + ".pdf";
                productManualFile.transferTo(new File(path));
            } catch (Exception e) {
                throw new RuntimeException("Product Manual file saving failed", e);
            }
        }

        productService.addProduct(newProduct);
        return "redirect:/market/products";
    }

    @RequestMapping("stock/update")
    public String updateStock() {
        productService.updateAllStock();
        return "redirect:/market/products/";
    }

    @RequestMapping("products/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request,
                                    ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL()
                + "?" + request.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
}
