<div class="white">
  <div ng-app="">
    <div ng-controller="NewPatientController as npCtrl">
      <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-9">
          <form role="form" ng-submit="npCtrl.create(newPatientForm.$valid)" name="newPatientForm" novalidate>
            <h3>New Patient</h3>
            <div ng-show="success">{{ success }}</div>
            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.firstName.$invalid && !newPatientForm.firstName.$pristine }">
                  <input type="text" name="firstName" ng-model="patient.firstName" class="form-control input-md"
                         placeholder="First Name" tabindex="1" ng-minlength="5" ng-maxlength="50">
                  <p ng-show="newPatientForm.firstName.$error.minlength || newPatientForm.firstName.$error.maxlength"
                     class="help-block">firstName 5-50 characters</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.lastName.$invalid && !newPatientForm.lastName.$pristine }">
                  <input type="text" name="lastName" ng-model="patient.lastName" class="form-control input-md"
                         placeholder="Last Name" tabindex="2" ng-minlength="5" ng-maxlength="50">
                  <p ng-show="newPatientForm.lastName.$error.minlength || newPatientForm.lastName.$error.maxlength"
                     class="help-block">lastName 5-50 characters</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.middleName.$invalid && !newPatientForm.middleName.$pristine }">
                  <input type="text" name="middleName" ng-model="patient.middleName" class="form-control input-md"
                         placeholder="Middle Name" tabindex="3" ng-minlength="5" ng-maxlength="50">
                  <p ng-show="newPatientForm.middleName.$error.minlength || newPatientForm.middleName.$error.maxlength"
                     class="help-block">middleName 5-50 characters</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.birthday.$invalid && newPatientForm.birthday.$touched }">
                  <input type="date" name="birthday" ng-model="patient.birthday" class="form-control input-md"
                         placeholder="Birthday" tabindex="4" ng-required="true">
                  <p ng-show="newPatientForm.birthday.$invalid && newPatientForm.birthday.$touched"
                     class="help-block">Select birthday</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.address.$invalid && !newPatientForm.address.$pristine }">
                  <input type="text" name="address" ng-model="patient.address" class="form-control input-md"
                         placeholder="Address" tabindex="5" ng-required="true">
                  <p ng-show="newPatientForm.address.$invalid && !newPatientForm.address.$pristine"
                     class="help-block">Address required</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.gender.$invalid && !newPatientForm.gender.$pristine }">
                  <select name="gender" ng-model="patient.gender" class="form-control input-md"
                          placeholder="Gender" tabindex="5" ng-required="true">
                    <option name="gender" value="Male">Male</option>
                    <option name="gender" value="Female">Female</option>
                  </select>
                  <p ng-show="newPatientForm.gender.$invalid && !newPatientForm.gender.$pristine"
                     class="help-block">gender required</p>
                </div>
              </div>
              <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group"
                     ng-class="{ 'has-error' : newPatientForm.phone.$invalid && !newPatientForm.phone.$pristine }">
                  <input type="phone" name="phone" ng-model="patient.phone" class="form-control input-md"
                         placeholder="Phone" tabindex="6">
                  <p ng-show="newPatientForm.phone.$invalid && !newPatientForm.phone.$pristine"
                     class="help-block">Phone incorrect</p>
                </div>
              </div>
            </div>
            <hr class="colorgraph">
            <div class="row">
              <div class="col-xs-12 col-md-12">
                <input type="submit" class="col-md-5 btn-md btn btn-success pull-right"
                       ng-disabled="newPatientForm.$invalid" name="submit"
                       value="Add"/>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

</div>