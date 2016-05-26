<#import "../layout/basement.ftl" as base />

<@base.page title="Login" css=["header", "content", "signin", "validation"]
js=["main-module", "auth-module"] bowerdist=["jquery"] bower=["angular"]>

<section class="white">
  <div class="container" ng-app="auth">
    <div ng-controller="LoginController as loginCtrl">
      <form class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4"
            role="form" ng-submit="loginCtrl.login(loginForm.$valid)" name="loginForm" novalidate>
        <h3 class="text-center">Sign in</h3>
        <p class="text-center text-danger" ng-show="response.code < 0 || loginForm.email.$error.required"
           ng-bind="response.message"></p>
        <div class="list-group">
          <div class="list-group-item form-group"
               ng-class="{'has-error': loginForm.email.$invalid && !loginForm.email.$pristine}">
            <input class="form-control input-lg" ng-model="user.email" placeholder="email"
                   autofocus id="email" name="email" type="email" ng-required="true"/>
          </div>
          <div class="list-group-item form-group"
               ng-class="{'has-error': loginForm.password.$error.minlength || loginForm.password.$error.maxlength}">
            <input class="form-control input-lg" ng-model="user.password" placeholder="password"
                   id="password" type="password" name="password" ng-minlength="5" ng-maxlength="50" min="5"
                   ng-required="true"/>
          </div>
          <div class="list-group-item">
            <input type="submit" value="Login" class="form-control btn btn-primary" ng-disabled="loginForm.$invalid"/>
          </div>
          <div class="list-group-item">
            <a class="btn" href="/forgot-password">Forgot the password?</a>
            <a class="btn pull-right" href="/signup">Sign Up</a>
          </div>
        </div>
      </form>
    </div>
  </div>
</section>

</@base.page>