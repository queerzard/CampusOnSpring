<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>


<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<!DOCTYPE html>
<html>

<head>
    <title><msg:message code="page.contact.title"/></title>
    <%@ include file="../common/head.jspf" %>
    <%@ include file="../common/navigation.jspf" %>


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
                    Für jedes Anliegen gibt es bei uns Ansprechpartner. CampusFM unterteilt sich in folgende fünf
                    Redaktionen:<br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Musik</span><br/>
                    Bemusterungen, Musikanfragen, Konzertpräsentationen<br/>
                    Chefredaktion: Tim Brüninghaus<br/>
                    <a href="mailto:musik@campusfm.info">musik (at) campusfm.info</a><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Online</span><br/>
                    Fragen und Kommentare zu Inhalten auf unserer Website und unseren Social-Media-Kanälen (z.B.
                    Instagram)<br/>
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
                    Interviewanfragen, Programmwünsche, Aufnahme in unseren Veranstaltungskalender, Ressorts:
                    Hochschule, Kultur, Wissenschaft<br/>
                    Chefredaktion: Anna Schäfer<br/>
                    <a href="mailto:wort@campusfm.info">wort (at) campusfm.info</a><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Verein</span><br/>
                    CampusFM wird rechtlich vertreten durch den Trägerverein CampusFM e.V. Eingetragen ist der Verein
                    beim Amtsgericht Essen mit der Vereinsregisternummer 4199<br/>
                    Vorstand: Alex Enseling, Max Mayer<br/>
                    <a href="mailto:vorstand@campusfm.info">vorstand (at) campusfm.info</a><br/>
                    Bemusterungen bitte ausschließlich an <a href="mailto:musik@campusfm.info">musik (at)
                    campusfm.info</a>, ansonsten werden diese nicht berücksichtigt!<br/>
                    <br/><span
                        style="color: rgb(0, 0, 0); background-color: transparent;">Geschäfts-/Kassenführung</span><br/>
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


    <%@ include file="../common/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"></script>
    <script src="/assets/js/script.min.js"></script>
    </body>
</html>