<#import "../layout/loggedbasement.ftl" as base />

<@base.page dentist=dentist title="Patients" css=["header", "content"]
js=["main-module", "patient-module"] bowerdist=["jquery"] bower=["angular", "angular-route"]>

<section class="white" ng-app="patient">
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <div class="list-group">
          <a href="#/" class="list-group-item"><span class="glyphicon glyphicon-option-vertical"></span> Patients</a>
          <a href="#new" class="list-group-item"><span class="glyphicon glyphicon-plus"></span> New</a>
        </div>
      </div>
      <div ng-view class="col-md-10"></div>
    </div>
  </div>
</section>

</@base.page>