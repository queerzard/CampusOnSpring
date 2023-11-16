<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/assets/dashboard/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/dashboard/assets/css/styles.min.css">
</head>

<body>
<div class="container profile profile-view" id="profile"><nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/myprofile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/register">Register New Profile</a>
            </li>
        </ul>
    </div>
</nav>
    <div class="row">
        <div class="col-md-12 alert-col relative">
            <div class="alert alert-info alert-dismissible absolue center" role="alert"><button class="btn-close" type="button" aria-label="Close" data-bs-dismiss="alert"></button><span>Profile save with success</span></div>
        </div>
    </div>
    <form>
        <div class="row profile-row">
            <div class="col">
                <div class="row register-form"><div class="col-md-8 offset-md-2">
                    <form class="custom-form">
                        <h1>Create Member</h1>
                        <div class="row form-group">
                            <div class="col-sm-4 label-column"><label class="col-form-label" for="name-input-field">Username</label></div>
                            <div class="col-sm-6 input-column"><input class="form-control" type="text" /></div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-4 label-column"><label class="col-form-label" for="email-input-field">Email </label></div>
                            <div class="col-sm-6 input-column"><input class="form-control" type="email" /></div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-4 label-column"><label class="col-form-label" for="pawssword-input-field">Password </label></div>
                            <div class="col-sm-6 input-column"><input class="form-control" type="password" /></div>
                        </div><button class="btn btn-light submit-button" type="button">Submit Form</button>
                    </form>
                </div></div>
            </div>
        </div>
    </form>
</div>
<div class="list-group"></div>
<script src="/assets/dashboard/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>