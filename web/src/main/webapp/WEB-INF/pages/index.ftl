<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js" xmlns="http://www.w3.org/1999/html"><!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>INDEX</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

  <script src="/js/angular.js"></script>
  <script src="/js/application.js"></script>
  <link rel="stylesheet" href="/css/bootstrap.css"/>

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
          <p>test</p>
        <#--<li <g:if test="${controllerName == 'home'}">class="active"</g:if>><a
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
-->
        </ul>

      </div>
    </div>
  </div>
</div>

<div class="container" ng-app="dental">

  count = --${count}--
<#list list as user>
  <div>
    <span>user.login = ${user.login}</span>
      <#assign profile = user.profile />
    <span>profile.firstname - ${profile.firstName}</span>
    <span>profile.lastname - ${profile.lastName}</span>
  </div>
</#list>


  <div id="search" ng-app="dentalSearch">
    <div ng-controller="SearchController as searchCtrl">
      message = {{searchCtrl.message}}


      <input type="text" ng-model="searchCtrl.q">
      <input type="text" ng-bind="searchCtrl.response.firstName">
      ++searchCtrl.q={{searchCtrl.q}}++
      <input type="button" ng-click="searchCtrl.search();">

      <div>
        {{searchCtrl.response.firstName}},
        {{searchCtrl.response.lastName}},
      </div>
      <ul>
      <#--<li ng-repeat="item as searchCtrl.result">-->
                    <#--<div>-->
                        <#--{{item.firstName}}-->
                    <#--</div>-->
                <#--</li>-->

      </ul>
    </div>


  </div>

  <a href="/auth/login">Login</a>
  <a href="/auth/signup">SignUp</a>
</div>

<div class="navbar navbar-default navbar-fixed-bottom">
  <div class="container">
    <p class="navbar-text pull-left">Copyright</p>
    <a class="navbar-btn btn btn-danger pull-right">Subscribe</a>
  </div>
</div>

</body>
</html>
