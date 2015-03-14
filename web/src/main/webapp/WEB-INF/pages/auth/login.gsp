<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 6/1/2014
  Time: 2:42 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login</title>
    <asset:stylesheet src="application.css"/>
</head>

<body>

<g:if test="${flash.message}">
    <div style="border: 2px solid red">
        ${flash?.message}
    </div>
</g:if>

<g:if test="${flash.succeed}">
    <div style="border: 2px solid green">
        ${flash?.succed}
    </div>
</g:if>

<g:form class="form-signin" role="form" action="doLogin" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input class="form-control" placeholder="email" required autofocus id="login" type='email'
           name='username'/>
    <input class="form-control" placeholder="password" required id="password" type='password' name='password'/>

    <label class="checkbox pull-right">
        <g:checkBox name="remember" value="${true}"/>remember
    </label>
    <g:submitButton class="btn btn-primary btn-lg btn-block" name="submit" value="Submit"/><br>
    <a class="btn btn-link " href="<g:createLink action="signup"/>">signup</a>
</g:form>
</body>
</html>
