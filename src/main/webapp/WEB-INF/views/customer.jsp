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
    <title>Customer</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customer</h1>
            <p>Information about customer with ID: ${customer.customerId}</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${customer.name} ${customer.surname}</h3>
                    <p>Address: ${customer.address}</p>
                    <p>${customer.name} have made ${customer.noOfOrders} orders</p>
                    <a href="<spring:url value="/customers" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span> back
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
