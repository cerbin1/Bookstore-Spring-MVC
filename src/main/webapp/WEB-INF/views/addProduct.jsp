<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="utf-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="addProduct.title"/></title>
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
            <h1><spring:message code="addProduct.jumbotron.h1"/></h1>
        </div>
    </div>
</section>
<section class="container">
    <form:form method="POST" modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend><spring:message code="addProduct.legend"/></legend>
            <div class="form-group">
                <div class="row">
                    <label class="control-label col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productId.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="productId" path="productId"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="name">
                        <spring:message code="addProduct.form.productName.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="name" path="name"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="unitPrice">
                        <spring:message code="addProduct.form.productUnitPrice.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="unitPrice" path="unitPrice"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="manufacturer">
                        <spring:message code="addProduct.form.productManufacturer.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="manufacturer" path="manufacturer"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="category">
                        <spring:message code="addProduct.form.productCategory.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="category" path="category"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label col-lg-2" for="unitsInStock">
                        <spring:message code="addProduct.form.productUnitsInStock.label"/></label>
                    <div class="col-lg-10">
                        <form:input id="unitsInStock" path="unitsInStock"
                                    type="text" class="form:input-large"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addProduct.form.productDescription.label"/></label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <label class="control-label col-lg-2"><spring:message
                            code="addProduct.form.productCondition.label"/></label>
                    <div class="col-lg-10">
                        <label class="control-label" for="condition-new">
                            <spring:message code="addProduct.form.productCondition.new.label"/></label>
                        <form:radiobutton id="condition-new" path="condition" value="New"/>
                        <label class="control-label" for="condition-old">
                            <spring:message code="addProduct.form.productCondition.old.label"/></label>
                        <form:radiobutton id="condition-old" path="condition" value="Old"/>
                        <label class="control-label" for="condition-refurbished">
                            <spring:message code="addProduct.form.productCondition.refurbished.label"/></label>
                        <form:radiobutton id="condition-refurbished" path="condition" value="Refurbished"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/></label>
                <div class="col-lg-10">
                    <form:input id="productImage" class="form:input-large" path="productImage" type="file"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productManualFile">
                    <spring:message code="addProduct.form.productManualFile.label"/></label>
                <div class="col-lg-10">
                    <form:input id="productManualFile" class="form:input-large" path="productManualFile" type="file"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="<spring:message code="addProduct.form.button.add"/>"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>
