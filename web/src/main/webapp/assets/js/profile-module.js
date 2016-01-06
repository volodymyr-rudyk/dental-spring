angular.module('profile', ['dental'])
  .controller('ProfileController', function ($scope, $http, Rest) {
    $scope.user = window.user;
    debugger;
    $scope.response = {};

    this.updateProfile = function () {
      $http({
        url: Rest.profile,
        method: 'POST',
        data: $scope.user
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