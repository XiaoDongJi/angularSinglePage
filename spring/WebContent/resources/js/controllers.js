'use strict'
var myController = angular.module('userControllers',[]);

myController.controller('userListCtrl',['$scope','$location','userservice',
      function($scope,$location,userservice){
		$scope.users = userservice.list.query();
		$scope.delete = function(id,name){
			userservice.delete.delete({userid:id});
			alert("成功删除用户【"+name+"】");
			$location.path('/user/list');
		}
		$scope.detail = function(id){
			$location.path('/user/get/'+id);
		}
		$scope.edit = function(user){
			console.log(user.id);
			$location.path('/user/update/'+user.id);
		}
}]);

myController.controller('userAddCtrl',['$scope','$location','userservice',
      function($scope,$location,userservice){
		$scope.save = function(){
			userservice.add.save($scope.user);
			$location.path('/user/list');
		}
		$scope.reset = function(){
			$scope.user = '';
		}
}]);

myController.controller('userDetailCtrl',['$scope','$routeParams','userservice',
	   function($scope,$routeParams,userservice){
		$scope.user = userservice.detail.get({userid:$routeParams.userid});
 }]);

myController.controller('userUpdateCtrl',['$scope','$routeParams','$location','userservice',
	   function($scope,$routeParams,$location,userservice){
		console.log("update:"+$routeParams.userid);
		$scope.user = userservice.detail.get({userid:$routeParams.userid});
		$scope.save = function(){
			console.log("update:save");
			userservice.update.save($scope.user);
			$location.path('/user/list');
		}
}]);
