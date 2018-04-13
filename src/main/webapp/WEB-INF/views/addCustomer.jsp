<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="addCustomer.title"/></title>
</head>
<body>
<section>
    <div class="pull-right" style="padding-right:50px">
        <a href="?language=en"><spring:message code="language.en"/></a>|
        <a href="?language=pl"><spring:message code="language.pl"/></a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="addCustomer.jumbotron.h1"/></h1>
        </div>
    </div>
</section>
<section class="container">
    <form:form method="POST" modelAttribute="newCustomer" class="form-horizontal">
        <fieldset>
            <legend><spring:message code="addCustomer.legend"/></legend>
            <div class="form-group">
                <div class="row">
                    <label class="control-label col-lg-2" for="productId"><spring:message
                            code="addCustomer.form.customerId.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="productId" path="customerId"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2 " for="name"><spring:message
                            code="addCustomer.form.customerName.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="name" path="name"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2 " for="surname"><spring:message
                            code="addCustomer.form.customerSurname.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="surname" path="surname"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="address"><spring:message
                            code="addCustomer.form.customerAddress.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="address" path="address"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="noOfOrders"><spring:message
                            code="addCustomer.form.customerNumberOfOrders.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="noOfOrders" path="noOfOrders"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                               value="<spring:message code="addCustomer.form.button.add"/>"/>
                    </div>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>