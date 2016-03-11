// Module
var weLearnCntlrs = angular.module('weLearnCntlrs', []);


var menuCntlr = ["$scope", "$http", "$location", "UserCache", "GeneralFeaturesCache", "$rootScope", function ($scope, $http, $location, UserCache, GeneralFeaturesCache, $rootScope) {
    // Hide loading 
    $('#loadingEvent').hide();
    // Evaluate if the user is has logged in properly
    var userProfile = GeneralFeaturesCache.getUserProfile();
    if (userProfile === null || userProfile.length <= 0 ) {
        // Redirect user if he or she hasn't
        $location.path("/");
        $rootScope.errorMsg = "Please Log in";
        $rootScope.showErr = true;
    }

    // Make sure the Chat tab is visible
    $scope.chatBoxVisibility = true;

    // Display upper menu items once again
    $rootScope.showCollapsedMenuNav = UserCache.getSmallMenu();
    $rootScope.showBigResolMenuNav = UserCache.getBigMenu();
    $rootScope.showHambuguerButton = UserCache.getHamButton();


    // Display all the Courses and Events for the User that logged in
    $scope.courses = GeneralFeaturesCache.getUserCourses();
    $scope.events = GeneralFeaturesCache.getUserEvents();
    $scope.singleEvent = GeneralFeaturesCache.getInnerUserEvents();
    $scope.userProperties = GeneralFeaturesCache.getUserProfile();
    $rootScope.userFullName = $scope.userProperties.firstName + " " + $scope.userProperties.lastName;
    $rootScope.userPic = GeneralFeaturesCache.getUserProfile().userPicAddress;

    // On events display current Date
    var monthNames = [
      "January", "February", "March",
      "April", "May", "June", "July",
      "August", "September", "October",
      "November", "December"
    ];

    var date = new Date();
    var day = date.getDate();
    var monthIndex = date.getMonth();
    var year = date.getFullYear();
 
    $scope.currentTime = monthNames[monthIndex] + ' ' + day + ', ' + year;

      // When the user presses the Chat Tab
    $scope.chatRoom = function () {
        $rootScope.innerChatBox = false;
        // Request all Chat users
        // I am using a generic handler which is simple and new
        var url = "Handlers/MainHandler.ashx"
                 + "?cmd=loadUsers";
        // naturally cache results
        $http.get(url, { cache: true }).then(function (response) {
            // Get all Users for the ChatRoom and store them
            var allinfo = response.data;
            var chatParticipants = allinfo.chatUsers;
            UserCache.setChatParticipants(chatParticipants);
            // Go to the ChatRoom page
            $location.path("/ChatRoom");

        });


    }


    /**********************
    * EDIT EVENT
    ***********************/
    // When Editing an chosen event
    $scope.editEvent = function (eventToEdit) {
        // Check if its not null
        if (eventToEdit === null || eventToEdit === undefined) {
            return;
        }
        // Get event an parse it
        console.log("Event To Be Updated");
        console.log(eventToEdit);
        // Save the event that is going to be updated
        GeneralFeaturesCache.setEventToBeEdited(eventToEdit);
        // Chance subtitle and Button
        UserCache.setSubtitleOnEventPage("Edit Event");
        UserCache.setButtonLabelOnEventPage("Update Event");
        // Go to Event Manager
        $location.path("/EventManager");

    }

    /**********************
    * ERASE EVENT
    ***********************/
    // When Removing an Event
    $scope.eraseEvent = function (eventToDelete) {
        // Check if its not null
        if (eventToDelete === null || eventToDelete === undefined) {
            return;
        }

        // Parse it
        var jsonEvent = angular.toJson(eventToDelete);
        // Send it to the backend to eventually save it in Database
        url = "Handlers/MainHandler.ashx"
            + "?cmd=deleteEvent"
            + "&event=" + jsonEvent
            + "&ticket=" + eventToDelete.Id;
        // Sending event
        $http.post(url).then(function (response) {
            // Update all the repo
            // when the response is available
            var generalData = response.data;
            console.log(generalData);
            GeneralFeaturesCache.setUserEvents(generalData.UserEvents);

            // Since I am having a hard time referrencing the inner event
            // within the list I am extracting it and saving it separently to see
            // what we can do. Also I need to parse the docText into JSON otherwise
            // its going to be considered a string and not an JSON object
            var singleEvent = [];
            if (generalData.UserEvents != undefined || generalData.UserEvents != null) {
                generalData.UserEvents.forEach(function (jsonInnerEvent) {
                    singleEvent.push(JSON.parse(jsonInnerEvent.docText));
                });
            }
            // Save extraction of Inner Events in Service
            GeneralFeaturesCache.setInnerUserEvents(singleEvent);
            // Bind data back
            //$("#item_" + itemId).fadeOut();
            $scope.singleEvent = GeneralFeaturesCache.getInnerUserEvents();

        }, function (data, status) {
            // or server returns response with an error status.
            $location.path("/");
            $rootScope.errorMsg = "An Error Happened When Deleting the Event";
            $rootScope.showErr = true;
        });
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
    $rootScope.userPic;

    // Hide the loading gif, tempering with the dom is not recommended on controllers but whatevs
    $('#loadingEvent').hide();
    // Function triggered when user hits button
    $scope.login = function () {
       
        // set the right items to be visible
        UserCache.setSmallMenu(true);
        UserCache.setBigMenu(true);
        UserCache.setHamButton(true);

        // Evaluate the user password and username to see if one is empty from the log in inputs
        var usernameInserted = $scope.formData.username;
        var passwordInserted = $scope.formData.password;

        if ((usernameInserted === "" || usernameInserted === null || usernameInserted === "undefined" || usernameInserted === undefined) &&
            (passwordInserted === "" || passwordInserted === null || passwordInserted === "undefined" || passwordInserted === undefined)) {
                $scope.errorMsg = "Insert your Username and Password";
                $scope.showErr = true;
                return;
        } else if (passwordInserted === "undefined" || passwordInserted === "" || passwordInserted === null || passwordInserted === undefined) {
                $scope.errorMsg = "Please insert Password";
                $scope.showErr = true;
                return;
        } else if (usernameInserted === "" || usernameInserted === null || usernameInserted === "undefined" || usernameInserted === undefined) {
                $scope.errorMsg = "Please insert Username";
                $scope.showErr = true;
                return;
        } 

      
        // By now the fields for username and password are inserted
        // Lets validate them
        var url = "Handlers/MainHandler.ashx"
        + "?cmd=login"
        + "&username=" + usernameInserted
        + "&password=" + passwordInserted;
        // Show that is loading
        $('#loadingEvent').show();
        // Send paramenters to be evaluated
        // Plus Cache results
        $http.get(url, { cache: true }).then(function (response) {
            // Show that is loading
            $('#loadingEvent').show();
            // when the response is available
            var generalData = response.data;
            console.log(generalData);
            
            // Cache all the user objects
            // Later I will do all the parsing from the Service itself
            GeneralFeaturesCache.setAllUserInfo(generalData);
            GeneralFeaturesCache.setUserProfile(generalData.UserProfile);
            GeneralFeaturesCache.setUserCourses(generalData.UserCouses);
            GeneralFeaturesCache.setUserEvents(generalData.UserEvents);

            // Since I am having a hard time referrencing the inner event
            // within the list I am extracting it and saving it separently to see
            // what we can do. Also I need to parse the docText into JSON otherwise
            // its going to be considered a string and not an JSON object
            var singleEvent = [];
            if (generalData.UserEvents != undefined || generalData.UserEvents != null) {
                generalData.UserEvents.forEach(function (jsonInnerEvent) {
                    singleEvent.push(JSON.parse(jsonInnerEvent.docText));
                });
            }
            // Save extraction of Inner Events in Service
            GeneralFeaturesCache.setInnerUserEvents(singleEvent);

            // For now we will redirect the user
            $location.path("/MainMenu");

        }, function (data, status) {
            // or server returns response with an error status.
            //$scope.errorMsg = data.statusText;
            $('#loadingEvent').hide();
            $scope.errorMsg = "Invalid Username or Password";
            $scope.showErr = true;
        });


     
    }

    $scope.backToMain = function () {
        $location.path("/MainMenu");
    }

    // When the user presses the Calendar Option on the dropdown
    $scope.calendar = function () {
        // Set subtitle and Button
        UserCache.setSubtitleOnEventPage("Add Event");
        UserCache.setButtonLabelOnEventPage("Save Event");
        // Go to the Calendar page
        $location.path("/EventManager");

    }

}];



var ChatRoomController = ["$scope", "$http", "$log", "$location", "UserCache", "GeneralFeaturesCache", "$rootScope", function ($scope, $http, $log, $location, UserCache, GeneralFeaturesCache, $rootScope) {

    // Evaluate if the user is has logged in properly
    var userProfile = GeneralFeaturesCache.getUserProfile();
    if (userProfile === null || userProfile.length <= 0) {
        // Redirect user if he or she hasn't
        $location.path("/");
        $rootScope.errorMsg = "Please Log in";
        $rootScope.showErr = true;
    }

    // Don't display inner chat box until a user is selected
    $rootScope.innerChatBox = false;
    // Disable the input bar
    $scope.isChatBarDisabled = true;
    // Get the users and bind them
    $scope.chatUsers = UserCache.getChatParticipants();


    /***************************************************
    * WHEN THE USER PRESSES A PIC TO CHAT WITH THAT USER
    ****************************************************/
    $scope.chatWithThisPerson = function (userId) {
        if (userId <= 0) {
            return;
        }

        // I am using a generic handler which is simple and new
        var url = "Handlers/MainHandler.ashx"
                 + "?cmd=loadMessages"
                 + "&to=" + userId;
        // naturally cache results
        $http.get(url, { cache: true }).then(function (response) {

            // Retrive http response
            var msn = response.data;
            var chatMessages = msn.chatMessages;
            // Since I am having a hard time referrencing the inner chatMessage
            // and passing it on the back end I will do it on the front end
            var parsedChatMsns = [];
            if (chatMessages != undefined) {
                chatMessages.forEach(function (jsonChatMsn) {
                    parsedChatMsns.push(JSON.parse(jsonChatMsn.message));
                });
            }
            
            // Save parsed chat messages objects
            UserCache.setChatMessages(parsedChatMsns);
            // Retrived them to send them to view
            $scope.chatMsn = UserCache.getChatMessages();

            // Pass the id to set the user to chat with
            UserCache.setSelectedPersonInfo(userId);

            // Get all the info for the person chatting with
            var userChattingWith = UserCache.getSelectedPersonInfo();
            var personPic = UserCache.getSelectedPersonPic();
            var personLoggedProperties = GeneralFeaturesCache.getUserProfile();
            var personLoggedId = personLoggedProperties.personId;

            // This is if I decide to display full name on the chatroom of person that logged in
            //var personLoggedName = personLoggedProperties.firstName + " " + personLoggedProperties.lastName;
            var personLoggedName = "Me";

            // Get pic of person logged in
            $scope.userloggedPic = GeneralFeaturesCache.getUserProfile().userPicAddress;
            $scope.picOfUserChattingWith = personPic;
            $scope.personChattingWith = userChattingWith;
            $scope.loggedPersonId = personLoggedId;
            $scope.loggedPersonName = personLoggedName;

            // Enable the input bar
            $scope.isChatBarDisabled = false;
            // Displayed custumized window with conversation
            $rootScope.innerChatBox = true;
        });


       
    }

}];

/*ADD EVENT CONTROLLER*/
var addOrUpdateEventController = ["$scope", "$http", "$log", "$location", "UserCache", "GeneralFeaturesCache", "$rootScope", function ($scope, $http, $log, $location, UserCache, GeneralFeaturesCache, $rootScope) {

    // Evaluate if the user is has logged in properly
    var userProfile = GeneralFeaturesCache.getUserProfile();
    if (userProfile === null || userProfile.length <= 0) {
        // Redirect user if he or she hasn't
        $location.path("/");
        $rootScope.errorMsg = "Please Log in";
        $rootScope.showErr = true;
    }

    // Don't display inner chat box until a user is selected
    $rootScope.innerChatBox = false;
    // Subtitle and Button
    $scope.pageSubtitle = UserCache.getSubtitleOnEventPage();
    $scope.buttonTitle = UserCache.getButtonLabelOnEventPage();
    // Initialize object 
    var userEvent = {}


    /*******************************************************************
    * If there is an event to be edited the following will be executed
    ********************************************************************/
    // If there is an event to edit then retrive it  
    // After logging in Event to be edited is empty in the array thus cap is 0
    // But after its loaded an event to it, capacity will be undefined
    // I did this hack because the empty object did not evaluate to null
    // This way it will hold once event at a time
    var eventToEdit = GeneralFeaturesCache.getEventToBeEdited();
    var cap = eventToEdit.length;
    if (!(cap == 0 || eventToEdit === undefined || eventToEdit === null || eventToEdit === "")) {
        // Add the command for update 
        if (!('Cmd' in eventToEdit)) {
            eventToEdit.Cmd = "updateEvent";
        }
        // Pass the values to the Form All but Date and Time will be set
        $scope.newEvent = eventToEdit;
        // Set Date and Time and since its a 3rd party and does not have an API I won't deal with it just now
        // Since I am passing the whole object and instantiating it before the function to update it, It will pass
        // All the features even the once that are not visible like the Unique Id

        // Reset Event for next Update
        GeneralFeaturesCache.setEventToBeEdited("");

    }


    /***********************************************
    * When And event is going to be Added or Updated
    ************************************************/   
    // When the user presses the Calendar Option on the dropdown TO ADD a new Event
    $scope.addOrUpdateEvent = function (eventFromUser) {
        // Object that will hold all values but date, Id, Time and Due      
        userEvent = eventFromUser;
        // Date picker values
        var startDateValue = document.getElementById("dueDate").value;
        var hours = parseInt(document.getElementById('hours').value);
        var minutes = document.getElementById('minutes').value;
        var indicator = document.getElementById('pm').innerHTML;
        // Solidify date to UTC
        var d = new Date(startDateValue);
        if (indicator == 'PM') {
            hours = hours + 12;
        }
        d.setHours(hours);
        d.setMinutes(minutes);
        // Add the UTC date to current object
        // The date to later sort it by
        // Add an unique ID to it and Time
        userEvent.Due = d.toUTCString()
        userEvent.Date = startDateValue;
        // If does not have an Id add it to it 
        if (!('Id' in userEvent)) {
            userEvent.Id = generateUUID();
        }        
        userEvent.Time = hours + ":" + minutes + " " + indicator;

        // If a command is appended to the object
        // Then retrive it, map it and pop it
        var command = "";
        if ('Cmd' in userEvent) {
            command = userEvent.Cmd;
            delete userEvent.Cmd;
        }

        // Stringify it not the other way because it will add a $$hashKey to keep track of my chances
        jsonEvent = angular.toJson(userEvent);

        var url = "";
        // If this Object is mean to be updated
        if (command === "updateEvent") {

            // Send it to the backend to eventually save it in Database
            url = "Handlers/MainHandler.ashx"
                + "?cmd=updateEvent"
                + "&event="  + jsonEvent
                + "&ticket=" + userEvent.Id;
            // Sending event
            $http.post(url).then(function (response) {
                // Return Just that event that was inserted (Its already JSONParsed)
                var recentEventAdded = response.data;
                var updatedEventUUID = recentEventAdded.Id;
                // Update Service
                GeneralFeaturesCache.setUpdatedEvent(recentEventAdded, updatedEventUUID);
                // Redirect User
                $location.path('/MainMenu');

            }, function (data, status) {
                // or server returns response with an error status.
                $location.path("/");
                $rootScope.errorMsg = "An Error Happened When Updating the Event";
                $rootScope.showErr = true;
            });
        } else {
            // Else it means that is just a new Event to add
            // Send it to the backend to eventually save it in Database
            url = "Handlers/MainHandler.ashx"
                + "?cmd=addEvent"
                + "&event="  + jsonEvent
                + "&ticket=" + userEvent.Id;
            // Sending event
            $http.post(url).then(function (response) {
                // Return Just that event that was inserted (Its already JSONParsed)
                var recentEventAdded = response.data;
                // Push it to the service
                GeneralFeaturesCache.pushInnerUserEvents(recentEventAdded);
                // Redirect User
                $location.path('/MainMenu');

            }, function (data, status) {
                // or server returns response with an error status.
                $location.path("/");
                $rootScope.errorMsg = "An Error Happened When Adding an Event";
                $rootScope.showErr = true;
            });
        }

        // Create unique ID for each event to be used internally -PRIVATE FUNCTION
        function generateUUID() {
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                var r = (d + Math.random() * 16) % 16 | 0;
                d = Math.floor(d / 16);
                return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
            return uuid;
        };
    }

        // When Canceling adding an event
        $scope.cancelEvent = function () {
            // Redirect User
            $location.path('/MainMenu');
        }
       
}];

weLearnCntlrs.controller("indexController", indexCntlr)
             .controller("loggedInMenuController", menuCntlr)
             .controller("chatRoomController", ChatRoomController)
             .controller("eventManagerController", addOrUpdateEventController);
