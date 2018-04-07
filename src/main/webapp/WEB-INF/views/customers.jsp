<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Customers</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customers</h1>
            <p>List of our customers</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <table class="table table-striped">
            <row>
                <td>Id</td>
                <td>Name</td>
                <td>Surname</td>
                <td>Address</td>
                <td>Orders count</td>
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
