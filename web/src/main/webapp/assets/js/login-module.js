angular.module('login', ['dental'])
  .controller('LoginController', function ($scope, $http, Rest) {
    $scope.user = {email: "", password: ""};
    $scope.response = {};

    this.login = function (isValid) {
      if (isValid) {
        $http({
          url: Rest.login,
          method: 'POST',
          data: $scope.user
        }).success(success).error(fail);
      }
    };
    var success = function (data, status, headers, config) {
      $scope.response = data;
      if (data.code == 200)
        document.location = "/dashboard";
      console.log(data);
    };
    var fail = function (data, status, headers, config) {
      $scope.response = data;
      console.log(data);
    };

  });