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
      .otherwise({
        redirectTo: '/'
      });
  })
  .controller('PatientController', PatientController)
  .controller('NewPatientController', NewPatientController)
  .service('PatientService', PatientService);

// Controllers
function PatientController($scope, $http, PatientService) {
  PatientService.get().then(function (response) {
    $scope.dentist = response;
    console.log(response);
  }, function error(error) {
    console.error(error)
  });
}
function NewPatientController($scope, $http, PatientService) {
  $scope.patient = {};

  this.create = function (isValid) {
    PatientService.create($scope.user).then(function success(response) {
      $scope.success = "Added new Patient";
    }, function (error) {
    })
  };

};

function PatientService($http, $q, Rest, ResponseHandlers) {
  var defer = $q.defer();
  this.get = function () {
    $http({
      url: Rest.patient + "?d="+new Date(),
      method: 'GET',
      data: {},
      headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.update = function () {
    $http({
      url: Rest.patient,
      method: 'PUT',
      data: {}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.create = function (patient) {
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