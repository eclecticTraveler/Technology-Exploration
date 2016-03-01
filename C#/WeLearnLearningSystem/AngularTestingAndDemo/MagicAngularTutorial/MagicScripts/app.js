var mainApp = angular.module('mainApp', ['ngRoute', 'ngAnimate', 'cardControllers', 'cardsServices']);

mainApp.config([
    '$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/cards', {
                templateUrl: 'MagicViews/list.html',
                controller: 'cardsListController'
            }).
            when('/cards/:cardId', {
                templateUrl: 'MagicViews/detail.html',
                controller: 'cardDetailController'
            }).
            otherwise({
                redirectTo: '/cards'
            });
    }
]);

mainApp.filter('filterAndReduce', function () {
    return function (cards, count, query, UserSelection, $rootScope) {

        //var previousQuery = "";

        //previousQuery = UserSelection.getUserQuery();

        if (!query) {
            return cards.slice(0, count);
        }

        var filtered = [];

        query = query.toLowerCase();

        angular.forEach(cards, function (card) {
            if (card.nameEn.toLowerCase().indexOf(query) !== -1) {
                filtered.push(card);
            }
        });

        return filtered.slice(0, count);
    };
});