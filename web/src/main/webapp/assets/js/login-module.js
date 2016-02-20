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
        }).success(this.success).error(this.fail);
      }
    };
    this.success = function (data, status, headers, config) {
      $scope.response = data;
      if (data.code == 200)
        document.location = "/dashboard";
      console.log(data);
    };
    this.fail = function (data, status, headers, config) {
      $scope.response = data;
      console.log(data);
    };

  });

function Person(firstName){
    this.firstName = firstName;
}

Person.prototype.say = function () {
  return this.firstName;
};

var p = new Person("test");
p.say();
