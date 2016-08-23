var dentalApp = angular.module('dental', []);
dentalApp
  .constant('Rest', {
    login : '/rest/login',
    signup : '/rest/signup',
    dashboard : '/rest/dashboard',
    patients : '/rest/patients',
    toothCures : '/rest/tooth/cures',
    profile : '/rest/profile'
  })
  .constant('Navigation', {
    profile : '/profile'
  })
  .factory('ResponseHandlers', ResponseHandlersFactory);

function ResponseHandlersFactory() {
  return {
    onErrorResponse: function (error, errorCode, headers) {
      console.error('Caught error:', error);
    }
  }
};
