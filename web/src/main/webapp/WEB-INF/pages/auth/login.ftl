<#import "../layout/basement.ftl" as base />

<@base.page title="Login" css=["header", "content", "signin", "validation"] js=["main-module", "login-module"] bower=["angular"]>

<section class="white">
  <div class="container" ng-app="login">
    <div ng-controller="LoginController as loginCtrl">
      <form class="col-xs-12 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3"
            role="form" ng-submit="loginCtrl.login()" name="loginForm" novalidate>
        <h2>Sign in</h2>
        <div>
          <span class="error" ng-show="response.code < 0 || loginForm.email.$error.required"
                ng-bind="response.message"></span>
          <#--<span class="error" ng-show="loginForm.email.$error.required">Email required</span>-->
          <input class="has-success form-control bottom-buffer " ng-model="user.email" placeholder="email"
                 autofocus id="email" name="email" type="email" ng-required="true"/>
          <input class="form-control bottom-buffer" ng-model="user.password" placeholder="password"
                 id="password" type="password" name="password" min="6" ng-required="true"/>
          <input type="submit" class="btn btn-primary btn-block" name="submit" value="Submit"/>
        </div>
        <a href="/forgot-password">Forgot the password?</a>
      </form>
    </div>
  </div>
</section>

</@base.page>