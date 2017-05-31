var cartApp = angular.module('cartApp', []);

cartApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);

cartApp.controller('cartController', function($scope, $http){

});