var patientModule = angular.module('patient', ['ngRoute', 'dental', 'angular-loading-bar'])
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
      $scope.success = null;
      $scope.error = null;
      PatientService.create($scope.patient).then(function success(response) {
        $scope.success = {};
      }, function (error) {
        $scope.error = {};
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

function PatientService(RestTemplate) {
  this.getAll = function () {
    return RestTemplate.GET({url : RestTemplate.url.patients});
  };
  this.get = function (patient) {
    return RestTemplate.GET({url : RestTemplate.url.patients+ "/" + patient.id});
  };
  this.update = function (patient) {
    return RestTemplate.PUT({url : RestTemplate.url.patients+ "/" + patient.id, data : patient})
  };
  this.create = function (patient) {
    return RestTemplate.POST({url : RestTemplate.url.patients, data : patient})
  };
}
function ToothService(RestTemplate) {
  this.get = function (patientId, toothId) {
    return RestTemplate.GET({url : RestTemplate.url.toothCures + "?patientId=" + patientId + "&toothId=" + toothId});
  };
  this.addCure = function addCure(cure, patientId, toothId) {
    return RestTemplate.POST({url : RestTemplate.url.toothCures, data : { cure: cure, patientId: patientId, toothId: toothId } });
  }
}