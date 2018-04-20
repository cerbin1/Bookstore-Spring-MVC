<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Invalid Promo Code</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <h1 class="alert alert-danger">
            You entered wrong promo code
        </h1>
    </div>
</section>
<section>
    <div class="container">
        <a href="<spring:url value="/market/products"/> " class="btn bnt-primary">Back</a>
    </div>
</section>
</body>
</html>
