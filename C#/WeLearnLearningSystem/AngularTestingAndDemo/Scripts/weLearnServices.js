var weLearnServices = angular.module('weLearnService', ['ngResource']);

weLearnServices.factory('GeneralFeaturesCache', weLearnCache)
weLearnServices.factory('UserCache', usersCache)
weLearnServices.factory('ChatServices', chatCache);


function weLearnCache($resource) {
    var allUserInfo = [];
    var userProfile = [];
    var userCourses = [];
    var userEvents = [];
    var innerUserEvents = [];
    var eventToBeEdited = [];

    return {
        setAllUserInfo: function (userInfo) {
            allUserInfo = userInfo;
        },
        getAllUserInfo: function () {
            return allUserInfo;
        },
        setUserProfile: function (profile) {
            userProfile = profile;
        },
        getUserProfile: function () {
            return userProfile;
        },
        setUserCourses: function (courses) {
            userCourses = courses;
        },
        getUserCourses: function () {
            return userCourses;
        },
        setUserEvents: function (events) {
            userEvents = events;
        },
        getUserEvents: function () {
            return userEvents;
        },
        setInnerUserEvents: function (innerEvents) {
            innerUserEvents = innerEvents;
        },
        getInnerUserEvents: function () {
            return innerUserEvents;
        },
        pushInnerUserEvents: function (innerEvent) {
            if (innerEvent !== null || innerEvent !== undefined) {
                innerUserEvents.push(innerEvent);
            }
            
        },
        setEventToBeEdited: function (event) {
            eventToBeEdited = event;
        },
        getEventToBeEdited: function () {
            return eventToBeEdited;
        },
        setUpdatedEvent: function (event, uuid) {
            // Find index of object that has this UUID in InnerUserEVents
            for (var i = 0; i < innerUserEvents.length; i++) {
                // If the object in the current position has a UUID store new Object
                if (innerUserEvents[i].Id === uuid) {
                    // Position, howmany to remove, and obj that will subtite it
                    innerUserEvents.splice(i, 1, event);
                    break;
                }
            }

        }


        
    }

    //var cachedData;
    //return $resource('MagicScripts/all.json', {}, {
    //    query: { method: 'GET', params: {}, isArray: true, cache: true }
    //});
};

function chatCache(UserCache, $http) {
    // This handler is apperently a legacy to the new web api with one advantage which is being able to execute
    // many functions inside of this handler, while being practically deprived of recieving a natural http response
    // thus having to work around it quite a bit to get the result
    //$http.get('../Handlers/ChatHandler.asmx/ChatString').then(function (response) {


   

}

function usersCache() {

    // local variables only accesible to the other factories
    var allMessages = [];
    var chatParticipants = [];
    var chatMessages = []
    var allUserMsns = [];

    var showCollapsedMenuNav = false;
    var showBigResolMenuNav = false;
    var showHambuguerButton = false;
    var personFullName = "";
    var personPicAddress = "";
    var subtitleOnEventPage = "Default";
    var buttonLabelOnEventPage = "Default";

    var allUsers = [];

    var upperBarItems =
     {
         webTitle: 'We Learn',
         messages: 'Messages',
         notifications: 'Notifications',
         profile: 'Profile',
         inbox: 'Inbox',
         calendar: "Event Manager",
         settings: 'Settings',
         logout: 'Log Out'

     };

    return {
        setSelectedPersonInfo: function (userId) {
            angular.forEach(chatParticipants, function (value, key) {
                // If we find the person we are looking for
                if (value.personId === userId) {
                    // Get his or her name and picture
                    personFullName = value.firstName + " " + value.lastName;
                    personPicAddress = value.userPicAddress;
                }
            });
        },
        getSelectedPersonInfo: function () {
            return personFullName;
        },
        getSelectedPersonPic: function () {
            return personPicAddress;
        },
        setChatMessages: function (messages) {
            chatMessages = messages;
        },
        getChatMessages: function () {
            return chatMessages;
        },
        setChatParticipants: function (participants) {
            chatParticipants = participants;
        },
        getChatParticipants: function () {
            return chatParticipants;
        },
        setChatAllUsers: function (chatAllUsers) {
            allUsers = chatAllUsers;
        },
        getChatAllUsers: function () {
            return allUsers;
        },
        setHamButton: function (hamButton) {
            showHambuguerButton = hamButton;
        },
        getHamButton: function () {
            return showHambuguerButton;
        },
        setSmallMenu: function (isShowing) {
            showCollapsedMenuNav = isShowing;
        },
        getSmallMenu: function () {
            return showCollapsedMenuNav;
        },
        setBigMenu: function (isShowing) {
            showBigResolMenuNav = isShowing;
        },
        getBigMenu: function () {
            return showBigResolMenuNav;
        },
        setUpperBarItems: function (upperBar) {
            upperBarItems = upperBar;
        },
        getUpperBarItems: function () {
            return upperBarItems;
        },
        setSubtitleOnEventPage: function (subTitle) {
            subtitleOnEventPage = subTitle;
        },
        getSubtitleOnEventPage: function () {
            return subtitleOnEventPage;
        },
        setButtonLabelOnEventPage: function (buttonTitle) {
            buttonLabelOnEventPage = buttonTitle;
        },
        getButtonLabelOnEventPage: function () {
            return buttonLabelOnEventPage;
        }

    }

};