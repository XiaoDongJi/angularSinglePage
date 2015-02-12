'use strict'
var userServices = angular.module('userServices',['ngResource']);

userServices.factory('userservice',['$resource',
      function($resource){
		return  {
				list:$resource('user/list',{},{
						query:{method:'GET',params:{},isArray:true}
					}),
				add:$resource('user/add',{},{
					save:{method:'POST'}
		  		}),
		  		delete:$resource('user/delete/:userid',{userid:'@id'},{
		  			delete:{method:'DELETE'}
		  		}),
		  		detail:$resource('user/get/:userid',{userid:'@id'},{
		  			get:{method:'GET'}
		  		}),
		  		update:$resource('user/update',{},{
		  			save:{method:'POST'}
		  		})
		}
}]);
