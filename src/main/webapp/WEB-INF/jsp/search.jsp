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
    <title><msg:message code="page.search.title"/></title>
    <%@ include file="common/head.jspf" %>
    <%@ include file="common/navigation.jspf" %>


    <header class="masthead"
            style="background: url(&quot;assets/img/banner.png&quot;) center / cover no-repeat;">
        <div class="overlay">

        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="site-heading">
                        <h1>"${searchQuery}"</h1>
                        <span class="subheading">${searchResultCount} <msg:message code="page.search.results"/></span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8">

                <!-- PAGE MAIN CONTENT -->

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


    <%@ include file="common/footer.jspf" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/script.min.js"></script>
    </body>
</html>