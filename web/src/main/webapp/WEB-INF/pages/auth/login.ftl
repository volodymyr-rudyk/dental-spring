<#import "../layout/basement.ftl" as base />

<#--Message <@spring.message "test1" />-->

<@base.page title="Login Page" css=["signin"]>
<div class="container">
  <form class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-2"
        role="form" action="/auth/login" method="post">
    <h2 class="form-signin-heading">Sign in</h2>
    <#if validationErrors??>
      <div style="color: red; font-size: ">Incorrect username or password</div>
    <#--<#list validationErrors as e>-->
    <#--<div>Field : ${e.field} -> ${e.defaultMessage}</div>-->
    <#--</#list>-->
    </#if>
    <input class="form-control bottom-buffer" placeholder="email" required autofocus id="login" name='username'/>
    <input class="form-control bottom-buffer" placeholder="password" required id="password" type='password'
           name='password'/>
  <#--<div id="remember" class="checkbox">-->
  <#--<label>-->
  <#--<input type="checkbox" value="remember-me"> Remember me-->
  <#--</label>-->
  <#--</div>-->
    <input type="submit" class="btn btn-primary btn-block" name="submit" value="Submit"/>
    <a href="#" class="forgot-password">
      Forgot the password?
    </a>
  </form>
</div>
</@base.page>