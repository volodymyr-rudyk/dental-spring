// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
//= require bootstrap

//if (typeof jQuery !== 'undefined') {
//	(function($) {
//		$('#spinner').ajaxStart(function() {
//			$(this).fadeIn();
//		}).ajaxStop(function() {
//			$(this).fadeOut();
//		});
//	})(jQuery);
//}

(function() {

	var dentalSearch = angular.module('dentalSearch', []);
	dentalSearch.controller('SearchController', function ($scope, $http) {
		this.message = "Hello";
		this.result = [];
		this.q = "";
		this.response = {firstName : 'abc'};
		this.result.push({firstName : 'abc'});
		this.search = function () {
			if(!this.q)return;

			$http.get("/search?q=" + this.q, {"q":this.q})
				.success(function(data, status, headers, config) {
					this.result = data;
					this.response = data;

					console.log(data);
					// this callback will be called asynchronously
					// when the response is available
				}).
				error(function(data, status, headers, config) {
					console.log(data);
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});
		};

	});



	var app = angular.module('dental', ['dentalSearch']);

	app.controller('', function () {

	})

})();