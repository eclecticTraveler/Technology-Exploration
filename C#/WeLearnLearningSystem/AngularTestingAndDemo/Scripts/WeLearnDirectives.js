var weLearnDirectives = angular.module('weLearnDirectives', []);
weLearnDirectives.directive('scroll', scrollToBottom);

function scrollToBottom($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            scope.$watchCollection(attr.scroll, function (newVal) {
                //Note: $timeout is needed to ensure that the scroll position is set after the view is rendered.
                $timeout(function () {
                    element[0].scrollTop = element[0].scrollHeight;
                });
            });
        }
    }
};

















//weLearnDirectives.directive('chatMessageList', function () {
//                            return {
//                                scope: {
//                                    list: '=chatMessageList'
//                                },
//                                link: function (scope, element) {
//                                    scope.$watchCollection('list', function (newValue) {
//                                        //if (newValue) {
//                                        //    $(element).scrollTop($(element)[0].scrollHeight);
//                                        //}
//                                        var $list = $(element).find('#chatBox');
//                                        var height = $list[0].scrollHeight;
//                                        $list.scrollTop(height);
//                                        //var scrollHeight = $list.prop('scrollHeight');
//                                        //$list.animate({ scrollTop: scrollHeight }, 500);
//                                    });
//                                }
//                            }
//                        })
//weLearnDirectives.factory('schrollBottom', toBottom);

//function toBottom() {
//    return {
//        scope: {
//            schrollBottom: "="
//        },
//        link: function (scope, element) {
//            scope.$watchCollection('schrollBottom', function (newValue) {
//                if (newValue) {
//                    $(element).scrollTop($(element)[0].scrollHeight);
//                }
//            });
//        }
//    }
//};