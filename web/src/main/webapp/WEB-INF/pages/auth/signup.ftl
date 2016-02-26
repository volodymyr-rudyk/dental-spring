<#import "../layout/basement.ftl" as base />

<@base.page title="SignUp" css=["header", "content"] js=["angular", "main-module", "signup-module"] >

<section class="white">
  <div class="container" ng-app="signup">
    <div ng-controller="SignupController as signupCtrl">
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
          <form role="form" ng-submit="signupCtrl.signup(signupForm.$valid)" name="signupForm" novalidate>
            <h2>Please Sign Up
              <small>It's free and always will be.</small>
            </h2>
            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : signupForm.firstName.$invalid && !signupForm.firstName.$pristine }">
                  <input type="text" name="firstName" ng-model="user.firstName" class="form-control input-lg"
                         placeholder="First Name" tabindex="1" ng-minlength="5" ng-maxlength="50">
                  <p ng-show="signupForm.firstName.$error.minlength || signupForm.firstName.$error.maxlength"
                     class="help-block">firstName 5-50 characters</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : signupForm.lastName.$invalid && !signupForm.lastName.$pristine }">
                  <input type="text" name="lastName" ng-model="user.lastName" class="form-control input-lg"
                         placeholder="Last Name" tabindex="2" ng-minlength="5" ng-maxlength="50">
                  <p ng-show="signupForm.lastName.$error.minlength || signupForm.lastName.$error.maxlength"
                     class="help-block">lastName 5-50 characters</p>
                </div>
              </div>
            </div>
            <#--<div class="form-group"-->
                 <#--ng-class="{ 'has-error' : signupForm.middleName.$invalid && !signupForm.middleName.$pristine }">-->
              <#--<input type="text" name="middleName" ng-model="user.middleName" class="form-control input-lg"-->
                     <#--placeholder="Middle Name" tabindex="3" ng-minlength="5" ng-maxlength="50">-->
              <#--<p ng-show="signupForm.middleName.$error.minlength || signupForm.middleName.$error.maxlength"-->
                 <#--class="help-block">middleName 5-50 characters</p>-->
            <#--</div>-->
            <#--<div class="form-group"-->
                 <#--ng-class="{ 'has-error' : signupForm.birthday.$invalid && signupForm.birthday.$touched }">-->
              <#--<input type="date" name="birthday" ng-model="user.birthday" class="form-control input-lg"-->
                     <#--placeholder="Birthday" tabindex="4" ng-required="true">-->
              <#--<p ng-show="signupForm.birthday.$invalid && signupForm.birthday.$touched"-->
                 <#--class="help-block">Select birthday</p>-->
            <#--</div>-->
            <#--<div class="form-group"-->
                 <#--ng-class="{ 'has-error' : signupForm.address.$invalid && !signupForm.address.$pristine }">-->
              <#--<input type="text" name="address" ng-model="user.address" class="form-control input-lg"-->
                     <#--placeholder="Address" tabindex="5" ng-required="true">-->
              <#--<p ng-show="signupForm.address.$invalid && !signupForm.address.$pristine"-->
                 <#--class="help-block">Address required</p>-->
            <#--</div>-->
            <div class="form-group"
                 ng-class="{ 'has-error' : signupForm.email.$invalid && !signupForm.email.$pristine }">
              <input type="email" name="email" ng-model="user.email" class="form-control input-lg"
                     placeholder="Email Address" tabindex="6" ng-required="true" ng-minlength="5" ng-maxlength="50">
              <p ng-show="signupForm.email.$invalid && !signupForm.email.$pristine"
                 class="help-block">Email is required</p>
            </div>
            <#--<div class="form-group">-->
              <#--<input type="phone" name="phone" ng-model="user.phone" class="form-control input-lg" placeholder="Phone"-->
                     <#--tabindex="7">-->
            <#--</div>-->
            <div class="form-group">
              <input type="password" name="password" ng-model="user.password" class="form-control input-lg"
                     placeholder="Password" tabindex="8" ng-minlength="8" ng-maxlength="50">
              <p ng-show="signupForm.password.$invalid && !signupForm.password.$pristine"
                 class="help-block">Password 8-50</p>
            </div>
            <#--<div class="row">-->
              <#--<div class="col-xs-4 col-sm-3 col-md-3">-->
					<#--<span class="button-checkbox">-->
						<#--<button type="button" class="btn" data-color="info" tabindex="7">I Agree</button>-->
                        <#--<input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">-->
					<#--</span>-->
              <#--</div>-->
              <#--<div class="col-xs-8 col-sm-9 col-md-9">-->
                <#--By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="#"-->
                                                                                                       <#--data-toggle="modal"-->
                                                                                                       <#--data-target="#t_and_c_m">Terms-->
                <#--and Conditions</a> set out by this site, including our Cookie Use.-->
              <#--</div>-->
            <#--</div>-->

            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-md-12">
                <#--<input type="submit" value="Register" class="btn btn-primary btn-block btn-lg">-->
                <input type="submit" class="col-md-5 btn-lg btn btn-default pull-right" ng-disabled="signupForm.$invalid" name="submit"
                       value="Register"/>
              </div>

              <#--<div class="col-xs-12 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg">Sign In</a></div>-->
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

</section>
</@base.page>
