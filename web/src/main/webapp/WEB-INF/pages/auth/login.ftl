<%--
Created by IntelliJ IDEA.
User: light
Date: 6/1/2014
Time: 2:42 PM
--%>

<!DOCTYPE html>
<head>

<head>
    <title>Custom Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/css/bootstrap.css">
</head>

<body>
<h1>Custom Login Page</h1>


<div class="container">
    <form class="form-signin" role="form" action="/authenticate" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>

        <input class="form-control" placeholder="email" required autofocus id="login" name='username'/>
        <input class="form-control" placeholder="password" required id="password" type='password' name='password'/>

        <input type="submit" class="btn btn-primary btn-lg btn-block" name="submit" value="Submit"/>

    </form>
</div>

<div class="container">
    <div class="card card-container">
        <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" />
        <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"/>

        <p id="profile-name" class="profile-name-card"></p>

        <form class="form-signin">
            <span id="reauth-email" class="reauth-email"></span>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>

            <div id="remember" class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
        </form>

        <a href="#" class="forgot-password">
            Forgot the password?
        </a>
    </div>
</div>


</body>
</html>
