/**
 * Created by vrudyk on 7/14/2016.
 */

patientModule.service('ToothService', ToothService);


patientModule.directive('tooth', function (ToothService) {
  return {
    restrict: 'E',
    replace: 'true',

    link: function (scope, elem, attrs) {
      elem.bind('click', function () {
        ToothService.get(scope.patientId, scope.tooth.id)
          .then(function (response) {
            scope.cures = response;
            console.log(response);
          }, function error(error) {
            console.error(error)
          });
        console.log("click")
        elem.css('background-color', 'white');
        scope.$apply(function () {
          scope.color = "white";
        });
      });
    }
  };
});

function ToothService($http, $q, Rest, ResponseHandlers) {
  this.get = function (patientId, toothId) {
    var defer = $q.defer();
    var params = "?patientId=" + patientId + "&toothId=" + toothId;
    $http({
      url: Rest.tooth + params,
      method: 'GET',
      data: {},
      headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  };
  this.saveCure = function (cure) {
    var defer = $q.defer();
    var params = "?patientId=" + patientId + "&toothId=" + toothId;
    $http({
      url: Rest.tooth + params,
      method: 'GET',
      data: {},
      headers: {'Content-Type': 'application/json'}
    }).success(function (data) {
      defer.resolve(data);
    }).error(ResponseHandlers.onErrorResponse);
    return defer.promise;
  }
}