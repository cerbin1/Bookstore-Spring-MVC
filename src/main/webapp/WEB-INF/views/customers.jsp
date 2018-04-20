<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="customers.title"/></title>
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
            <h1><spring:message code="customers.jumbotron.h1"/></h1>
            <p><spring:message code="customers.jumbotron.p"/></p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <table class="table table-striped">
            <row>
                <td><spring:message code="customers.table.id"/></td>
                <td><spring:message code="customers.table.name"/></td>
                <td><spring:message code="customers.table.surname"/></td>
                <td><spring:message code="customers.table.address"/></td>
                <td><spring:message code="customers.table.noOfOrders"/></td>
            </row>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.name}</td>
                    <td>${customer.surname}</td>
                    <td>${customer.address}</td>
                    <td>${customer.noOfOrders}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
