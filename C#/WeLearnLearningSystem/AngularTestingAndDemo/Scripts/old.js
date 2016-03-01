var main = angular.module('weLearnApp', ['ngRoute', 'simpleCalendar', 'datePicker', 'timePicker', 'ui.bootstrap'])
        .controller("mainController", MainController)
        .controller("portalController", PortalController)
        .controller("mainMenuController", MainMenuController)
        .controller("calendarController", CalendarController)
        .controller("documentsController", DocumentsController)
        .controller("gradesController", GradesController)
        .controller("chatRoomController", ChatRoomController)
        .factory("calendarFactory", CalendarFactory)
        .factory("portalFactory", PortalFactory)
        .factory("gradesFactory", GradesFactory)
        .factory("documentFactory", DocumentFactory)
        .factory("chatFactory", ChatFactory)
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'pages/loginPage.html',
                        controller: 'mainController'
                    })
                    .when('/portal', {
                        templateUrl: 'pages/portal.html',
                        controller: 'portalController'
                    })
                    .when('/calendar', {
                        templateUrl: 'pages/calendar.html',
                    })
                    .when('/add-event', {
                        templateUrl: 'pages/add-event.html'
                    })
                    .when('pages/assignment.html', {
                        templateUrl: 'pages/assignment',
                        controller: 'assignmentController'
                    })
                    .when('pages/documents.html', {
                        templateUrl: 'pages/Documents',
                        controller: 'DocumentsController'
                    })
                    .when('/grades', {
                        templateUrl: 'pages/grades.html',
                        controller: 'gradesController'
                    })
                    .when('/mainMenu', {
                        templateUrl: 'pages/mainMenu.html',
                        controller: 'mainMenuController'
                    })
                    .when('/ChatRoom', {
                        //                        templateUrl: 'pages/temporalStaticChat.html',
                        templateUrl: 'pages/chatRoom.html',
                        controller: 'chatRoomController'
                    });
        });

function MainController($rootScope, $scope, $http, $location, portalFactory, calendarFactory, gradesFactory, documentFactory, chatFactory) {
    $scope.showErr = false;
    $rootScope.loggedIn = false;
    $rootScope.chatBoxVisibility = false;

    $scope.formData = {};


    $scope.login = function () {
        var url = "PortalHandler"
                + "?username=" + $scope.formData.username
                + "&password=" + $scope.formData.password;
        $http.get(url).then(function (response) {
            // when the response is available
            portalFactory.setEvents(response.data.events);
            portalFactory.jsonParseEvents();
            portalFactory.setCourses(response.data.courses);
            portalFactory.setGrades(response.data.grades);


            $rootScope.loggedIn = true;
            $rootScope.chatBoxVisibility = true;
            $location.path("/mainMenu");

            // Save username
            //            portalFactory.setUsername($scope.formData.username);
        }, function (data, status) {
            // or server returns response with an error status.
            $scope.errorMsg = data.statusText;
            $scope.showErr = true;
        });
    };


    $scope.chatRoom = function () {
        ChatRoomController($rootScope, $scope, $http, $location, portalFactory);

    };

    $scope.calendar = function () {
        $http.get("CalendarHandler").then(function (response) {
            // when the response is available
            calendarFactory.setEvents(response.data.events);
            $location.path("/calendar")
        }, function () {
            // or server returns response with an error status.
        });
    };



    $scope.getDocument = function () {
        $http.get("DocumentsHandler").then(function (response) {
            // when the response is available
            documentFactory.setDocument(response.data.document);
            documentFactory.setDocument(response.data.documentList);
            $location.path("/documents")
        }, function () {
            // or server returns response with an error status.
        });
    };

    $scope.displayDocuments = function () {
        $scope.document = documentFactory.getDocument();
        $scope.documentList = documentFactory.getDocumentList();
    };

    $scope.grades = function () {
        $http.get("GradesHandler").then(function (response) {
            console.log("grades()");
            gradesFactory.setGrades(response.data.documents);
            $location.path("/grades")
        }, function () {

        });
    };



}
;

