var cardsServices = angular.module('cardsServices', ['ngResource']);

cardsServices.factory('Cards', cardsCache)
cardsServices.factory('UserSelection', usersCache);
//cardsServices.factory('Cards', ['$resource',
//  function ($resource) {
//      return $resource('MagicScripts/all.json', {}, {
//          query: { method: 'GET', params: {}, isArray: true }
//      });
//  }]);

function cardsCache($resource) {
    var cachedData;
    return $resource('MagicScripts/all.json', {}, {
                  query: { method: 'GET', params: {}, isArray: true, cache: true }
              });
};

function usersCache() {
    var cardsToDisplay = 10;
    var userQuery = "";
    var defaultQuery = "";
    var defaultNumOfCardsToDisplay = 15;

    return {
        setCardsToDisplay: function (num) {
            cardsToDisplay = num;
        },
        getCardsToDisplay: function () {
            return cardsToDisplay;
        },
        setUserQuery: function (query) {
            userQuery = query;
        },
        getUserQuery: function () {
            return userQuery;
        },
        getDefaultQuery: function () {
            return defaultQuery;
        },
        getDefaultNum: function () {
            return defaultNumOfCardsToDisplay;
        }
    }
   
};
//function cardsCache($resource) {

//    return {
//        query: ['$resource',
//                 function ($resource) {
//                     return $resource('MagicScripts/all.json', {}, {
//                         query: { method: 'GET', params: {}, isArray: true }
//                     });
//                 }]
//    }
// };

