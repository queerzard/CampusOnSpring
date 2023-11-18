<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><msg:message code="page.home.title"/></title>
    <meta name="twitter:title" content="CampusFM - Klingt... anders!">
    <meta property="og:image" content="assets/img/cropped-Logo-Tab-180x180.png">
    <meta name="description" content="Klingt... anders!
Das Uni-Radio der Uni-Duisburg-Essen.">
    <meta name="twitter:image" content="/assets/img/cropped-Logo-Tab-180x180.png">
    <meta name="twitter:description" content="Das Uni-Radio der Uni-Duisburg-Essen">
    <link rel="apple-touch-icon" type="image/png" sizes="180x180" href="/assets/img/cropped-Logo-Tab-180x180.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/assets/img/cropped-Logo-Tab-32x32.png">
    <link rel="icon" type="image/png" sizes="180x180" href="/assets/img/cropped-Logo-Tab-180x180.png">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
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
        <img src="/assets/img/Logo_CampusFM.png" style="width: 142px;filter: contrast(110%);" width="142" height="49">
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/"><msg:message code="navigator.label.home" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about"><msg:message code="navigator.label.about" /></a>
                </li>
<%--                <li class="nav-item">
                    <a class="nav-link" href="/events"><msg:message code="navigator.label.events" /></a>
                </li>--%>
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
                    <h1><msg:message code="page.home.biglabel"/></h1>
                    <span class="subheading"><msg:message code="page.home.sublabel"/></span>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="container py-4 py-xl-5">
    <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3">

        <!-- PAGE MAIN CONTENT -->

        <style>
            h1 {
                text-align: center;
                margin-bottom: 50px;
                margin-top: 50px;
            }

            .blog-card-blog {
                margin-top: 30px;
            }

            .blog-card {
                display: inline-block;
                position: relative;
                width: 100%;
                margin-bottom: 30px;
                border-radius: 6px;
                color: rgba(0, 0, 0, 0.87);
                background: #fff;
                box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
            }

            .blog-card .blog-card-image {
                height: 60%;
                position: relative;
                overflow: hidden;
                margin-left: 15px;
                margin-right: 15px;
                margin-top: -30px;
                border-radius: 6px;
                box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
            }

            .blog-card .blog-card-image img {
                width: 100%;
                height: 100%;
                border-radius: 6px;
                pointer-events: none;
            }

            .blog-card .blog-table {
                padding: 15px 30px;
            }

            .blog-table {
                margin-bottom: 0px;
            }

            .blog-category {
                position: relative;
                line-height: 0;
                margin: 15px 0;
            }

            .blog-text-success {
                color: #6f6f6f!important;
            }

            .blog-card-blog .blog-card-caption {
                margin-top: 5px;
            }

            .blog-card-caption {
                font-weight: 700;
                font-family: "Roboto Slab", "Times New Roman", serif;
            }

            .blog-card-caption, .blog-card-caption a {
                color: #333;
                text-decoration: none;
            }

            p {
                color: #3C4857;
                margin-top: 0;
                margin-bottom: 1rem;
            }

            .blog-card .ftr {
                margin-top: 15px;
            }

            .blog-card .ftr .author {
                color: #888;
            }

            .blog-card .ftr div {
                display: inline-block;
            }

            .blog-card .author .avatar {
                width: 36px;
                height: 36px;
                overflow: hidden;
                border-radius: 50%;
                margin-right: 5px;
            }

            .blog-card .ftr .stats {
                position: relative;
                top: 1px;
                font-size: 14px;
            }

            .blog-card .ftr .stats {
                float: right;
                line-height: 30px;
            }



            a {
                text-decoration: none;
            }

        </style>
        <c:forEach items="${articleEntitiesList}" var="article">

            <div class="col-md-4" style="max-width: 350px; ">
                <div class="blog-card blog-card-blog" style="max-width: 350px; ">
                    <div class="blog-card-image">
                        <a href="/article?a=${article.id}"> <img class="img" style="overflow: hidden; object-fit: cover; max-height: 250px; max-width: 320px; min-height: 250px; min-width: 320px;" src="data:image/png;base64, ${article.base64preview}"> </a>
                        <div class="ripple-cont"></div>
                    </div>
                    <div class="blog-table">
                        <h6 class="blog-category blog-text-success"><i class="fas fa-blog"></i> ${article.category}</h6>
                        <h4 class="blog-card-caption">
                            <a href="/article?a=${article.id}">${article.title}</a>
                        </h4>
                        <p class="blog-card-description">${article.previewContent}</p>
                        <div class="ftr">
                            <div class="author">
                                <a href="/author/${article.userEntity.username}"> <img src="data:image/png;base64, ${article.userEntity.base64Avatar}"  style="overflow: hidden; object-fit: cover; width: 36px;
                height: 36px; " alt="..." class="avatar img-raised"> <span>${article.userEntity.firstName} ${article.userEntity.lastName}</span> </a>
                            </div>
                            <div class="stats"> <i class="far fa-clock"></i> ${article.publishMonthName} ${article.publishDayOfMonth}, ${article.publishYear} </div>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>

</div>


    <div style="padding-top: 10px;" class="container"><button class="btn btn-primary float-end" id="next-page-button" type="button"
                                   style="background: rgb(0,161,74);"><msg:message code="page.home.label.nextpage"/></button>
        <div class="clearfix"></div>
    </div>


    <script>const nextPageButton = document.getElementById("next-page-button");

    // Add an event listener to the button
    nextPageButton.addEventListener("click", function() {
        // Get the URLSearchParams object
        const urlSearchParams = new URLSearchParams(window.location.search);

        // Get the value of a parameter named "page"
        const page = urlSearchParams.get("page") || 1;

        // Increment the page number and create a new URL with the updated parameter
        const nextPageUrl = window.location.origin + window.location.pathname + "?page=" + (parseInt(page) + 1);

        // Redirect to the next page
        window.location.href = nextPageUrl;
    });</script>

</div>


<div class="event__search__floater">
    <div class="search__anchor">
        <form autocomplete="off" id="event-search-form" action="search" method="get">
            <input type="text" name="query" id="querriee" class="search__bar" placeholder="Suche">
            <input class="search__submit" onclick="encodeFormData()" type="submit">
            <div class="search__toggler"></div>
        </form>

    </div>
</div>

<script>
    function encodeFormData() {
        const query = document.getElementById("querriee");

        query.value = encodeURIComponent(query.value);
    }
</script>




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
<script src="/assets/js/script.min.js"></script>
</body>
</html>