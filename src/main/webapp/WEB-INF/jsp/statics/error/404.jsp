<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>

<%--
  ~ Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
  ~ All rights reserved.
  --%>

<style type="text/css">


    h1,h2,h3,h4,h5,h6,p
    {
        margin: 0px;
        padding: 0px;
    }

    .error_container
    {
        font-family: 'Rubik', sans-serif;
        width: 100%;
        height: 100vh;
    }

    .error_block
    {
        width: 40%;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
        text-align: center;
    }

    .error_block h1
    {
        font-size: 80px;
        color: #3f3a64;
    }

    .error_block h3
    {
        font-size: 40px;
        color: #3f3a64;
    }

    .error_btn
    {
        width: 250px;
        height: 45px;
        background: #20ad96;
        border:none;
        border-radius: 5px;
        color: #fff;
        font-size: 18px;
        font-weight: 600;
        margin-top: 30px;
        cursor: pointer;
    }

</style>

<div class="error_container">
    <div class="error_block">
        <h1>404</h1>
        <h3><msg:message code="page.notfound.nosignal"/></h3>
        <p><msg:message code="page.notfound.tune"/></p>
        <a href="/home"><input type="button" class="error_btn" value="<msg:message code="page.notfound.freq"/>"></a>
    </div>
</div>