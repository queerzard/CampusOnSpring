<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><msg:message code="page.login.title"/></title>
    <meta name="twitter:title" content="CampusFM - Klingt... anders!">
    <meta property="og:image" content="assets/img/cropped-Logo-Tab-180x180.png">
    <meta name="description" content="Klingt... anders!
Das Uni-Radio der Uni-Duisburg-Essen.">
    <meta name="twitter:image" content="assets/img/cropped-Logo-Tab-180x180.png">
    <meta name="twitter:description" content="Das Uni-Radio der Uni-Duisburg-Essen">
    <link rel="apple-touch-icon" type="image/png" sizes="180x180" href="assets/img/cropped-Logo-Tab-180x180.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/cropped-Logo-Tab-32x32.png">
    <link rel="icon" type="image/png" sizes="180x180" href="assets/img/cropped-Logo-Tab-180x180.png">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abel&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abhaya+Libre&amp;display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">


</head>
<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top" id="mainNav">
    <div class="container">
        <button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fa fa-bars">

            </i>
        </button>
        <img src="assets/img/Logo_CampusFM.png" style="width: 192px;filter: contrast(110%);" width="192" height="69">
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/"><msg:message code="navigator.label.home" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about"><msg:message code="navigator.label.about" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/events"><msg:message code="navigator.label.events" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login"><msg:message code="navigator.label.login" /></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
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
                      th:action="@{/login}" class="form-signin"><span class="reauth-email" style="margin: 11px;">
                </span>
                    <input id="username" class="form-control" type="username" required placeholder="username" autofocus
                           name="username"/>
                    <input id="password" class="form-control" type="password" required placeholder="password"
                           name="password"/>
                    <button class="btn btn-primary btn-lg d-block btn-signin w-100"
                            style="font-family: Roboto, sans-serif;font-size: 16px;font-weight: normal;font-style: normal;background: rgb(0,161,74);"
                            type="submit">
                        Sign in
                    </button>
                </form>
                <p class="text-center" style="color: rgb(73,80,87);font-size: 11px;">Restricted Area</p>

            </div>
        </div>



        <!-- END PAGE MAIN CONTENT -->

    </div>

</div>





<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <span class="fa-stack fa-lg">
                            <a href="https://twitter.com/Campus_FM">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                            </a>
                        </span>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://www.instagram.com/campusfmradio/?hl=de">
                            <span class="fa-stack fa-lg">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-instagram fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                    </li>
                    <li class="list-inline-item"><a href="mailto:wort@campusfm.info">
                        <span class="fa-stack fa-lg">
                            <i class="fa fa-circle fa-stack-2x"></i>
                            <i class="fa fa-envelope fa-stack-1x fa-inverse">

                            </i></span></a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-xl-11 col-xxl-12">
                <ul class="list-inline" style="font-size: 17px;font-family: Abel, sans-serif;">
                    <li class="list-inline-item me-4">
                        <a class="link-secondary" href="/imprint"><msg:message code="footer.label.imprint" /></a>
                    </li>
                    <li class="list-inline-item me-4">
                        <a class="link-secondary" href="/contact"><msg:message code="footer.label.contact" /></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="link-secondary" href="/listen"><msg:message code="footer.label.listen" /></a>
                    </li>
                    <li class="list-inline-item" style="padding-left: 12px;padding-right: 12px;">
                        <a class="link-secondary" href="/contribute"><msg:message code="footer.label.contribute" /></a>
                    </li>
                    <li class="list-inline-item" style="padding-right: 12px;padding-left: 12px;">
                        <a class="link-secondary" href="/program"><msg:message code="footer.label.program" /></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 mx-auto">
                <p class="text-muted copyright">Copyright&nbsp;©&nbsp;CampusFM 2023</p>
            </div>
        </div>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"></script>
<script src="assets/js/script.min.js"></script>
</body>
</html>