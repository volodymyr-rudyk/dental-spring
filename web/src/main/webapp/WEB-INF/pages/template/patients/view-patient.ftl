<div class="white">
  <div>
    <div ng-controller="ViewPatientController">
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-9">
          <h1>
            <div>{{patient.firstName}} {{patient.lastName}}</div>
          </h1>
          <tr ng-repeat="t in patient.teeth">
            {{t}}
          </tr>
        </div>
      </div>
    </div>

  </div>