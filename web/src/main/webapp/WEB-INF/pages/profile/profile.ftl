<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Profile" css=["header", "content"]
js=["main-module", "profile-module", "dropdown"] bowerdist=["jquery"] bower=["angular"]>

<section class="white">
  <div class="container" ng-app="profile">
    <div ng-controller="ProfileController as profileCtrl">
{{user.birthday}}
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
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