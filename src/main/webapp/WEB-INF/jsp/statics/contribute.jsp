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
    <title><msg:message code="page.contribute.title"/></title>
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
                        <h1><msg:message code="page.contribute.biglabel"/></h1>
                        <span class="subheading"><msg:message code="page.contribute.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="row mb-5">
            <div class="col-md-8 col-xl-6 text-center mx-auto" style="width: 90%;font-family: Abel, sans-serif;">
                <h2 class="divider-style"><span><msg:message code="page.contribute.biglabel"/></span></h2>
                <p class="text-start w-lg-50" style="font-family: 'Open Sans', sans-serif;"><br/><br/><span
                        style="color: rgb(0, 0, 0); background-color: transparent;">Mitmachen!</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Irgendwas mit Medien? Dann ist CampusFM das Radio für Dich! Wir suchen stets nach neuen Stimmen, die unser Radio vielfältiger, bunter und besser machen. Und diese Stimme kannst Du sein!</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Ob du in der Musikredaktion mitentscheidest welche Songs bei uns im Radio laufen, in der Wortredaktion zu unseren Inhalten beisteuerst, in der Onlineredaktion unsere Internetpräsenz aufrecht hältst oder als Technik-Zauberer unsere Sendeanlage betreust: das ist nur Dir überlassen!</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Wir erwarten keine journalistischen Vorkenntnisse, jedoch Kreativität, Offenheit, Zuverlässigkeit, Spaß am Texten und am Ausprobieren sowie Bereitschaft und Motivation, sich ehrenamtlich zu engagieren. Einzige bürokratische Hürde: ein Studierenden- oder Mitarbeiterausweis einer Universität oder Hochschule in NRW. Bei uns können leider nur Hochschulangehörige live on air gehen!</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">CampusFM – Dein Ausbildungsradio</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">CampusFM bietet nicht nur Radio, sondern seinen Mitgliedern auch eine kostenfreie Ausbildung! Wir führen intern Seminare durch, in denen wir die verschiedenen Beitragsformen erklären und praktische Tipps zu deren Erstellung geben. Ob du wissen willst, wie ein Kollegen-Gespräch funktioniert, wie dein Beitrag mit Original-Tönen besser wird, oder wie du deine Radiostimme am besten übst: CampusFM hilft dir weiter!</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Etwas erfahreneren Mitgliedern bieten wir außerdem die Möglichkeit durch Fortbildungen Moderator, Nachrichtensprecher oder Chef vom Dienst zu werden.</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Für alles andere können Mitglieder kostenlos Seminare von der Landesanstalt für Medien NRW besuchen, um weitere professionelle Ausbildungen zu bekommen. Diese werden immer wieder von bekannten Größen wie Olli Briesch durchgeführt.</span><br/>
                    <br/><span style="color: rgb(0, 0, 0); background-color: transparent;">Schreib uns eine Mail – mach mit!</span><br/>
                    <br/><a href="mailto:ausbildung@campusfm.info">ausbildung@campusfm.info</a><br/><br/><br/>
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