(function () {
    console.info('App starting....');

    var app = angular.module('gemStore', [], function () {
        console.info('start module gemApp');
        //debugger;
    }).filter('cm', function () {
        return function (input, data) {
            var c = input ? '\u2713' : '\u2718';
            return c + ' ' + input + ' ' + data;
        }
    });

    app.controller('StoreController', function ($scope) {
        this.product = gem;
        this.products = gem;
    });
    app.controller('OneController', function ($scope) {
        this.one = {
            test: 'hello world!',
            src: 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTWmBhjMOq0d2O2Ufm70CQ422vGl67FBaRkNu-SGnux5FLvKeLg'
        };
    });

    var gem = [
        {name: 'Azurite', price: 2.95, reviews: []}
    ];

    app.controller('ReviewController', function ($scope) {

        this.ps = [
            {name: 'Azurite', price: 2.95, reviews: []}
        ];
        this.review = {};
        this.addReview = function (product) {
            product.reviews = product.reviews || [];
            product.reviews.push(this.review);
        };
    });
    app.controller('MenuController', function ($scope) {
        this.tab = 1;
        this.selectTab = function (tab) {
            this.tab = tab;
        };

        this.isSelected = function (tab) {
            return this.tab === tab;
        };

        var items = [
            {link: 'home', title: 'Home'},
            {link: 'about', title: 'About Us'},
            {link: 'chart', title: 'Info'},
            {link: 'contact', title: 'Contact'},
        ];
        this.items = items;
    });

    app.directive('productTitle', function () {
        return {
            restrict: 'E',
            templateUrl: 'include.html'
        };
    });
})();