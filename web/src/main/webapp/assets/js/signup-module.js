(function () {

    var app = angular.module('signup-form', []);

    app.controller('submitController', function () {
        this.data = '123';
        console.log('submit controller starts...');
    });
})();