var TodoApp = angular.module("TodoApp", ["ngRoute", "ngResource"])
                     .factory('Todo', Todo)
                     .config(function ($routeProvider) {
                         // When going on the some path '/' use the controller ListCtrl with the template specified bellow
                         // So basically when I go somewhere what code do you want me to use and how do you want me to display it
                         $routeProvider.
                             when('/',             { controller: ListCtrl,   templateUrl: 'list.html'    }).
                             when('/new',          { controller: CreateCtrl, templateUrl: 'details.html' }).
                             when('/edit/:editId', { controller: EditCtrl,   templateUrl: 'edit.html'    }).
                             otherwise({ redirectTo: '/' })
                     });


// calling the api c#
function Todo($resource) {
    // Anytime that we want to interact with our API go to the path below
    // Since $resource does not have a Put for updates we are appending one we have in here
    return $resource('/api/Todo/:id', { id: '@id' }, { update: { method: 'PUT' } });
}

var ListCtrl = function ($scope, $location, Todo) {
    $scope.search = function () {
        // Passing parameters from our API
        // $scope.items = Todo.query({sort: $scope.sort_order, desc: $scope.is_desc});
        // 
        // We are going to append more records to $scope.items
        // $resource has a second option after paramets which is success
        // Resource.action([parameters], [success], [error])
        // So you dont have to say: $scope.items = Todo.query({sort: $scope.sort_order, desc: $scope.is_desc});
        // rather you can say this and when it is successful the function to load more records is triggered
        Todo.query({
            // Q is the variable on our api to set the search meaining setting the given string on the where clause
             q: $scope.query
           , sort: $scope.sort_order
           , desc: $scope.is_desc
           , offset: $scope.offset
           , limit: $scope.limit
        }, function (data) {
            // Check whether not we got items left with each retrival 
            $scope.more = data.length === 20;
            // append to var items to give it the extra 20 or whatever rows
            $scope.items = $scope.items.concat(data);
        });
    };

    // Function that html template will call to change the order
    // of the sorting. If click once asc. Priority is the default
    $scope.sort = function (col) {
        // if both columns are already exactly the same
        if ($scope.sort_order === col) {
            // Then change the direction
            $scope.is_desc = !$scope.is_desc;
        } else {
            // Otherwise set the order and the direction to descenting
            $scope.sort_order = col;
            $scope.is_desc = false;
        }
        $scope.sort_order = col;
        // Call reset othewise its going to have a weird bug 
        // which will duplicate and append those rows
        $scope.reset();
    };


    // Function that will be loading so many records after each click
    $scope.show_more = function () {
        // add to the offset when clicked
        $scope.offset += $scope.limit;
        // then we want to rerun our query or query more
        $scope.search();
    };

    // Function that will change either true or false depending on if there
    // are more records to show
    $scope.has_more = function () {
        return $scope.more;
    };

    // Code that will delete the selected row to which will handle the id
    // for the row that was selected tecnically we can do it in the view
    // by passing into the function something like this delete({{item.Id}})
    // But since we are striving for MVC we will handle it in here the controller
    $scope.delete = function () {
        // Since angular creates a scope for each repeat I can 
        // use it in the controller and access the Id which is defined on
        // our backend
        var itemId = this.item.Id;
        // This will delete it on the DB but it will not display the change until refreshing
        // Then we will do a succesful callback
        Todo.delete({ id: itemId }, function () {
            // Your controller should not temper with the DOM that is mainly for directives 
            // but in this case its not such a huge deal 
            $("#item_" + itemId).fadeOut();
        });

    };

    // Reset is going to set all properties to default
    $scope.reset = function () {
         // set the limit of items that will be added to be displayed when click to show more
        $scope.limit = 20;
        // And this offset which will get the last of the records
        $scope.offset = 0;
        // Set the start loading results of the records to an empty set
        $scope.items = [];
        // if we manage to pull all the recods and thenere there is no more to show change to false
        $scope.more = true;
        // And then do the search otherwise it will set both as undefined
        $scope.search();
    }

    // Adding a default search order and sort by priority
    $scope.sort_order = "Priority";
    // set the direction so that it loads in asc order
    $scope.is_desc = false;
    // And then do call function reset to put all the defaults
    $scope.reset();



};


var CreateCtrl = function ($scope, $location, Todo) {

    // Function that will save the item the user needs
    // Angular is smart enough to dynamically create the object
    // item and fill it with its properties
    $scope.save = function () {
        // Save the item, which was never set to anything
        // util user starts filling out the form
        Todo.save($scope.item, function () {
            // If succesfull then add it to the list so that is displayed
            $location.path('/');
        })
    };
};
   
// the $routeParams comes from the id of the item to be edited and
// it is bringing this extra id into something called editId
// afterwards we will use this info to find the rest of its properties
// that is when this$routeParams comes in handy (creates a standard JS object with keys and valies)
var EditCtrl = function ($scope, $location, $routeParams, Todo) {
    // Set title and button label
    $scope.action = "Update";
    // Now we save the url appended id
    var itemId = $routeParams.editId;
    // Now we use the id to call our class and retrieve properties
    $scope.item = Todo.get({ id: itemId });

    $scope.save = function () {
        // Since this is supposed to update we won't use a POST method
        // rather a PUT method that we appended on the $resource
        // if successful we want to go to the root
        $scope.save = function () {
            Todo.update({ id: itemId }, $scope.item, function () {
                $location.path('/')
            });
        };

    }
};



//TodoApp.factory('Todo', function ($resource) {
//    return $resource('/api/todo/:id', { id: '@id' }, { update: { method: 'PUT' } });
//});

//var ListCtrl = function ($scope, $location, Todo) {
//    $scope.items = Todo.query();
//    log.console($scope.items);
//};


