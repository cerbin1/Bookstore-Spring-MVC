<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="productNotFound.title"/></title>
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
            <h2 class="alert alert-danger">
                <spring:message code="productNotFound.jumbotron.h2"/>${invalidProductId}</h2>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p><spring:message code="productNotFound.url"/> ${url}</p>
        <p><spring:message code="productNotFound.exception"/> ${exception}</p>
    </div>
    <div class="container">
        <p>
            <a href="<spring:url value="/market/products" />" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span>
                <spring:message code="productNotFound.button.back"/>
            </a>
        </p>
    </div>
</section>
</body>
</html>