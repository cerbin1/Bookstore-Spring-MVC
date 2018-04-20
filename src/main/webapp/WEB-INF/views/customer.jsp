<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="customer.title"/></title>
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
            <h1><spring:message code="customer.jumbotron.h1"/></h1>
            <p><spring:message code="customer.jumbotron.p"/>${customer.customerId}</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${customer.name} ${customer.surname}</h3>
                    <p><spring:message code="customer.address"/> ${customer.address}</p>
                    <p><spring:message code="customer.numberOfOrders"/>${customer.noOfOrders}</p>
                    <a href="<spring:url value="/customers" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span><spring:message code="customer.button.back"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
