angular.module('patient', ['ngRoute', 'dental'])
  .config(function ($routeProvider) {
    $routeProvider
    // route for the home page
      .when('/', {
        templateUrl: '/template/patients/patients',
        controller: 'PatientController'
      })
      .when('/new', {
        templateUrl: '/template/patients/add-patient',
        controller: 'NewPatientController'
      })
      .when('/edit/:id', {
        templateUrl: '/template/patients/edit-patient',
        controller: 'EditPatientController'
      })
      .when('/view/:id', {
        templateUrl: '/template/patients/view-patient',
        controller: 'ViewPatientController'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
  .controller('PatientController', PatientController)
  .controller('NewPatientController', NewPatientController)
  .controller('EditPatientController', EditPatientController)
  .controller('ViewPatientController', ViewPatientController)
  .service('PatientService', PatientService);

// Controllers
function PatientController($scope, $http, PatientService) {
  PatientService.getAll().then(function (response) {
    $scope.dentist = response;
    console.log(response);
  }, function error(error) {
    console.error(error)
  });
}
function NewPatientController($scope, $http, PatientService) {
  $scope.patient = {};
  this.create = function (isValid) {
    if (isValid) {
      PatientService.create($scope.patient).then(function success(response) {
        $scope.success = "Added new Patient";
      }, function (error) {
      });
    }
  };
};
function EditPatientController($scope, $routeParams, PatientService) {
  $scope.patient = {};
  $scope.patient.id = $routeParams.id;

  PatientService.get($scope.patient).then(function (response) {
    $scope.patient = response;
    console.log(response);
  }, function error(error) {
    console.error(error)
  });

  this.update = function (isValid) {
    if (isValid) {
      PatientService.update($scope.patient).then(function success(response) {
        $scope.success = "Patient Edited";
        console.log($scope.success);
      }, function (error) {
      });
    }
  };
};
function ViewPatientController($scope, $routeParams, PatientService) {
  $scope.patient = {};
  $scope.patient.id = $routeParams.id;
debugger;
  PatientService.get($scope.patient).then(function (response) {
    $scope.patient = response;
    console.log(response);
  }, function error(error) {
    console.error(error)
  });
};

function PatientService($http, $q, Rest, ResponseHandlers) {
  this.getAll = function () {
    var defer = $q.defer();
    $http({
      url: Rest.patient,
      method: 'GET',
      data: {},
      headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.get = function (patient) {
    var defer = $q.defer();
    $http({
      url: Rest.patient + "/" + patient.id,
      method: 'GET',
      data: {},
      headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.update = function (patient) {
    var defer = $q.defer();
    $http({
      url: Rest.patient + "/" + patient.id,
      method: 'PUT',
      data: patient
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.create = function (patient) {
    var defer = $q.defer();
    $http({
      url: Rest.patient,
      method: 'POST',
      data: patient
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
}