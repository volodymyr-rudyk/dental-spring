angular.module('signup', ['dental'])
  .controller('SignupController', function ($scope, $http, Rest) {
    $scope.user = {
      email: "",
      password: "",
      firstName: "",
      //middleName: "",
      lastName: "",
      //birthday: "",
      //address: "",
      //phone: ""
    };

    $scope.response = {};

    this.signup = function (isValid) {
      debugger;
      if (isValid) {
        $http({
          url: Rest.signup,
          method: 'POST',
          data: $scope.user
        }).success(this.success).error(this.fail);
      }
    };
    this.validate = function () {
      var u = $scope.user;
    };

    this.success = function (data, status, headers, config) {
      $scope.response = data;
      if (data.code == 0)
        document.location = "/login";
      console.log(data);
    };
    this.fail = function (data, status, headers, config) {
      console.log(data);
    };

  });