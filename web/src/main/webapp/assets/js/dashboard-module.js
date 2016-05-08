angular.module('dashboard', ['dental'])
  .controller('DashboardController', function ($scope, $http, DashboardService) {
    DashboardService.initDashbord();

    $scope.dentist = window.dentist;
    $scope.response = {};


  })
  .service('DashboardService', function ($http, Rest) {
    this.initDashbord = function () {
      $http({
        url: Rest.dashboard,
        method: 'POST',
      }).success(success).error(fail);
      var success = function (data, status, headers, config) {
        $scope.response = data;
        console.log(data);
      };
      var fail = function (data, status, headers, config) {
        $scope.response = data;
        console.log(data);
      };
    }
  });