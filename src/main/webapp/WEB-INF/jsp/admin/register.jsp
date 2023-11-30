<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><msg:message code="page.register.title"/></title>
    <link rel="stylesheet" href="/assets/dashboard/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/dashboard/assets/css/styles.min.css">
    <link rel="stylesheet" href="/assets/css/NZDropdown-Singlee.css">
</head>

<style>

    #content {
        background-color: #ffffff;
        padding: 10px;
    }

    label {
        display: block;
        margin-top: 10px;
    }

    input {
        width: 200px;
    }

    .errors {
        color: red;
    }

    .errorContainer {
        margin-top: 10px;
        border: darkred 1px solid;
        background-color: #ffcccc;
        padding: 10px;
    }
</style>

<body>
<%@ include file="common/navigator.jspf" %>


<%--@elvariable id="registrationModel" type="org.unidue.campusfm.queerzard.cms.web.dto.RegistrationModel"--%>
<form:form action="/register" method="post" modelAttribute="registrationModel">
<div class="row profile-row">
    <div class="col">
        <div class="row register-form">
            <div class="col-md-8 offset-md-2">
                <form class="custom-form">
                    <h1><msg:message code="page.register.heading"/></h1>

                    <div class="row form-group">
                        <div class="col-sm-4 label-column">
                            <label class="col-form-label" for="email"><msg:message code="page.register.email"/></label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <form:input class="form-control" path="email" name="email" id="email" type="email"
                                        required="false"/>
                            <form:errors path="email" cssClass="errors"/>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-sm-4 label-column">
                            <label class="col-form-label" for="password"><msg:message
                                    code="page.register.password"/></label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <form:input class="form-control" path="password" name="password" id="password"
                                        type="password"/>
                            <form:errors path="password" cssClass="errors"/>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-sm-4 label-column">
                            <label class="col-form-label" for="role"><msg:message code="page.register.role"/></label>
                        </div>
                        <div class="col-sm-6 input-column">
                            <form:select class="form-select form-control"
                                         style="height: 28px;padding-top: 3px;padding-bottom: 3px;font-size: 12px;width: 100%;"
                                         name="role" id="role" path="role">
                                <option value="user">USER</option>
                                <option value="admin">ADMIN</option>
                            </form:select>
                            <form:errors path="role" cssClass="errors"/>
                        </div>
                    </div>

                    <button class="btn btn-light submit-button" type="submit"><msg:message
                            code="page.register.submit"/></button>
                    </form:form>

            </div>
        </div>
    </div>
</div>
</form>
</div>
<div class="list-group"></div>
<script src="/assets/dashboard/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>