var main = angular.module('weLearnApp', ['ngRoute', 'weLearnCntlrs', 'weLearnService', 'weLearnDirectives']);

main.config([
    '$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'WeLearnPages/loginPage.html',
                controller: 'indexController'
            }).
            when('/MainMenu', {
                templateUrl: 'WeLearnPages/mainMenu.html',
                controller: 'loggedInMenuController'
            }).
            when('/ChatRoom', {
                templateUrl: 'WeLearnPages/chatRoom.html',
                controller: 'chatRoomController'
            }).
            otherwise({
                redirectTo: '/'
            });
    }
]);
