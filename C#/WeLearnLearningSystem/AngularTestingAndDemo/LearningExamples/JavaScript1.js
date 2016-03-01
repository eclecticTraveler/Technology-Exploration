// All with method chaining

// Create the module and Register the controller with the module
var myApp = angular.module("mainModule", [])



// Create the First controller
var myFirstController = function ($scope) {
    var employee = {
        firstName: "Alberto",
        lastName: "Arellano",
        gender: "Male"
    };

    $scope.message = "AngularJS Tutorial";
    $scope.employee = employee;
};


var mySecondController = function ($scope) {
    var people = [
        { name: 'Jani', country: 'Norway' },
        { name: 'Hege', country: 'Sweden' },
        { name: 'Kai', country: 'Denmark' }
    ];


    $scope.people = people;
};


var myThirdController = function ($scope, $http) {
    $http.get("http://www.w3schools.com/angular/customers.php")
    .then(function (response) { $scope.names = response.data.records; });
}

var myFourthController = function ($scope) {
    $scope.count = 0;
}
var myFifthController = function ($scope) {
    $scope.myVariable = false;
    $scope.toggle = function () {
        $scope.myVariable = !$scope.myVariable;
    };
}

var mySixthController = function ($scope) {
    $scope.showIt = true;
    $scope.toggle = function () {
        $scope.showIt = !$scope.showIt;
    };
}


var mySeventhController = function ($scope) {
    var countries = [
         {
             name: "UK",
             cities: [
                 { name: "London" },
                 { name: "Manchester" },
                 { name: "Birmingham" },

             ]

         },
         {
             name: "US",
             cities: [
                 { name: "Los Angeles" },
                 { name: "Chicago" },
                 { name: "Houston" },

             ]

         },
         {
             name: "BRAZIL",
             cities: [
                 { name: "Sao Paulo" },
                 { name: "Belo Horizonte" },
                 { name: "Rio de Janeiro" },

             ]

         },
         {
             name: "Mexico",
             cities: [
                 { name: "DF" },
                 { name: "Guadalajara" },
                 { name: "Monterrey" },

             ]

         }
    ];

    $scope.countries = countries;

}

var myEighthController = function ($scope) {
    var technologies = [
		{ name: "C#", likes: 0, dislikes: 0 },
		{ name: "ASP.NET", likes: 0, dislikes: 0 },
		{ name: "SQL Server", likes: 0, dislikes: 0 },
		{ name: "AngularJS", likes: 0, dislikes: 0 },
    ];

    $scope.technologies = technologies;

    // Function to increment likes
    $scope.incrementLikes = function (technology) {
        technology.likes++;
    }
    // Function to increment dislikes
    $scope.incrementDislikes = function (technology) {
        technology.dislikes++;
    }
}


var myNinthController = function ($scope) {
    var employees = [
		{ name: "Ben", dateOfBirth: new Date("November 23 1980"), gender: "Male", salary: 55000.788 },
		{ name: "Sara", dateOfBirth: new Date("May 05 1970"), gender: "Female", salary: 68000 },
		{ name: "Mark", dateOfBirth: new Date("August 15 1974"), gender: "Male", salary: 57000 },
		{ name: "Pam", dateOfBirth: new Date("October 27 1979"), gender: "Female", salary: 53000 },
		{ name: "Todd", dateOfBirth: new Date("December 30 1983"), gender: "Male", salary: 60000 }
    ];

    $scope.employees = employees;

    // Init so that it only shows three rows
    $scope.rowLimit = 3;

}

var myTenthController = function ($scope) {
    var employees = [
		{ name: "Ben", dateOfBirth: new Date("November 23 1980"), gender: "Male", salary: 55000.788 },
		{ name: "Sara", dateOfBirth: new Date("May 05 1970"), gender: "Female", salary: 68000 },
		{ name: "Mark", dateOfBirth: new Date("August 15 1974"), gender: "Male", salary: 57000 },
		{ name: "Pam", dateOfBirth: new Date("October 27 1979"), gender: "Female", salary: 53000 },
		{ name: "Todd", dateOfBirth: new Date("December 30 1983"), gender: "Male", salary: 60000 }
    ];

    $scope.employees = employees;

    // Init so that it only shows three rows
    $scope.sortColumn = "name";

}

var myEleventhController = function ($scope) {
    var employees = [
		{ name: "Ben", dateOfBirth: new Date("November 23 1980"), gender: "Male", salary: 55000.788 },
		{ name: "Sara", dateOfBirth: new Date("May 05 1970"), gender: "Female", salary: 68000 },
		{ name: "Mark", dateOfBirth: new Date("August 15 1974"), gender: "Male", salary: 57000 },
		{ name: "Pam", dateOfBirth: new Date("October 27 1979"), gender: "Female", salary: 53000 },
		{ name: "Todd", dateOfBirth: new Date("December 30 1983"), gender: "Male", salary: 60000 }
    ];

    $scope.employees = employees;

    // Init so that it only shows three rows
    $scope.sortColumn = "name";
    $scope.reverseSort = false;

    // Function that provides sorting capabilities
    $scope.sortData = function (column) {
        $scope.reverseSort = ($scope.sortColumn == column) ? !$scope.reverseSort : false;
        $scope.sortColumn = column;

    }

    $scope.getSortClass = function (column) {
        if ($scope.sortColumn == column) {
            // If true change the CSS class to arrow down
            return $scope.reverseSort ? 'arrow-down' : 'arrow-up';
        }
        // return '';
    }

}

