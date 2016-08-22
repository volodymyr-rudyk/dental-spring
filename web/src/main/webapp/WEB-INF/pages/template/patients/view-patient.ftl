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
            <div class="btn tooth blue" ng-repeat="t in patient.teethUL | orderBy : '-toothNumber'">
              <#--{{t.toothNumber}}-->
            </div>
            <div class="btn tooth red" ng-repeat="t in patient.teethUR | orderBy : '+toothNumber'">
              <#--{{t.toothNumber}}-->
            </div>
          </div>
          <div class="row text-center ">
            <div class="btn tooth orange" ng-repeat="t in patient.teethDL | orderBy : '-toothNumber'">
              <#--{{t.toothNumber}}-->
            </div>
            <div class="btn tooth green" ng-repeat="t in patient.teethDR | orderBy : '+toothNumber'">
              <#--{{t.toothNumber}}-->
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>