<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Learzing is a new level of education.">
    <title>Dental</title>
</head>

<body class="main-page">

<div class="container">

    <h3>Enter your email to get notified on release.</h3>

    <div><a class="btn btn-primary" href="${createLink(controller: 'about')}">About.</a>
        <a class="btn btn-primary" href="${createLink(controller: 'home')}">Home</a>
        <a class="btn btn-primary" href="${createLink(controller: 'auth', action: 'login')}">login</a>
        <a class="btn btn-primary" href="${createLink(controller: 'auth', action: 'signup')}">signup</a>
    </div>

    <div class="row " style="margin-top: 250px;">
        <div class="col-md-6 col-sm-12 col-md-offset-3">
            <g:form controller="notify" action="addNotifyEmail" class="form-horizontal " role="form">
                <div class="form-group">
                    <div class="col-md-7 col-sm-6 col-sm-offset-1 col-md-offset-0">
                        <input class="form-control input-lg" name="mail" type="email" placeholder="Email:" required>
                    </div>

                    <div class="col-md-5 col-sm-4">
                        <button type="submit"
                                class="btn btn-success btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOTIFY&nbsp;ME&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </div>
                </div>
            </g:form>
            <strong><span id="subscribeFormResult" class="alertMsg"></span></strong>
        </div>
    </div>
</div>

</body>
</html>
