angular.module('dashboard', ['dental'])
  .controller('DashboardController', function ($scope, $http, Rest) {
    $scope.dentist = window.dentist;
    $scope.response = {};

    this.dashboard = function () {
      $http({
        url: Rest.dashboard,
        method: 'POST',
        data: $scope.dentist
      }).success(success).error(fail);
    };
    var success = function (data, status, headers, config) {
      $scope.response = data;
      console.log(data);
    };
    var fail = function (data, status, headers, config) {
      $scope.response = data;
      console.log(data);
    };
  });