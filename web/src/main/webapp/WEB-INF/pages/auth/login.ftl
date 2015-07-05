<#import "../layout/basement.ftl" as base />

<@base.page "Login Page">
<div class="container">
    <form class="form-signin col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-2"
          role="form" action="/auth/authenticate" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <#--<#if errors>-->
            <#--<p class="bg-danger">Incorrect value</p>-->
        <#--</#if>-->
        <input class="form-control" placeholder="email" required autofocus id="login" name='username'/>
        <input class="form-control" placeholder="password" required id="password" type='password' name='password'/>
        <div id="remember" class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <input type="submit" class="btn btn-primary btn-block" name="submit" value="Submit"/>
        <a href="#" class="forgot-password">
            Forgot the password?
        </a>
    </form>
</div>
</@base.page>