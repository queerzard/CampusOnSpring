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
    <title><msg:message code="page.about.title"/></title>
    <%@ include file="common/head.jspf" %>
    <%@ include file="common/navigation.jspf" %>


    <header class="masthead"
            style="background: url(&quot;assets/img/banner.png&quot;) center / cover no-repeat; ">
        <div class="overlay">

        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="site-heading">
                        <h1><msg:message code="page.about.biglabel"/></h1>
                        <span class="subheading"><msg:message code="page.about.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="row mb-5">
            <div class="col-md-8 col-xl-6 text-center mx-auto" style="width: 90%;font-family: Abel, sans-serif;"><img
                    src="/assets/img/teamimage.png" style="width: 100%;"/>
                <hr>
                <h2 class="divider-style"><span><msg:message code="page.about.biglabel"/></span></h2>
                <p class="text-start w-lg-50" style="font-family: 'Open Sans', sans-serif;"><br/><span
                        style="color: rgb(0, 0, 0); background-color: transparent;">
                Das sind wir!</span><br/>
                    <span style="color: rgb(0, 0, 0); background-color: transparent;">Ein bunter Haufen engagierter Studis, die Radio machen lieben!</span><br/><br/><span
                            style="color: rgb(0, 0, 0); background-color: transparent;">Wir kommen aus den verschiedensten Fachschaften, wachsen als Team aber ständig weiter zusammen!</span><br/><br/><span
                            style="color: rgb(0, 0, 0); background-color: transparent;">CampusFM ist komplett selbst organisiert, was uns neben kreativer Freiheit auch die Möglichkeit bietet, in vielen verschiedenen Bereichen zu arbeiten. </span><br/><br/><span
                            style="color: rgb(0, 0, 0); background-color: transparent;">So kann jede*r die eigenen Stärken ausspielen und Neues lernen! </span><br/><span
                            style="color: rgb(0, 0, 0); background-color: transparent;">Wenn du Lust hast, mal bei uns reinzuschnuppern, dann melde dich doch gerne mit einer einfachen Mail bei unserem Personalchef. </span><br/><br/><br/>
                </p>
                <div style="text-align: center;">
                    <hr>
                    <h2 class="divider-style"><span><msg:message code="page.about.team"/></span></h2>
                </div>
                <div class="container py-4 py-xl-5">
                    <div class="row text-center">

                        <c:forEach items="${userEntityList}" var="userEntity">

                            <!-- Team item -->
                            <div class="col-xl-3 col-sm-6 mb-5">
                                <div class="bg-white rounded shadow-sm py-5 px-4">
                                    <img src="data:image/png;base64, ${userEntity.base64Avatar}" alt=""
                                         style="overflow: hidden; object-fit: cover; width: 128px; height: 128px;"
                                         width="128" height="128" class="img-fluid rounded-circle mb-3 shadow-sm">
                                    <a href="/author/${userEntity.username}"><h5
                                            class="mb-0">${userEntity.firstName} ${userEntity.lastName}</h5></a><span
                                        class="small text-uppercase text-muted">${userEntity.position}</span></br>
                                    <ul class="social mb-0 list-inline mt-3">
                                        <li class="list-inline-item"><a href="${userEntity.social}" class="social-link"><i
                                                class="fa fa-solid fa-at"></i></a></li>

                                    </ul>
                                </div>
                            </div>
                            <!-- End -->


                        </c:forEach>
                    </div>

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


    <%@ include file="common/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"></script>
    <script src="/assets/js/script.min.js"></script>
    </body>
</html>