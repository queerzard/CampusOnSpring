<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<!DOCTYPE html>
<html>


<head>
    <title>${article.title}</title>
    <%@ include file="common/head.jspf" %>
    <%@ include file="common/navigation.jspf" %>

    <!-- START RELEVANT PAGE CONTENT -->

    <header class="masthead"
            style="background: url(&quot;data:image/png;base64, ${article.base64banner}&quot;) center / cover no-repeat;">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto position-relative">
                    <div class="post-heading">
                        <h1>${article.title}</h1>
                        <h2 class="subheading">${article.category}</h2><span class="meta"><msg:message
                            code="page.article.publishedBy"/>
                    <a href="/author/${article.userEntity.username}">${article.userEntity.firstName} ${article.userEntity.lastName}</a> <msg:message
                                code="page.article.publishedOn"/>
                    ${article.publishMonthName}
                    ${article.publishDayOfMonth},
                        ${article.publishYear}</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <div class="col-md-10 col-lg-8 mx-auto">
            ${article.contents}
        </div>

        <sec:authorize access="hasRole('ADMIN')">
            <button id="deleteArt">DELETE ARTICLE</button>
            <button id="takeDown">TAKE DOWN ARTICLE</button>
        </sec:authorize>

    </div>
    </br>


    <!-- END RELEVANT PAGE CONTENT -->


    <%@ include file="common/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/assets/js/script.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <sec:authorize access="hasRole('ADMIN')">

    <script>
        const urlSearchParams = new URLSearchParams(window.location.search);

        window.addEventListener('load', function () {
            postId = urlSearchParams.get("a")
        });


        $(document).on('click', '#takeDown', function () {
            // send the form data to the server
            $.ajax({
                type: 'POST',
                url: '/api/v1/article?article=' + postId + '&pub=false',
                dataType: 'json',
                encode: true
            })
                .done(function (response) {
                    // handle the server response
                    if (response.status == 200) {
                        console.log(response.message);
                        alert(response.message);
                        // redirect to the URL received from the server
                        setTimeout(() => {
                            window.location.href = '/';
                        }, 4000);
                    } else {
                        console.log(response.message);
                        alert(response.message);
                        // display an error message to the user
                    }
                });
        });

        $(document).on('click', '#deleteArt', function () {
            $.ajax({
                type: 'DELETE',
                url: '/api/v1/article?article=' + postId,
                dataType: 'json',
                encode: true
            })
                .done(function (response) {
                    // handle the server response
                    if (response.status <= 200) {
                        console.log(response.message);
                        alert(response.message);
                        // redirect to the URL received from the server
                        setTimeout(() => {
                            window.location.href = "/home";
                        }, 1200);
                    } else {
                        console.log(response.message + response.status);
                        alert(response.message);
                        // display an error message to the user
                    }
                });
        });
    </script>

    </sec:authorize>
    </body>
</html>