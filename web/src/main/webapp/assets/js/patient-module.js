var patientModule = angular.module('patient', ['ngRoute', 'dental'])
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
  .controller('ToothController', ToothController)
  .service('PatientService', PatientService)
  .service('ToothService', ToothService);

// Controllers
function PatientController($scope, PatientService) {
  PatientService.getAll().then(function (response) {
    $scope.patients = response;
    console.log(response);
  }, function error(error) {
    console.error(error)
  });
}
function NewPatientController($scope, PatientService) {
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
function ViewPatientController($scope, $routeParams, PatientService, ToothService) {
  $scope.patient = {};
  $scope.patient.id = $routeParams.id;
  PatientService.get($scope.patient).then(function (response) {
    $scope.patient = response;
    console.log(response);
  }, function error(error) {
    console.error(error)
  });
};
function ToothController($scope, ToothService) {
  this.addCure = function addCure(cure) {
    ToothService.addCure(cure, $scope.patient.id, $scope.selectedTooth.id)
      .then(function (response) {
        $scope.selectedTooth.cures.push(response);
        console.log(response);
      }, function error(error) {
        console.error(error)
      });
  };
};

function PatientService($http, $q, Rest, ResponseHandlers) {
  this.getAll = function () {
    var defer = $q.defer();
    $http({
      url: Rest.patients,
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
      url: Rest.patients + "/" + patient.id,
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
      url: Rest.patients + "/" + patient.id,
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
      url: Rest.patients,
      method: 'POST',
      data: patient
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
}
function ToothService($http, $q, Rest, ResponseHandlers) {
  this.get = function (patientId, toothId) {
    var defer = $q.defer();
    var params = "?patientId=" + patientId + "&toothId=" + toothId;
    $http({
      url: Rest.toothCures + params,
      method: 'GET',
      data: {},
      headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.addCure = function addCure (cure, patientId, toothId) {
    var defer = $q.defer();
    $http({
      url: Rest.toothCures,
      method: 'POST',
      data: {
        cure : cure,
        patientId : patientId,
        toothId : toothId
      },
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  }
}