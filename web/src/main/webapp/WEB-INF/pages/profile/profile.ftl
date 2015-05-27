<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<#--<link rel="shortcut icon" href=" ${assetPath(src: 'favicon.ico')}" type="image/x-icon">-->
<#--<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">-->
<#--<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">-->
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>

<body>

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
                <a href="#" class="navbar-brand">Dentalbook.com</a>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <a href="#">edit</a>
                </ul>

            </div>
        </div>
    </div>
</div>

<div class="container">
${profile.firstName}


<div class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <p class="navbar-text pull-left">Copyright</p>
        <a class="navbar-btn btn btn-danger pull-right">Subscribe</a>
    </div>
</div>

</body>
</html>
