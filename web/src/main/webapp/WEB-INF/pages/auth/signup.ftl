<#import "../layout/basement.ftl" as base />

<@base.page title="SignUp" css=["header", "content"] js=["angular", "main-module", "signup-module"] >

<section class="white">
  <div class="container" ng-app="signup">
    <div ng-controller="SignupController as signupCtrl">
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
          <form role="form" ng-submit="signupCtrl.signup()" name="signupForm" novalidate>
            <h2>Please Sign Up
              <small>It's free and always will be.</small>
              {{signupCtrl.data}}
            </h2>
            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group">
                  <input type="text" name="firstName" ng-model="user.firstName" class="form-control input-lg"
                         placeholder="First Name"
                         tabindex="1">
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group">
                  <input type="text" name="lastName" ng-model="user.lastName" class="form-control input-lg"
                         placeholder="Last Name"
                         tabindex="2">
                </div>
              </div>
            </div>
            <div class="form-group">
              <input type="text" name="middleName" ng-model="user.middleName" class="form-control input-lg"
                     placeholder="Middle Name"
                     tabindex="3">
            </div>
            <div class="form-group">
              <input type="text" name="displayName" class="form-control input-lg" placeholder="Display Name"
                     tabindex="4">
            </div>
            <div class="form-group">
              <input type="date" name="birthdate" ng-model="user.birthday" class="form-control input-lg"
                     placeholder="Birthday"
                     tabindex="5">
            </div>
            <div class="form-group">
              <input type="email" name="email" ng-model="user.email" class="form-control input-lg"
                     placeholder="Email Address"
                     tabindex="6">
            </div>
            <div class="form-group">
              <input type="phone" name="phone" ng-model="user.phone" class="form-control input-lg" placeholder="Phone"
                     tabindex="7">
            </div>
            <div class="row">
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group">
                  <input type="password" name="password" ng-model="user.password" class="form-control input-lg"
                         placeholder="Password" tabindex="8">
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group">
                  <input type="password" name="confirmPassword" ng-model="user.confirmPassword"
                         class="form-control input-lg" placeholder="Confirm Password" tabindex="9">
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn" data-color="info" tabindex="7">I Agree</button>
                        <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
					</span>
              </div>
              <div class="col-xs-8 col-sm-9 col-md-9">
                By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="#"
                                                                                                       data-toggle="modal"
                                                                                                       data-target="#t_and_c_m">Terms
                and Conditions</a> set out by this site, including our Cookie Use.
              </div>
            </div>

            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-md-6">
                <input type="submit" value="Register" class="btn btn-primary btn-block btn-lg"></div>
              <div class="col-xs-12 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg">Sign In</a></div>
            </div>
          </form>
        </div>
      </div>
      <!-- Modal -->
      <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
           aria-hidden="true">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">?</button>
              <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
            </div>
            <div class="modal-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at
                sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus
                quidem
                dolorem ad.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
    </div>
  </div>

</section>
</@base.page>
