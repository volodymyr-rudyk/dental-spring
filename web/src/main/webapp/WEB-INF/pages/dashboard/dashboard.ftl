<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Dashboard" css=["header", "content", "signin"]
js=["main-module", "dashboard-module", "bootstrap"] bowerdist=["jquery"] bower=["angular"]>

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
  <#--window.dentist = ${bootstrap};-->
</script>

</@base.page>