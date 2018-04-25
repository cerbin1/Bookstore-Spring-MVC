<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="specialOffer.title"/></title>
</head>
<body>

<section>
    <div class="pull-right" style="padding-right:50px">
        <a href="?language=en"><spring:message code="language.en"/></a>
        |
        <a href="?language=pl"><spring:message code="language.pl"/></a>
        <a href="<c:url value="/logout"/>">
            <spring:message code="addProduct.logout"/>
        </a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="specialOffer.jumbotron.h1"/></h1>
            <p><spring:message code="product.jumbotron.p"/> ${specialOfferProduct.name}</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/img/${specialOfferProduct.productId}.jpg">
        </c:url>" alt="image" style="width:100%"/>
        </div>
        <div class="col-sm-4">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${specialOfferProduct.name}</h3>
                    <p>${specialOfferProduct.description}</p>
                    <p><spring:message code="product.category"/> ${specialOfferProduct.category}</p>
                    <p><spring:message code="product.manufacturer"/> ${specialOfferProduct.manufacturer}</p>
                    <p><spring:message code="product.price"/> ${specialOfferProduct.unitPrice} $</p>
                    <p>${specialOfferProduct.unitsInStock} <spring:message code="product.availableUnitsInStock"/></p>
                    <p><a href="/pdf/${specialOfferProduct.productId}.pdf" download>
                        <spring:message code="product.manual"/></a></p>
                    <p>
                        <a href="#" class="btn btn-warning btn-large">
                            <span class="glyphicon-shopping-cart glyphicon"></span>
                            <spring:message code="product.orderButton"/>
                        </a>
                    </p>
                    <a href="<spring:url value="/market/products" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span> <spring:message code="product.button.back"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
