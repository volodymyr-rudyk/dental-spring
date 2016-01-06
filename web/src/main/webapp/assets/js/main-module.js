var dentalApp = angular.module('dental', []);
dentalApp
  .constant('Rest', {
    login : '/rest/login',
    signup : '/rest/signup',
    profile : '/rest/profile'
  })
  .constant('Navigation', {
    profile : '/profile'
  });