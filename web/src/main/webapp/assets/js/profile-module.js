angular.module('profile', ['dental'])
  .controller('ProfileController', function ($scope, RestTemplate) {
    $scope.user = window.user;
    $scope.response = {};

    this.updateProfile = function () {
      RestTemplate.POST({url : RestTemplate.url.profile, data : $scope.user})
        .then(success, fail);
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