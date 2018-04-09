<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Product</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Product</h1>
            <p>Information about ${product.name}</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/img/${product.productId}.jpg">
        </c:url>" alt="image" style="width:100%"/>
        </div>
        <div class="col-sm-4">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>Category: ${product.category}</p>
                    <p>Manufacturer: ${product.manufacturer}</p>
                    <p>Price: ${product.unitPrice} $</p>
                    <p>Available ${product.unitsInStock} units in stock</p>
                    <p>
                        <a href="#" class="btn btn-warning btn-large">
                            <span class="glyphicon-shopping-cart glyphicon"></span> Order Now
                        </a>
                    </p>
                    <a href="<spring:url value="/market/products" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span> Back
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
