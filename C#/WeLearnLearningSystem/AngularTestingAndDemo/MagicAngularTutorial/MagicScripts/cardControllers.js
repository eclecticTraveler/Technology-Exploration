// Module
var cardsControllers = angular.module('cardControllers', []);

// Body of each controller
var cardsCntrl = ['$scope', '$http', 'Cards', "UserSelection", "$rootScope", function ($scope, $http, Cards, UserSelection, $rootScope) {
    var cards = [];
    var numOfCards;
    var userInputQuery = "";

    Cards.query(function (blocks) {
        angular.forEach(blocks, function (block) {
            angular.forEach(block.expansions, function (expansion) {
                angular.forEach(expansion.cards, function (card) {
                    cards.push(card);
                    if (localStorage) {
                        var savedInfo = localStorage.getItem(card.id);
                        if (savedInfo !== null) {
                            card.textEn = savedInfo;
                        }
                    }
                });
            });
        });

        $scope.cards = cards;
    });

 
   
    // Get user query and number of cards to display from input
    $scope.query = UserSelection.getUserQuery();
    $scope.cardsCount = UserSelection.getCardsToDisplay();

    $scope.saveQuery = function () {
        userInputQuery = $scope.query;
        UserSelection.setUserQuery(userInputQuery);
        userInputQuery = UserSelection.getUserQuery();
        if (!userInputQuery) {
            $scope.query = UserSelection.getDefaultQuery();
        } else {
            $scope.query = userInputQuery;
        }

        // Get number of Cards to Display
        var pivot = parseInt($scope.cardsCount, 10);
        UserSelection.setCardsToDisplay(pivot);
        numOfCards = UserSelection.getCardsToDisplay();
        if (!pivot) {
            // Set default
            $scope.cardsCount = UserSelection.getDefaultNum();
        } else {
            $scope.cardsCount = numOfCards;

        }
    }
  

    
    
}];

var cardDetailCntrl = ["$scope", "$routeParams", "$location", "UserSelection", "$rootScope", function ($scope, $routeParams, $location, UserSelection, $rootScope) {
    var cards = $scope.$parent.cards;
    var goingLeft;
    var goingRight;
    $scope.lastKey = "---"


    for (var index = 0; index < cards.length; index++) {
        if (cards[index].id == $routeParams.cardId) {
            $scope.card = cards[index];
            break;
        }
    }

    $scope.update = function () {
        if (!localStorage) {
            return;
        }

        localStorage.setItem($scope.card.id, $scope.card.textEn);
    };

    // change views when arrows or main menu buttom are pressed
    $scope.left = function () {
        goingLeft = $scope.card.id;
        goingLeft -= 1;
        $location.path("/cards/" + "" + goingLeft);
    }

    $scope.right = function () {
        goingRight = $scope.card.id;
        goingRight += 1;
        $location.path("/cards/" + "" + goingRight);
    }

    $scope.goLeft = function () {
        $scope.left();   
    };

    $scope.goRight = function () {
        $scope.right();
    };

    $scope.goMenu = function () {
         $location.path("/cards");       
    };

    $scope.move = function (keyEvent) {
        // 37 is to the left, 39 is Right
        if (keyEvent.which === 37) {
            $scope.left();
        } else if (keyEvent.which === 39) {
            $scope.right();
        }

    };
}];


// Controllers specified position Matters
cardsControllers.controller('cardsListController', cardsCntrl)
                .controller('cardDetailController', cardDetailCntrl);
