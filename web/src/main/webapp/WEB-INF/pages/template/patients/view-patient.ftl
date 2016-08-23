<div class="white">
  <div>
    <div>
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-12">
          <div class="text-center">
            <h1 >{{patient.firstName}} {{patient.lastName}}</h1>
            <span>{{patient.birthday}}</span>
            <span>{{patient.phone}}</span>
          </div>
          <div class="row text-center">
            <tooth class="btn tooth blue" ng-repeat="tooth in patient.teethUL | orderBy : '-toothNumber'" ng-init="patientId=patient.id">
              <#--{{t.toothNumber}}-->
            </tooth>
            <tooth class="btn tooth red" ng-repeat="tooth in patient.teethUR | orderBy : '+toothNumber'">
              <#--{{t.toothNumber}}-->
            </tooth>
          </div>
          <div class="row text-center ">
            <tooth class="btn tooth orange" ng-repeat="tooth in patient.teethDL | orderBy : '-toothNumber'">
              <#--{{t.toothNumber}}-->
            </tooth>
            <tooth class="btn tooth green" ng-repeat="tooth in patient.teethDR | orderBy : '+toothNumber'">
              <#--{{t.toothNumber}}-->
            </tooth>
          </div>
        </div>
      </div>
    </div>

  </div>