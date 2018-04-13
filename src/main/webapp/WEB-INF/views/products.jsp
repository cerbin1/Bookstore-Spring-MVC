<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="products.title"/></title>
</head>
<body>
<section>
    <div class="pull-right" style="padding-right:50px">
        <a href="?language=en"><spring:message code="language.en"/></a>
        |
        <a href="?language=pl"><spring:message code="language.pl"/></a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="products.jumbotron.h1"/></h1>
            <p><spring:message code="products.jumbotron.p"/></p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <img src="<c:url value="/img/${product.productId}.jpg">
                    </c:url>" alt="image" style="width:100%"/>
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p><spring:message code="products.price"/> ${product.unitPrice}</p>
                        <p>${product.unitsInStock} <spring:message code="products.availableUnitsInStock"/></p>
                        <p>
                            <a href=" <spring:url value="/market/product?id=${product.productId}" />"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"></span>
                                <spring:message code="products.productDetailsButton"/>
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
