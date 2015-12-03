angular.module('signup', ['dental'])
  .controller('SignupController', function ($scope, $http, Rest) {
    $scope.user = {
      email: "",
      password: "",
      confirmPassword: "",
      firstName: "",
      middleName: "",
      lastName: "",
      birthday: "",
      phone: ""
    };

    $scope.response = {};

    this.signup = function () {
      debugger;
      $http({
        url: Rest.signup,
        method: 'POST',
        data: $scope.user
      }).success(success).error(fail);
    };
    this.validate = function () {
      var u = $scope.user;
    };

    var success = function (data, status, headers, config) {
      $scope.response = data;
      if (data.code == 200)
        document.location = "/login";
      console.log(data);
    };
    var fail = function (data, status, headers, config) {
      console.log(data);
    };

  });