var myTwelvethController = function ($scope, $http) {
    $http.get("http://www.w3schools.com/angular/customers.php")
    .then(function (response) { $scope.names = response.data.records; });
};

var myThirdteenthController = function ($scope) {
    var employees = [
         { name: "Ben", dateOfBirth: new Date("November 23 1980"), gender: "Male", country: "Brazil" },
         { name: "Sara", dateOfBirth: new Date("May 05 1970"), gender: "Female", country: "Argentina" },
         { name: "Mark", dateOfBirth: new Date("August 15 1974"), gender: "Male", country: "Chile" },
         { name: "Pam", dateOfBirth: new Date("October 27 1979"), gender: "Female", country: "USA" },
         { name: "Todd", dateOfBirth: new Date("December 30 1983"), gender: "Male", country: "Italy" }
    ];

    $scope.employees = employees;

    // Function for matching 2 properties on searching
    $scope.search = function (item) {
        // If it is undefined 
        if ($scope.searchText == undefined) {
            // If the user hasn't put anything we
            // set it to true so that we can still show the table
            return true;
        }
        else {
            // If the index of the column name and city is not negative display all
            if (item.country.toLowerCase().indexOf($scope.searchText.toLowerCase()) != -1 ||
				item.name.toLowerCase().indexOf($scope.searchText.toLowerCase()) != -1) {
                return true;
            }
        }
        // If none of the conditions match then the user has typed something that matched
        return false;
    }
};


var myFourteenthController = function ($scope) {
    var employees = [
         { name: "Ben", gender: 1, country: "Brazil" },
         { name: "Sara", gender: 2, country: "Argentina" },
         { name: "Mark", gender: 1, country: "Chile" },
         { name: "Pam", gender: 2, country: "USA" },
         { name: "Todd", gender: 3, country: "Italy" }
    ];

    $scope.employees = employees;

    // Function for matching 2 properties on searching

};

var filterByGender = function () {
    return function (gender) {
        switch (gender) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            case 3:
                return "Not disclosed";

        }
    }
}

var myFiveteenthController = function ($scope, $http, $log) {
    // Requesting the information through a GET
    $http.get("../EmployeeHandler.asmx/GetEmployees")
        // It might not be ready right away that is why we use .then and an anonymous function
         .then(function (response) {
             $scope.employees = response.data;
             // In order to make all its specification available if we want, visible in the devTools Chrome
             // Good for debugging
             $log.info(response);
             // Lets do another anonymous function to display message if there was an error
         }, function(reason){
             $scope.error = reason.data;
             $log.info(reason);
         });
}

var successCallBack = function (response) {
    $scope.employees = response.data;
}

var errorCallBack = function (response) {
    $scope.error = reason.data;
}

var alternativeHTTP = function ($scope, $http, $log) {
    $http({
        method: 'GET',
        url:'../EmployeeHandler.asmx/GetEmployees'})
    .then(successCallBack, errorCallBack);
   
}


//var StringServices = function () {
//    return {
//        processString: function (userInput) {
//            // If input is not empty return it like it is
//            if (!userInput) {
//                return userInput;
//            }
//            // create result back
//            var output = "";
//            // loop through input string
//            for (var i = 0; i < userInput.length; i++) {
//                // skip first letter and compare
//                if (i > 0 && userInput[i] == userInput[i].toUpperCase()) {
//                    output = output + " ";
//                }
//                // if not true just append
//                output = output + userInput[i];
//            }
//            // return
//            return output;
//        }

//    }
//}


var mySixteenthController = function ($scope, stringService) {
    // Function that will be clicked
    $scope.transformString = function (userInput) {
        // moved and converted to a service please see script stringService.js
        // but for now I am calling the function withing my new service
        $scope.sysOutput = stringService.processString(userInput);

    }

}

var mySeventeenthController = ["$scope", function (a) {
    a.newMessage = "This is a dependency Injection that can work through a minifier"
}];

myApp.controller("firstCntlr", myFirstController)
	 .controller("secondCntlr", mySecondController)
	 .controller("thirdCntlr", myThirdController)
	 .controller("fourthCntlr", myFourthController)
	 .controller("fifthCntlr", myFifthController)
	 .controller("sixthCntlr", mySixthController)
	 .controller("seventhCntlr", mySeventhController)
	 .controller("eightCntlr", myEighthController)
	 .controller("ninthCntlr", myNinthController)
	 .controller("tenthCntlr", myTenthController)
	 .controller("eleventhCntlr", myEleventhController)
	 .controller("twelveCntlr", myTwelvethController)
	 .controller("thirdteenthCntlr", myThirdteenthController)
	 .controller("fourteenthCntlr", myFourteenthController)
	 .filter("gender", filterByGender)
	 .controller("fiveteenthCntlr", myFiveteenthController)
	 .controller("sixteenthCntlr", mySixteenthController)
     .controller("seventhCntlr", mySeventeenthController);
     //.factory('stringService', StringServices);

