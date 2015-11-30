<!DOCTYPE html>
<html lang="en">
<head>
  <title>Custom Login Page</title>

  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body>
<h1>Admin Login Page</h1>

<a href="/logout">Logout</a>

<form class="form-signin" role="form" action="/authenticate" method="post">
  <h2 class="form-signin-heading">Please sign in</h2>

  <input class="form-control" placeholder="email" required autofocus id="email" name='username'/>
  <input class="form-control" placeholder="password" required id="password" type='password' name='password'/>

  <input type="submit" class="btn btn-primary btn-lg btn-block" name="submit" value="Submit"/>

</form>
</body>
</html>
