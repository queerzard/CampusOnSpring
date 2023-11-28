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
    <title><msg:message code="page.author.title"/></title>
    <%@ include file="common/head.jspf" %>
    <%@ include file="common/navigation.jspf" %>


    <header class="masthead"
            style="background: url(&quot;/assets/img/banner.png&quot;) center / cover no-repeat; ">
        <div class="overlay">

        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="site-heading">
                        <h1>${userEntity.firstName} ${userEntity.lastName}</h1>
                        <span class="subheading"><msg:message code="page.author.sublabel"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="row mb-5">

            <div class="col-md-8 col-xl-6 text-center mx-auto" style="width: 90%;font-family: Abel, sans-serif;">
                <h2 class="divider-style"><span><msg:message code="page.author.biglabel"/></span></h2>
                <p class="text-start w-lg-50" style="font-family: 'Open Sans', sans-serif;">

                </p>
            </div>

            <c:forEach items="${articleEntitiesList}" var="article">

                <div class="post-preview"><a href="/article?a=${article.id}"><h2 class="post-title"
                                                                                 style="font-size: 32px;">${article.title}</h2>
                    <h3 class="post-subtitle" style="font-size: 20px;">${article.previewContent}</h3></a>
                    <p class="post-meta"><msg:message code="page.article.publishedBy"/>&nbsp;<a
                            href="/article?a=${article.id}">
                            ${article.userEntity.firstName} ${article.userEntity.lastName} <msg:message
                            code="page.article.publishedOn"/>
                            ${article.publishMonthName} ${article.publishDayOfMonth}, ${article.publishYear}</a></p>
                </div>
                <hr>
            </c:forEach>

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