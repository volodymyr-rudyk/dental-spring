<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Patients" css=["header", "content"]
js=["main-module", "patient-module", "bootstrap"] bowerdist=["jquery"] bower=["angular", "angular-route"]>

<section class="white" ng-app="patient">
  <div class="container" ng-controller="PatientController">
    <div class="row">
      <div class="col-md-2">
        <div class="list-group">
          <div class="list-group-item-heading">Menu</div>
          <a href="#/" class="list-group-item">Patients</a>
          <a href="#new" class="list-group-item">New</a>
        </div>
      </div>

      <div ng-view></div>

    </div>
  </div>
</section>


</@base.page>