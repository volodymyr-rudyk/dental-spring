<div class="white">
  <div>
    <div ng-controller="EditPatientController as epCtrl">
      <div>
        <div class="row">
          <div class="col-xs-12 col-sm-8 col-md-9">
            <form role="form" ng-submit="epCtrl.update(editPatientForm.$valid)" name="editPatientForm"
                  novalidate>
              <h3>Edit Patient</h3>
              <div ng-show="success">{{ success }}</div>
              <hr class="colorgraph">
              <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.firstName.$invalid && !editPatientForm.firstName.$pristine }">
                    <input type="text" name="firstName" ng-model="patient.firstName"
                           class="form-control input-md"
                           placeholder="First Name" tabindex="1" ng-minlength="5" ng-maxlength="50">
                    <p
                      ng-show="editPatientForm.firstName.$error.minlength || editPatientForm.firstName.$error.maxlength"
                      class="help-block">firstName 5-50 characters</p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.lastName.$invalid && !editPatientForm.lastName.$pristine }">
                    <input type="text" name="lastName" ng-model="patient.lastName"
                           class="form-control input-md"
                           placeholder="Last Name" tabindex="2" ng-minlength="5" ng-maxlength="50">
                    <p ng-show="editPatientForm.lastName.$error.minlength || editPatientForm.lastName.$error.maxlength"
                       class="help-block">lastName 5-50 characters</p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.middleName.$invalid && !editPatientForm.middleName.$pristine }">
                    <input type="text" name="middleName" ng-model="patient.middleName"
                           class="form-control input-md"
                           placeholder="Middle Name" tabindex="3" ng-minlength="5"
                           ng-maxlength="50">
                    <p
                      ng-show="editPatientForm.middleName.$error.minlength || editPatientForm.middleName.$error.maxlength"
                      class="help-block">middleName 5-50 characters</p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.birthday.$invalid && editPatientForm.birthday.$touched }">
                    <input type="date" name="birthday"
                           ng-model="patient.birthday | date:'yyyy-MM-dd'"
                           class="form-control input-md"
                           placeholder="Birthday" tabindex="4" ng-required="true">
                    <p ng-show="editPatientForm.birthday.$invalid && editPatientForm.birthday.$touched"
                       class="help-block">Select birthday</p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.address.$invalid && !editPatientForm.address.$pristine }">
                    <input type="text" name="address" ng-model="patient.address"
                           class="form-control input-md"
                           placeholder="Address" tabindex="5" ng-required="true">
                    <p ng-show="editPatientForm.address.$invalid && !editPatientForm.address.$pristine"
                       class="help-block">Address required</p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.gender.$invalid && editPatientFormm.gender.$pristine }">
                    <select name="gender" ng-model="patient.gender" class="form-control input-md"
                            placeholder="Gender" tabindex="5" ng-required="true">
                      <option name="gender" value="Male">Male</option>
                      <option name="gender" value="Female">Female</option>
                    </select>
                    <p ng-show="editPatientForm.gender.$invalid && !editPatientForm.gender.$pristine"
                       class="help-block">gender required</p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                  <div class="form-group"
                       ng-class="{ 'has-error' : editPatientForm.phone.$invalid && !editPatientForm.phone.$pristine }">
                    <input type="phone" name="phone" ng-model="patient.phone"
                           class="form-control input-md"
                           placeholder="Phone" tabindex="6">
                    <p ng-show="editPatientForm.phone.$invalid && !editPatientForm.phone.$pristine"
                       class="help-block">Phone incorrect</p>
                  </div>
                </div>
              </div>
              <hr class="colorgraph">
              <div class="row">
                <div class="col-xs-12 col-md-12">
                  <input type="submit" class="col-md-5 btn-md btn btn-success pull-right"
                         name="submit"
                         value="Add"/>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

  </div>