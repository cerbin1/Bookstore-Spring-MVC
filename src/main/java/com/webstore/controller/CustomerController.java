package com.webstore.controller;

import com.webstore.domain.Customer;
import com.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping("customers/{customerId}")
    public String getCustomerById(@PathVariable String customerId, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        return "customer";
    }

    @RequestMapping("customers/add")
    public String getCustomerAddForm(@ModelAttribute("newCustomer") Customer newCustomer) {
        return "addCustomer";
    }

    @PostMapping("customers/add")
    public String processCustomerAddForm(@ModelAttribute("newCustomer") Customer newCustomer) {
        customerService.addCustomer(newCustomer);
        return "redirect: /customers";
    }
}
