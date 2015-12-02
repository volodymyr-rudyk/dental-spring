<#import "../layout/basement.ftl" as base />

<@base.page title="Login" css=["header", "content", "signin"] js=["angular", "main-module", "login-module"]>

<section class="white">
  <div class="container" ng-app="login">
    <div ng-controller="LoginController as loginCtrl">
      <form class="col-xs-12 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3"
            role="form" ng-submit="loginCtrl.doLogin()" name="loginForm">
        <h2>Sign in</h2>
        <div>
          <span class="error" ng-show="response.code < 0" ng-bind="response.message"></span>
          <input class="form-control bottom-buffer" ng-model="user.email" placeholder="email" required autofocus id="email" name="email" type="email"/>
          <input class="form-control bottom-buffer" ng-model="user.password" placeholder="password" required
                 id="password"
                 type="password" name="password" min="6"/>
          <input type="submit" class="btn btn-primary btn-block" name="submit" value="Submit"/>
        </div>
        <a href="/forgot-password">Forgot the password?</a>
      </form>
    </div>
  </div>
</section>

</@base.page>