/**
 * Created by vrudyk on 7/14/2016.
 */

patientModule.directive('tooth', function (ToothService) {
  return {
    restrict: 'E',
    replace: 'true',
    link: function (scope, elem, attrs) {
      elem.bind('click', function () {
        ToothService.get(scope.patientId, scope.tooth.id)
          .then(function (response) {
            scope.$parent.selectedTooth=response
            console.log(response);
          }, function error(error) {
            console.error(error)
          });
        console.log("click")
      });
    }
  };
});

