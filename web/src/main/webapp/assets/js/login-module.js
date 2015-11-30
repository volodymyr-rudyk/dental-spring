angular.module('login', [])
  .controller('LoginController', function ($scope, $http, $location) {
    $scope.user = {email : "", password : ""};
    $scope.response = {};

    this.doLogin = function () {
      $http({
        url: "http://localhost:9999/rest/login",
        method: 'POST',
        data: $scope.user
      }).success(loginSuccess).error(loginFail);
    };

    var loginSuccess = function (data, status, headers, config) {
      $scope.response = data;
      if(data.code == 200)
        document.location = "http://localhost:9999/profile";
        console.log(data);
    };
    var loginFail = function (data, status, headers, config) {
      console.log(data);
    };

  });