function ChatRoomController($rootScope, $scope, $http, $location, portalFactory) {

    // Get the info from the servelet
    $http.get("ChatHandlerNew").then(function (response) {
        // Once the response is available

        // Getting JSON String from backend
        var chatParticipants = response.data.participants;
        var chatMessages = response.data.messages;
        var chatAllUsers = response.data.allSystemUsers;
        // and makes the URL available to your application.
        // 
        // 
        // setting and storing the JSON from Backend
        portalFactory.setChatParticipants(chatParticipants);
        portalFactory.setChatMessages(chatMessages);
        portalFactory.setChatAllUsers(chatAllUsers);

        $location.path("/ChatRoom");
        $rootScope.chatBoxVisibility = false;
        // Retriving the backend info
        $scope.chatParticipants = portalFactory.getChatParticipants();
        $scope.chatMessages = portalFactory.getChatMessages();
        $scope.chatAllUsers = portalFactory.getChatAllUsers();
    });

    $scope.submitChatInput = function (chatData) {
        // Get object with user input from chat
        $scope.chatUserString = chatData.chatInput;
        // Concat the user string not the object 
        var url = "ChatHandlerNew"
                + "?cmd=add"
                + "&message=" + $scope.chatUserString;
        // Send to the ChatHandlerNew the response
        $http.get(url).then(function (response) {

            // Getting JSON String from backend
            var chatParticipants = response.data.participants;
            var chatMessages = response.data.messages;
            var chatAllUsers = response.data.allSystemUsers;
            // and makes the URL available to your application.
            // 
            // 
            // setting and storing the JSON from Backend
            portalFactory.setChatParticipants(chatParticipants);
            portalFactory.setChatMessages(chatMessages);
            portalFactory.setChatAllUsers(chatAllUsers);

            $location.path("/ChatRoom");
            $rootScope.chatBoxVisibility = false;
            // Retriving the backend info
            $scope.chatParticipants = portalFactory.getChatParticipants();
            $scope.chatMessages = portalFactory.getChatMessages();
            $scope.chatAllUsers = portalFactory.getChatAllUsers();
        });
        //Clear input form
        var clearChatInput = {
            chatInput: ''
        };
        $scope.chatData = angular.copy(clearChatInput);
        $scope.chatInputField.$setPristine();


    };

};




function PortalController($rootScope, $scope, portalFactory) {
    $scope.events = portalFactory.getEvents();
}
;

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

function MainMenuController($rootScope, $scope, portalFactory) {
    $scope.events = portalFactory.getEvents();
    $scope.courses = portalFactory.getCourses();
    $scope.grades = portalFactory.getGrades();



}

function DocumentFactory() {
    var document;
    var documentList;
    return {
        setDocument: function (document) {
            this.document = document;
        },
        getDocument: function () {
            return this.document;
        },
        setDocumentList: function (documentList) {
            this.documentList = documentList;
        },
        getDocumentList: function () {
            return this.documentList;
        }
    }
}

function DocumentsController($rootScope, $scope) {

}




function CalendarController($scope, portalFactory, $location, $http) {
    $scope.events = portalFactory.getEvents();
    var yearItem = {};
    var monthItem = {};
    var dayItem = {};
    for (var i = 0; i < $scope.events.length; i++) {
        var d = new Date($scope.events[i].start);
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        var day = d.getDate();
        dayItem[day] = [$scope.events[i].title]
        monthItem[month] = dayItem;
        yearItem[year] = monthItem;
        $scope.calendarContent = yearItem
    }
    ;

    $scope.addEvent = function () {
        $location.path("/add-event")
    };
    $scope.newEvent = function (portalFactory) {
        var titleValue = document.getElementById("inputEventTitle").value;
        var startDateValue = document.getElementById("date").value;
        var hours = parseInt(document.getElementById('hours').value);
        var minutes = document.getElementById('minutes').value;
        var indicator = document.getElementById('pm').innerHTML;
        var d = new Date(startDateValue);
        if (indicator == 'PM') {
            hours = hours + 12;
        }
        d.setHours(hours);
        d.setMinutes(minutes);
        var event = {
            "title": titleValue,
            "start": d.toUTCString()
        }

        jsonEvent = JSON.stringify(event);
        url = "DocumentsHandler?cmd=add&event=" + jsonEvent;
        $http.get(url).then(function (response) {
            // when the response is available
            portalFactory.setEvents(response.data.events);
            portalFactory.jsonParseEvents();

        }, function (data, status) {
            // or server returns response with an error status.
            $scope.errorMsg = data.statusText;
            $scope.showErr = true;
        });
        $location.path('/calendar');

    }


}
;

function CalendarFactory() {
    var events = [];

    return {
        setEvents: function (events) {
            this.events = events;
        },
        getEvents: function () {
            return this.events;
        }
    };
}

function GradesController($scope, gradesFactory) {
    console.log("Grades Controller");
    $scope.grades = gradesFactory.getGrades();
}

function GradesFactory() {
    var grades = [];
    console.log("GradesFactory")

    return {
        setGrades: function (grades) {
            this.grades = grades;
        },
        getGrades: function () {
            return this.grades;
        }
    };
};

function ChatFactory() {
    var chatParticipants = [];
    var chatMessages = [];
    console.log("ChatFactory");

    return {
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
        }
    };
};

