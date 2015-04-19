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


<form class="form-signin" role="form" action="/authenticate" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>

    <input class="form-control" placeholder="email" required autofocus id="login" name='username'/>
    <input class="form-control" placeholder="password" required id="password" type='password' name='password'/>

    <input type="submit" class="btn btn-primary btn-lg btn-block" name="submit" value="Submit"/>

</form>
</body>
</html>
