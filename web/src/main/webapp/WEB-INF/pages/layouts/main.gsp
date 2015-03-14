<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>

<body>

%{--header--}%
<div style="margin-bottom: 51px;">
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="${createLink(controller: 'home')}" class="navbar-brand">Dentalbook.com</a>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li <g:if test="${controllerName == 'home'}">class="active"</g:if>><a
                            href="${createLink(controller: 'home')}">Home</a></li>

                    <sec:ifLoggedIn>
                        <sec:ifAnyGranted roles="ROLE_USER">

                        </sec:ifAnyGranted>

                        <sec:ifAnyGranted roles="ROLE_DENTIST">
                            <li <g:if test="${controllerName == 'patient'}">class="active"</g:if>>
                                <a href="${createLink(controller: 'patient')}">Patients</a></li>
                            <li <g:if test="${controllerName == 'profile'}">class="active"</g:if>>
                                <a href="${createLink(controller: 'profile')}">Profile</a></li>
                        </sec:ifAnyGranted>

                        <li><a href="${createLink(controller: 'auth', action: 'doLogout')}">Log out</a></li>
                    </sec:ifLoggedIn>

                </ul>

            </div>
        </div>
    </div>
</div>

<div class="container" style="margin-bottom: 40px">
    <g:layoutBody/>
</div>

<div class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <p class="navbar-text pull-left">Copyright</p>
        <a class="navbar-btn btn btn-danger pull-right">Subscribe</a>
    </div>
</div>

</body>
</html>
