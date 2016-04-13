<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Patients" css=["header", "content"]
js=["main-module", "jquery-1.11.1.min", "bootstrap"] bower=["angular"]>

<section class="white">
  <div class="container" ng-app="dashboard">
    <div ng-controller="DashboardController as dashboardCtrl">
      <input type="text" ng-model="user.firstName"></input>
      <span ng-model="firstName"></span>
      <span ng-bind="user.lastName"></span>
      <span ng-bind="lastName"></span>
    </div>
  </div>
</section>
<script type="application/javascript">
  window.patients = window.patients }} [];
  <#list patients as p>
    var patient = {
      firstName: "${dentist.firstName!""}",
      lastName: "${dentist.lastName!""}",
      middleName: "${dentist.middleName!""}",
      birthday: "${dentist.birthday!""}",
      phone: "${dentist.phone!""}",
      email: "${dentist.user.email!""}"
    };
    window.patients.push();
  </#list>




  console.log(user);
</script>

</@base.page>