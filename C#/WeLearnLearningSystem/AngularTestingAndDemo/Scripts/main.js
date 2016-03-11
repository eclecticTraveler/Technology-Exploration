var main = angular.module('weLearnApp', ['ngRoute', 'weLearnCntlrs', 'weLearnService', 'weLearnDirectives', 'datePicker', 'timePicker', 'ui.bootstrap']);

main.config([
    '$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
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
            when('/EventManager', {
                templateUrl: 'WeLearnPages/eventManager.html',
                controller: 'eventManagerController'
            }).
            otherwise({
                redirectTo: '/'
            });

        // In order to get rid of the # from the URL
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: true
        });
    }
]);
