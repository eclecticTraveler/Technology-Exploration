myApp.factory('stringService', StringServices);
// This is not an anonymous function so associate it with its name
function StringServices() {
    return {
        processString: function (userInput) {
            // If input is not empty return it like it is
            if (!userInput) {
                return userInput;
            }
            // create result back
            var output = "";
            // loop through input string
            for (var i = 0; i < userInput.length; i++) {
                // skip first letter and compare
                if (i > 0 && userInput[i] == userInput[i].toUpperCase()) {
                    output = output + " ";
                }
                // if not true just append
                output = output + userInput[i];
            }
            // return
            return output;
        }
              
    }
}



// Alternative
//myApp.factory('stringService', function () {
//    return {
//        processString: function (userInput) {
//            if (!userInput)
//                return userInput;
    
//    var output = ""; 
    
//    for (var i = 0; i < userInput.length; i++) {
//        if (i > 0 && userInput[i] == userInput[i].toUpperCase()) {
//            output = output + " ";
//        } output = output + userInput[i];
//    } return output;
//}
//};
//});

// Debugging
//myApp.factory('stringService', function () {
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
//});