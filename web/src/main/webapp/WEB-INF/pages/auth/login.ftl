<%--
  Created by IntelliJ IDEA.
  User: light
  Date: 6/1/2014
  Time: 2:42 PM
--%>

<html>
<head>
    <title>Custom Login Page</title>
</head>

<body>
<h1>Custom Login Page</h1>


<form class="form-signin" role="form" action="doLogin" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input class="form-control" placeholder="email" required autofocus id="login" type='email'
           name='username'/>
    <input class="form-control" placeholder="password" required id="password" type='password' name='password'/>

    <label class="checkbox pull-right">
        <checkBox name="remember" value=""/>remember
    </label>
    <submitButton class="btn btn-primary btn-lg btn-block" name="submit" value="Submit"/><br>
    <a class="btn btn-link " href="signup">signup</a>
</form>
</body>
</html>
