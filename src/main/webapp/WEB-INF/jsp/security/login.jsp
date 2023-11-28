<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>


<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title><msg:message code="page.login.title"/></title>

    <%@ include file="../common/head.jspf" %>
    <%@ include file="../common/navigation.jspf" %>


    <header class="masthead"
            style="background: url(&quot;assets/img/banner.png&quot;) center / cover no-repeat;">
        <div class="overlay">

        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="site-heading">
                        <h1><msg:message code="page.login.biglabel"/></h1>
                        <span class="subheading"><msg:message code="page.login.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="container py-4 py-xl-5">
        <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3">

            <!-- PAGE MAIN CONTENT -->


            <div class="container">


                <div class="login-card" style="font-family: Roboto, sans-serif;">

                    <p class="profile-name-card">
                        <i class="fa fa-unlock-alt d-inline"
                           style="width: 0;height: 0;font-size: 56px;color: rgb(0,161,74);border-color: rgb(55,197,146);">
                        </i>
                    </p>

                    <form name="f" method="post" role="form"
                          th:action="@{/login}" class="form-signin">

        <span class="reauth-email" style="margin: 11px;">

        </span><input id="inputEmail" class="form-control" type="username" required placeholder="username" autofocus
                      name="username"/>

                        <input id="inputPassword" class="form-control" type="password" required placeholder="password"
                               name="password"/>

                        <div class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" name="remember" id="remember"
                                   th:checked="${param.remember}"/>
                            <label class="form-label custom-control-label" for="remember" style="font-size: 16px;">Remember
                                Me</label>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <button class="btn btn-primary btn-lg d-block btn-signin w-100"
                                style="font-family: Roboto, sans-serif;font-size: 16px;font-weight: normal;font-style: normal;background: rgb(0,161,74);"
                                type="submit">Sign in
                        </button>

                    </form>
                    <p class="text-center" style="color: rgb(73,80,87);font-size: 11px;">Restricted Area</p>
                </div>


            </div>


            <!-- END PAGE MAIN CONTENT -->

        </div>

    </div>


    <%@ include file="../common/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"></script>
    <script src="/assets/js/script.min.js"></script>
    </body>
</html>