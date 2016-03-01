// Create the module and Register the controller with the module
var myApp = angular.module("weLearnApp", [])

var ChatRoomController = function ($scope, $http, $log, portalFactory) {
    $http.get('../ChatHandler.asmx/ChatString').then(function (response) {

        //var allinfo = response.data;
        //console.log(allinfo);
        //var chatParticipants = allinfo.people;
        //var chatMessages = allinfo.chatMesseages;
        var chatParticipants = response.data.people;
        var chatMessages = response.data.chatMesseages;

        portalFactory.setChatParticipants(chatParticipants);
        portalFactory.setChatMessages(chatMessages);

        $scope.chatUsers = portalFactory.getChatParticipants();
        $scope.chatMsn = portalFactory.getChatMessages();

        console.log(chatParticipants);
    })

};

function PortalFactory() {
    var events = [];
    var courses = [];
    var grades = [];
    var chatMessages = [];
    var blogMessages = [];
    var chatParticipants = [];
    var chatAllUsers = [];
    var username = "";

    return {
        setEvents: function (events) {
            this.events = events;
        },
        getEvents: function () {
            return this.events;
        },
        jsonParseEvents: function () {
            for (i = 0; i < this.events.length; i++) {
                jsonObj = JSON.parse(this.events[i]);
                this.events[i] = jsonObj;
            }
        },
        setCourses: function (courses) {
            this.courses = courses;
        },
        getCourses: function () {
            return this.courses;
        },
        setGrades: function (grades) {
            this.grades = grades;
        },
        getGrades: function () {
            return this.grades;
        },
        setChatMessages: function (chatMessages) {
            this.chatMessages = chatMessages;
        },
        getChatMessages: function () {
            return this.chatMessages;
        },
        setChatParticipants: function (chatParticipants) {
            this.chatParticipants = chatParticipants;
        },
        getChatParticipants: function () {
            return this.chatParticipants;
        },
        setChatAllUsers: function (chatAllUsers) {
            this.chatAllUsers = chatAllUsers;
        },
        getChatAllUsers: function () {
            return this.chatAllUsers;
        },
        setBlogMessages: function (blogMessages) {
            this.blogMessages = blogMessages;
        },
        getBlogMessages: function () {
            return this.blogMessages;
        },
        setUsername: function (userName) {
            this.userName = userName;
        },
        getUsername: function () {
            return this.userName;
        }
    }


}

myApp.controller("chatRoomController", ChatRoomController)
      .factory("portalFactory", PortalFactory);
   //.directive('schrollBottom', function () {
      //    return {
      //        scope: {
      //            schrollBottom: "="
      //        },
      //        link: function (scope, element) {
      //            scope.$watchCollection('schrollBottom', function (newValue) {
                      
      //                    $(element).scrollTop($(element)[0].scrollHeight);
                      
      //            });
      //        }
      //    }
      //});

// Best practice
//angular.module('app').factory('ProductsService', function($http) {
//    return {
//        getProduct: function(id) {
//            return $http.get('/products').then(function(response) {
//                return response.data;
//            });
//        };
//};
//});

// You can do also
//angular.module('app')
//       .factory('dataservice', ['$http', dataservice]);

//function dataservice($http) {
//    var service = {
//        getAvengers: getAvengers
//    };
//    return service;

//    function getAvengers() {
//        return $http.get('/api/maa');
//    }
//}