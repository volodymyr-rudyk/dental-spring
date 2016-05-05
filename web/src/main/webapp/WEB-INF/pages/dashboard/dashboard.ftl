<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Dashboard" css=["header", "content", "signin"]
js=["main-module", "dashboard-module", "jquery-1.11.1.min", "bootstrap"] bower=["angular"]>

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
  window.dentist = {
    firstName: "${dentist.firstName!""}",
    lastName: "${dentist.lastName!""}",
    middleName: "${dentist.middleName!""}",
    birthday: "${dentist.birthday!""}",
    phone: "${dentist.phone!""}",
    email: "${dentist.user.email!""}"
  };
  console.log(dentist);
  dentist.patients = [];
  <#list patients as p>
    var patient = {}
    patient.id = "${p.id!""}"
    patient.firstName = "${p.firstName!""}"
    patient.middleName = "${p.middleName!""}"
    patient.lastName = "${p.lastName!""}"
    patient.address = "${p.address!""}"
    patient.birthday = "${p.birthday!""}"
    patient.gender = "${p.gender!""}"
    patient.phone = "${p.phone!""}"
    patients.push(patient);
  </#list>

</script>

</@base.page>