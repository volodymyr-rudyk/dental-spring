angular.module('auth', ['dental'])
  .controller('LoginController', LoginController)
  .controller('SignupController', SignupController)
  .service("AuthService", AuthService);

function LoginController($scope, AuthService) {
  $scope.user = {email: "", password: ""};
  $scope.response = {};

  this.login = function (isValid) {
    if (isValid) {
      AuthService.login($scope.user).then(function (response) {
        $scope.response = response.data;
        if (response.code == 0)
          document.location = "/dashboard";
        console.log(response);
      }, function error(response) {
        $scope.response = response;
        console.error(response)
      });
    }
  };
}

function SignupController($scope, AuthService) {
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
    if (isValid) {
      AuthService.signup($scope.user).then(function (response) {
        $scope.response = response;
        if (response.code == 0)
          document.location = "/login";
        console.log(response);
      }, function error(response) {
        $scope.response = response;
        console.error(response)
      });
    }
  };
}

function AuthService(RestTemplate) {
  this.login = function login(user) {
    return RestTemplate.POST({url : RestTemplate.url.login, data : user})
  };
  this.signup = function signup(user) {
    return RestTemplate.POST({url : RestTemplate.url.signup, data : user})
  };
};