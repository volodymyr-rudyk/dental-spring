<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 28-Apr-14
  Time: 6:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main"/>
    <title>Signup</title>
</head>

<body>

<div class="container" style="margin-bottom: 85px">

    <div class="row col-md-6 col-md-offset-3 form-group">
        <h3 class="center">Create new Profile</h3>
        <g:form action="doSignup" method="post" role="form">
            <div class="form-group">
                <strong>FirstName</strong>
                <g:if test="${flash.errors?.getFieldError("firstname")}">
                    <p class="bg-danger">Incorrect value</p>
                </g:if>
                <g:textField class="form-control input-lg" type="text" name="firstname"/>
            </div>

            <div class="form-group">
                <strong>LastName</strong>
                <g:if test="${flash.errors?.getFieldError("lastname")}">
                    <p class="bg-danger">Incorrect value</p>
                </g:if>
                <g:textField class="form-control input-lg" type="text" name="lastname"/>
            </div>

            <div class="form-group">
                <strong>Patronimic</strong>
                <g:if test="${flash.errors?.getFieldError("patronimic")}">
                    <p class="bg-danger">Incorrect value</p>
                </g:if>
                <g:textField class="form-control input-lg" type="text" name="patronimic"/>
            </div>

            <div class="form-group">
                <g:radioGroup values="['male, female']" name="gender">
                    <g:radio name="gender" checked="checked" value="1" align="absmiddle"/>Male
                    <g:radio name="gender" value="0"/>Female
                </g:radioGroup>
            </div>

            <div class="form-group">
                <strong>login/email</strong>
                <g:if test="${flash.errors?.getFieldError("username")}">
                    <p class="bg-danger">Incorrect value</p>
                </g:if>
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <g:textField class="form-control input-lg" type="email" name="username"/>
                </div>
            </div>

            <div class="form-group">
                <strong>password</strong>
                <g:if test="${flash.errors?.getFieldError("password")}">
                    <p class="bg-danger">Incorrect value</p>
                </g:if>
                <g:textField class="form-control input-lg" type="password" name="password"/>
            </div>

            <g:submitButton class="btn btn-primary btn-lg col-md-4 pull-right" name="Submit"/>
        </g:form>
    </div>
</div>

</body>
</html>