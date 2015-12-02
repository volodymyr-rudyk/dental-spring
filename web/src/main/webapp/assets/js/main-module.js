var dentalApp = angular.module('dental', []);
dentalApp
  .constant('Rest', {
    login : '/rest/login',
    signup : '/rest/signup'
  })
  .constant('Navigation', {
    profile : '/profile'
  });