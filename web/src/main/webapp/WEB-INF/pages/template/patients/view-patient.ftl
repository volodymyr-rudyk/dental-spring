<div class="white">
  <div>
    <div>
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-12">
          <div class="text-center">
            <h1>{{patient.firstName}} {{patient.lastName}}</h1>
            <span>{{patient.birthday}}</span>
            <span>{{patient.phone}}</span>
          </div>
          <div class="row text-center">
            <tooth class="btn tooth blue" ng-repeat="tooth in patient.teethUL | orderBy : '-toothNumber'"
                   ng-init="patientId=patient.id"></tooth>
            <tooth class="btn tooth red" ng-repeat="tooth in patient.teethUR | orderBy : '+toothNumber'"></tooth>
          </div>
          <div class="row text-center">
            <tooth class="btn tooth orange" ng-repeat="tooth in patient.teethDL | orderBy : '-toothNumber'"></tooth>
            <tooth class="btn tooth green" ng-repeat="tooth in patient.teethDR | orderBy : '+toothNumber'"></tooth>
          </div>
        </div>
      </div>
      <div class="text-center" ng-show="selectedTooth">
        <div ng-controller="ToothController as toothCtrl">
          <h1>Cures</h1>
          <div class="form-inline">
            <div class="form-group">
              <input type="text" ng-model="toothCure" class="form-control">
            </div>
            <button type="button" ng-click="toothCtrl.addCure(toothCure)" class="btn btn-small">Add Cure
            </button>
          </div>
          <div ng-repeat="cure in selectedTooth.cures | orderBy : '-id' ">
            <div class="alert alert-danger">
              <div> id : {{cure.id}}</div>
              <div> cure : {{cure.cure}}</div>
              <div> created : {{cure.createdOn | date : 'yyyy-MM-dd HH:mm'}}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>