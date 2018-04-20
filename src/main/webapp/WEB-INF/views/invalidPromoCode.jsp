<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="invalidPromoCode.title"/></title>
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
        <h1 class="alert alert-danger">
            <spring:message code="invalidPromoCode.jumbotron.h1"/>
        </h1>
    </div>
</section>
<section>
    <div class="container">
        <a href="<spring:url value="/market/products"/> " class="btn bnt-primary">
            <spring:message code="invalidPromoCode.back"/>
        </a>
    </div>
</section>
</body>
</html>
