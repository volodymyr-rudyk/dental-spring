<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Profile" css=["header", "content"]
js=["main-module", "profile-module", "dropdown", "bootstrap"] bowerdist=["jquery"] bower=[angular"]>

<section class="white">
  <div class="container" ng-app="profile">
    <div ng-controller="ProfileController as profileCtrl">
{{user.birthday}}
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
          <form role="form" ng-submit="profileCtrl.updateProfile()" name="profileForm" novalidate>
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
              <input type="date" name="birthdate" ng-model="user.birthday | date" class="form-control input-lg"
                     placeholder="Birthday"
                     tabindex="5">
            </div>
            <div class="form-group">
              <input type="email" name="email" ng-disabled="true" ng-model="user.email" class="form-control input-lg"
                     placeholder="Email Address"
                     tabindex="6">
            </div>
            <div class="form-group">
              <input type="phone" name="phone" ng-model="user.phone" class="form-control input-lg" placeholder="Phone"
                     tabindex="7">
            </div>

            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-md-6 pull-right"><a href="#" class="btn btn-success btn-block btn-lg">Update</a></div>
            </div>
          </form>
        </div>
      </div>
    </div>




  </div>
  </div>
</section>
<script type="application/javascript">
  window.user = {
    firstName: "${dentist.firstName!""}",
    lastName: "${dentist.lastName!""}",
    middleName: "${dentist.middleName!""}",
    birthday: "${dentist.birthday!""}",
    phone: "${dentist.phone!""}",
    email: "${dentist.user.email!""}"
  };
  console.log(user);
</script>

</@base.page>