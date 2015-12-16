<#import "../layout/basement.ftl" as base />

<@base.page title="Login" css=["header", "content", "signin"] js=["angular", "main-module", "dashboard-module"]>

<section class="white">
  <div class="container" ng-app="dashboard">
    <div ng-controller="DashboardController as dashboardCtrl">
      <input type="text" ng-model="user.firstName"></input>
      <span ng-model="firstName"></span>
      <span ng-bind="user.lastName"></span>
      <span ng-bind="lastName"></span>
      <span ng-bind="lastName">{{user.firstName}}</span>
    </div>
  </div>
</section>
<script type="application/javascript">
  window.user = {
    firstName: "${profile.firstName}",
    middleName: "${profile.middleName}",
    lastName: "${profile.lastName}",
    birthday: "${profile.birthday}",
    phone: "${profile.phone}",
    email: "${profile.user.email}"
  };
  console.log(user);
</script>



</@base.page>