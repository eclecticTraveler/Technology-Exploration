// Module
var weLearnCntlrs = angular.module('weLearnCntlrs', []);


var menuCntlr = ["$scope", "$http", "$location", "UserCache", "GeneralFeaturesCache", "$rootScope", function ($scope, $http, $location, UserCache, GeneralFeaturesCache, $rootScope) {
    // Make sure the Chat tab is visible
    $scope.chatBoxVisibility = true;

    // Display upper menu items once again
    $rootScope.showCollapsedMenuNav = UserCache.getSmallMenu();
    $rootScope.showBigResolMenuNav = UserCache.getBigMenu();
    $rootScope.showHambuguerButton = UserCache.getHamButton();


    // Display all the Courses and Events for the User that logged in
    $scope.courses = GeneralFeaturesCache.getUserCourses();
    console.log($scope.courses);
    $scope.events = GeneralFeaturesCache.getUserEvents();
    console.log($scope.events);
    $scope.userProperties = GeneralFeaturesCache.getUserProfile();
    console.log($scope.userProperties);
    console.log($scope.userProperties.firstName + " " + $scope.userProperties.lastName);
    $rootScope.userFullName = $scope.userProperties.firstName + " " + $scope.userProperties.lastName;


      // When the user presses the Chat Tab
    $scope.chatRoom = function () {
        $rootScope.innerChatBox = false;
        // Go to the ChatRoom page
        $location.path("/ChatRoom");
    }
}];


var indexCntlr = ["$scope", "$http", "$location", "UserCache", "GeneralFeaturesCache", "$rootScope", function ($scope, $http, $location, UserCache, GeneralFeaturesCache, $rootScope) {
    // Set the title with other features from the assoc Array
    $scope.upperBarItems = UserCache.getUpperBarItems();

    // Hide the big and the collapsed Menu before user logs in
    // get definition from we Learn services
    // I couldn't find a better way to do this than using rootScope
    // although this is so some degree discouraged
    $rootScope.showCollapsedMenuNav = UserCache.getSmallMenu();
    $rootScope.showBigResolMenuNav = UserCache.getBigMenu();
    $rootScope.showHambuguerButton = UserCache.getHamButton();
    $rootScope.userFullName = "";

  
    // Function triggered when user hits button
    $scope.login = function () {
       
        // set the right items to be visible
        UserCache.setSmallMenu(true);
        UserCache.setBigMenu(true);
        UserCache.setHamButton(true);
        
        // Getting the input values from the log in inputs
        var url = "Handlers/MainHandler.ashx"
        + "?cmd=login"
        + "&username=" + $scope.formData.username
        + "&password=" + $scope.formData.password;

        // Send paramenters to be evaluated
        // Plus Cache results
        $http.get(url, {cache: true}).then(function (response) {
            // when the response is available
            var generalData = response.data;
            console.log(generalData);
            console.log(generalData.UserProfile);
            console.log(generalData.UserCouses);
            console.log(generalData.UserEvents);
            
            // Cache all the user objects
            // Later I will do all the parsing from the Service itself
            GeneralFeaturesCache.setAllUserInfo(generalData);
            GeneralFeaturesCache.setUserProfile(generalData.UserProfile);
            GeneralFeaturesCache.setUserCourses(generalData.UserCouses);
            GeneralFeaturesCache.setUserEvents(generalData.UserEvents);

            // For now we will redirect the user
            $location.path("/MainMenu");

            // Save username
            //            portalFactory.setUsername($scope.formData.username);
        }, function (data, status) {
            // or server returns response with an error status.
            $scope.errorMsg = data.statusText;
            $scope.showErr = true;
        });

     
    }

    $scope.backToMain = function () {
        $location.path("/MainMenu");
    }



}];



var ChatRoomController = ["$scope", "$http", "$log", "UserCache", "$rootScope", 
    function ($scope, $http, $log, UserCache, $rootScope) {

   
    // Don't display inner chat box until a user is selected
    $rootScope.innerChatBox = false;
    // I am using a generic handler which is simple and new
    var url = "Handlers/MainHandler.ashx"
             + "?cmd=loadUsers";
    // naturally cache results
    $http.get(url, { cache: true }).then(function (response) {

        var allinfo = response.data;
        console.log(allinfo);
        var chatParticipants = allinfo.people;
        console.log(chatParticipants);
        UserCache.setChatParticipants(chatParticipants);
        $scope.chatUsers = UserCache.getChatParticipants();

    });

    $scope.chatWithThisPerson = function(userId){
        var id = userId;
        UserCache.setSelectedPersonInfo(id);
        var userChattingWith = UserCache.getSelectedPersonInfo();
        // I am using a generic handler which is simple and new
        var url = "Handlers/MainHandler.ashx"
                 + "?cmd=loadMessages";
        // naturally cache results
        $http.get(url, { cache: true }).then(function (response) {

            var msn = response.data;
            console.log(msn);
            var chatMessages = msn.chatMesseages;
            console.log(chatMessages);
            UserCache.setChatMessages(chatMessages);
            $scope.chatMsn = UserCache.getChatMessages();

        });

        $scope.personChattingWith = userChattingWith;

        // Displayed custumized window with conversation
        $rootScope.innerChatBox = true;
    }

}];



weLearnCntlrs.controller("indexController", indexCntlr)
             .controller("loggedInMenuController", menuCntlr)
             .controller("chatRoomController", ChatRoomController);
