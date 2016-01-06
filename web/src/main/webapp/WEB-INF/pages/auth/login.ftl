<#import "../layout/basement.ftl" as base />

<@base.page title="Login" css=["header", "content", "signin", "validation"]
js=["main-module", "login-module", "dropdown", "jquery-1.11.1.min", "bootstrap"] bower=["angular"]>

<section class="gray">
  <div class="container" ng-app="login">
    <div ng-controller="LoginController as loginCtrl">
      <form class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4"
            role="form" ng-submit="loginCtrl.login(loginForm.$valid)" name="loginForm" novalidate>
        <h3 class="text-center">Sign in</h3>
        <div>
          <p class="bg-danger error-dark" ng-show="response.code < 0 || loginForm.email.$error.required"
                ng-bind="response.message"></p>
          <input class="form-control bottom-buffer input-lg" ng-model="user.email" placeholder="email"
                 autofocus id="email" name="email" type="email" ng-required="true"/>
          <p ng-show="loginForm.email.$invalid && !loginForm.email.$pristine"
             class="help-block error">Email is required</p>
        </div>
          <input class="form-control bottom-buffer input-lg" ng-model="user.password" placeholder="password"
                 id="password" type="password" name="password" ng-minlength="5" ng-maxlength="50" min="5" ng-required="true"/>
        <p ng-show="loginForm.password.$error.minlength || loginForm.password.$error.maxlength"
        class="help-block error">Password 5-50 characters</p>
        <input type="submit" class="btn-lg btn btn-default pull-right" ng-disabled="loginForm.$invalid" name="submit" value="Login"/>
        </div>
      <#--<a href="/forgot-password">Forgot the password?</a>-->
      </form>
    </div>
  </div>
</section>

</@base.page>