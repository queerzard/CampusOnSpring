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
    <title><msg:message code="page.listen.title"/></title>

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
                        <h1><msg:message code="page.listen.biglabel"/></h1>
                        <span class="subheading"><msg:message code="page.listen.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="row mb-5">
            <div class="col-md-8 col-xl-6 text-center mx-auto" style="width: 90%;font-family: Abel, sans-serif;">
                <h2 class="divider-style"><span><msg:message code="page.listen.biglabel"/></span></h2>
                <p class="text-start w-lg-50" style="font-family: 'Open Sans', sans-serif;">

                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Empfang per UKW</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Seid ihr in Duisburg und Umgebung könnt
        ihr ganz einfach euer Auto- oder Küchenradio auf UKW 104,5 MHz und in Essen, Gelsenkirchen und Umgebung auf
        105,6 einstellen. Dort könnt ihr uns ganz ohne Internetverbindung und ohne Rücksicht aufs Datenvolumen so lange
        hören, wie ihr wollt! Je nach Lage und Gerät ist der Empfang auch noch in Teilen von Bottrop und Oberhausen
        möglich. Probiert es im Zweifel einfach mal aus.</span><br/>
                    <br/><span
                        style="color: rgb(0, 0, 0); background-color: transparent;">Weltweit im Internet</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Selbstverständlich könnt ihr uns aber
        auch weltweit im Internet hören: Das geht zum Beispiel direkt hier auf unserer Website (oder auch bald wieder
        über die myUDE-App.) Leider kann es über diese beiden Wege aber hin und wieder zu temporären, technischen
        Ausfällen kommen.</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Unser Stream läuft aber weiter! Falls es
        auf der Website oder in der App nicht funktioniert, probiert es doch einfach mal direkt über diese
        Stream-Adresse:</span><br/>
                    <br/><a href="http://stream.campusfm.de/"
                            target="_blank">http://stream.campusfm.de/</a><br/><br/><br/>
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