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
                    patient-id="{{patient.id}}" tooth-id="{{tooth.id}}"></tooth>
            <tooth class="btn tooth blue" ng-repeat="tooth in patient.teethUR | orderBy : '+toothNumber'"></tooth>
          </div>
          <div class="row text-center">
            <tooth class="btn tooth blue" ng-repeat="tooth in patient.teethDL | orderBy : '-toothNumber'"></tooth>
            <tooth class="btn tooth blue" ng-repeat="tooth in patient.teethDR | orderBy : '+toothNumber'"></tooth>
          </div>
        </div>
      </div>

      <#--Cures-->

      <div class="text-center" ng-show="selectedTooth">
        <div ng-controller="ToothController as toothCtrl">
          <h3>Cures</h3>
          <hr class="colorgraph">
          <div class="form-inline">
            <div class="form-group">
              <#--<input type="text" ng-model="toothCure" class="form-control">-->
              <textarea type="text" cols="90" rows="3" ng-model="toothCure" class="form-control"></textarea>
                <button type="button" ng-click="toothCtrl.addCure(toothCure)" class="btn btn-small">Add Cure              </button>

            </div>
          </div>
          <div ng-repeat="cure in selectedTooth.cures | orderBy : '-id' ">
            <div class="row alert alert-warning">

              <div class="col-md-9">{{cure.cure}}</div>
              <div class="col-md-3 btn btn-info">{{cure.createdOn | date : 'yyyy-MM-dd HH:mm'}}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>