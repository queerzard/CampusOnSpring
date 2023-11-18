<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><msg:message code="page.contact.title"/></title>
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
        <img src="/assets/img/Logo_CampusFM.png" style="width: 142px;filter: contrast(110%);" width="142" height="49">
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/"><msg:message code="navigator.label.home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about"><msg:message code="navigator.label.about"/></a>
                </li>
<%--                <li class="nav-item">
                    <a class="nav-link" href="/events"><msg:message code="navigator.label.events"/></a>
                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="/login"><msg:message code="navigator.label.login"/></a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<header class="masthead"
        style="background: url(&quot;assets/img/banner.png&quot;) center / cover no-repeat; ">
    <div class="overlay">

    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 mx-auto position-relative">
                <div class="site-heading">
                    <h1><msg:message code="page.contact.biglabel"/></h1>
                    <span class="subheading"><msg:message code="page.contact.sublabel"/></span>
                </div>
            </div>
        </div>
    </div>
</header>


<div class="container">
    <div class="row mb-5">
        <div class="col-md-8 col-xl-6 text-center mx-auto" style="width: 90%;font-family: Abel, sans-serif;">
            <h2 class="divider-style"><span><msg:message code="page.contact.biglabel"/></span></h2>
            <p class="text-start w-lg-50" style="font-family: 'Open Sans', sans-serif;">

                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Kontakt</span><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Adresse</span><br/>
                CampusFM<br/>
                Universitätsstraße 2<br/>
                R11 T06 D49<br/>
                45141 Essen<br/>
                Telefon: (49) 201 – 183 23 15<br/>
                Mail: <a href="mailto:kontakt@campusfm.info">kontakt (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Redaktionen</span><br/>
                Für jedes Anliegen gibt es bei uns Ansprechpartner. CampusFM unterteilt sich in folgende fünf Redaktionen:<br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Musik</span><br/>
                Bemusterungen, Musikanfragen, Konzertpräsentationen<br/>
                Chefredaktion: Tim Brüninghaus<br/>
                <a href="mailto:musik@campusfm.info">musik (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Online</span><br/>
                Fragen und Kommentare zu Inhalten auf unserer Website und unseren Social-Media-Kanälen (z.B. Instagram)<br/>
                Chefredaktion: Sarah Brakemeier<br/>
                <a href="mailto:online@campusfm.info">online (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Personal</span><br/>
                Bewerbungen<br/>
                Chefredaktion: Pia Schümmelfeder<br/>
                <a href="mailto:ausbildung@campusfm.info">ausbildung (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Programm</span><br/>
                Rückfragen zum Programm (bitte keine Bemusterungen)<br/>
                Chefredaktion: Alex Enseling<br/>
                <a href="mailto:vorstand@campusfm.info">vorstand (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Public Relations</span><br/>
                Erstkontakt und Außendarstellung, Rückfragen zu Akkreditierungen, Kooperationen und Sponsoring<br/>
                Chefredaktion: Max Mayer<br/>
                <a href="mailto:kontakt@campusfm.info">kontakt (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Wort</span><br/>
                Interviewanfragen, Programmwünsche, Aufnahme in unseren Veranstaltungskalender, Ressorts: Hochschule, Kultur, Wissenschaft<br/>
                Chefredaktion: Anna Schäfer<br/>
                <a href="mailto:wort@campusfm.info">wort (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Verein</span><br/>
                CampusFM wird rechtlich vertreten durch den Trägerverein CampusFM e.V. Eingetragen ist der Verein beim Amtsgericht Essen mit der Vereinsregisternummer 4199<br/>
                Vorstand: Alex Enseling, Max Mayer<br/>
                <a href="mailto:vorstand@campusfm.info">vorstand (at) campusfm.info</a><br/>
                Bemusterungen bitte ausschließlich an <a href="mailto:musik@campusfm.info">musik (at) campusfm.info</a>, ansonsten werden diese nicht berücksichtigt!<br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Geschäfts-/Kassenführung</span><br/>
                In finanziellen Angelegenheiten wenden Sie sich bitte an<br/>
                Geschäftsführung: Jonathan Kaminski<br/>
                <a href="mailto:finanzen@campusfm.info">Finanzen (at) campusfm.info</a><br/>
                <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Technik</span><br/>
                Anfragen zur Technik gehen an<br/>
                <a href="mailto:vorstand@campusfm.info">vorstand (at) campusfm.info</a><br/><br/><br/>
            </p>
            </p>
        </div>

    </div>
</div>

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
                        <a class="link-secondary" href="/imprint"><msg:message code="footer.label.imprint"/></a>
                    </li>
                    <li class="list-inline-item me-4">
                        <a class="link-secondary" href="/contact"><msg:message code="footer.label.contact"/></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="link-secondary" href="/listen"><msg:message code="footer.label.listen"/></a>
                    </li>
                    <li class="list-inline-item" style="padding-left: 12px;padding-right: 12px;">
                        <a class="link-secondary" href="/contribute"><msg:message code="footer.label.contribute"/></a>
                    </li>
                    <li class="list-inline-item" style="padding-right: 12px;padding-left: 12px;">
                        <a class="link-secondary" href="/program"><msg:message code="footer.label.program"/></a>
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