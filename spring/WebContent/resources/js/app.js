'use strict'
var app = angular.module('myApp',
		['ngRoute',
		 'userControllers',
		 'userServices']);
app.config(['$routeProvider',
	function($routeProvider){
		$routeProvider.when('/user/list',{
			templateUrl:'resources/partials/userList.html',
			controller:'userListCtrl'
		}).when('/user/add',{
			templateUrl:'resources/partials/addUser.html',
			controller:'userAddCtrl'
		}).when('/user/get/:userid',{
			templateUrl:'resources/partials/detailUser.html',
			controller:'userDetailCtrl'
	}).when('/user/update/:userid',{
		templateUrl:'resources/partials/updateUser.html',
		controller:'userUpdateCtrl'
	}).otherwise({
		redirectTo:'/user/list'
		});
}]);