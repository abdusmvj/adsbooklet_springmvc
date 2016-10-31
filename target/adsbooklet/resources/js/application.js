//var app = angular.module('district-app', []);
//app.controller('district-ctrl', function($scope, $http) {
//    
//	$scope.districtList = [];	
//	$scope.getDistrictData = function(){
//		var select = document.getElementById("stateid");
//		$http({
//	        method : "GET",
//	        url :"/adsbooklet/getDistrictList/"+select.options[select.selectedIndex].value
//	    }).then(function(response) {
//	        console.log(response);
//	        console.log(response.data);
//	        $scope.districtList = response.data;
//	    }, function (response) {
//	    	console.log("failed");
//	    });
//	}
//	
//	$scope.getDistrictData();
//    
//});

//new
function getDistrictData(stateid)
{
	$("#districtid").load("/adsbooklet/getDistrictList/"+stateid);
	

}



