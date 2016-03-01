using System;
using System.Collections.Generic;
using System.Data.Entity.Core.Objects;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;
using Newtonsoft.Json;

namespace WeLearnLib.LazyObjTransformation
{
    public class ReshapeProperties
    {
        

        public static Object solidifyDatabaseObjects(Object lazyProperties)
        {
         
          try
            {
                // Double check list is not empty
                if (lazyProperties == null)
                {
                    return null;
                }

                // Remove the Lazy Objects appended to the List and solidify Object with necessary data

                if (lazyProperties is List<fun_IsUserInSystem_Result>)
                {
                    // Cast object to its proper type
                    List<fun_IsUserInSystem_Result> userProperties = (List<fun_IsUserInSystem_Result>)lazyProperties;
                    // Reshape LazyObject
                    UserSerializable potentialUser = new UserSerializable(
                           userProperties.FirstOrDefault().userId
                         , userProperties.FirstOrDefault().lastName
                         , userProperties.FirstOrDefault().firstName
                         , userProperties.FirstOrDefault().email
                         , userProperties.FirstOrDefault().gender
                         , userProperties.FirstOrDefault().typeOfUser
                         , userProperties.FirstOrDefault().userPicAddress
                         );

                    return potentialUser;
                }
                else if (lazyProperties is List<fun_GetOrRetriveAllCoursesFromUser_Result>)
                {
                    // Cast object to its proper type
                    List<fun_GetOrRetriveAllCoursesFromUser_Result> userCourseProperties = (List<fun_GetOrRetriveAllCoursesFromUser_Result>)lazyProperties;

                    // Make new list to get all Courses into
                    List<CoursesSerializable> userCoursesList = new List<CoursesSerializable>();

                    // Remove the Lazy Objects appended to the List and solidify Object with necessary data
                    foreach (var course in userCourseProperties)
                    {
                        userCoursesList.Add(new CoursesSerializable(course.courseName, course.courseCode));
                    }

                    return userCoursesList;
              } 
              else if (lazyProperties is List<fun_GetOrRetriveUserDocuments_Result>)
              {
                  // Cast
                  List<fun_GetOrRetriveUserDocuments_Result> userEventsProperties = (List<fun_GetOrRetriveUserDocuments_Result>)lazyProperties;
                  // Remove Lazy by building object
  
                  // Make new list to get all Events from user into
                  List<EventsSerializable> userEventsList = new List<EventsSerializable>();

                  // Remove the Lazy Objects appended to the List and solidify Object with necessary data
                  foreach (var userEvent in userEventsProperties)
                  {
                      userEventsList.Add(new EventsSerializable(
                        userEvent.docText
                      , userEvent.docDesc
                      , Convert.ToString(userEvent.docDate)
                      ));
                  }

                  return userEventsList;

              }
                return null;
                
            }
            catch (Exception ex)
            {
                String debug = ex.ToString();
                String de = debug;
                return null;

            }
           
        }
    }
}
