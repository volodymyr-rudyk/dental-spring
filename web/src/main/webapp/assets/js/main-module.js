var dentalApp = angular.module('dental', ['angular-loading-bar']);
dentalApp
  .constant('Navigation', { profile : '/profile' })
  .factory('RestTemplate', RestTemplate);

function RestTemplate($http, $q) {
  return {
    GET : function (obj) {
      var defer = $q.defer();
      $http({
        url: obj.url,
        method: 'GET',
        data: {},
        headers: {'Content-Type': 'application/json'}
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        defer.reject(data);
      });
      return defer.promise;
    },
    POST : function (obj) {
      var defer = $q.defer();
      $http({
        url: obj.url,
        method: 'POST',
        data: obj.data
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        defer.reject(data);
      });
      return defer.promise;
    },
    PUT : function (obj) {
      var defer = $q.defer();
      $http({
        url: obj.url,
        method: 'PUT',
        data: obj.data
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        defer.reject(data);
      });
      return defer.promise;
    },

    url : {
      login : '/rest/login',
      signup : '/rest/signup',
      dashboard : '/rest/dashboard',
      patients : '/rest/patients',
      toothCures : '/rest/tooth/cures',
      profile : '/rest/profile'
    }
  }
}