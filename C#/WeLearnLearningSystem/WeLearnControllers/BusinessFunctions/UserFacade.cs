using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.BusinessInterfaces;
using WeLearnLib.Model;
using WeLearnLib.LazyObjTransformation;
using WeLearnLib.ModelToProcedure;
using System.Data.Entity;
using System.Data.Entity.Core.Objects;
using Newtonsoft.Json;



namespace WeLearnControllers.BusinessFunctions
{
    public class UserFacade : AbstractFacade<User>, UserFacadeRemote
    {
        private UserSerializable user;
        private List<CoursesSerializable> userCourses;
        private List<EventsSerializable> userEvents;

        public UserFacade()
            : base(typeof(User))
        {

        }
        public List<UserSerializable> getPeople(List<User> personsLazy, Decimal personId)
        {
            return null;
        }

        public List<UserSerializable> getUsers(List<User> personsLazy, Decimal personId)
        {
            return null;
        }

        public List<User> getAllUsers()
        {
            return null;
        }

        /// <summary>
        /// This Method will validate against the DB through a store proc to see
        /// if the user is indeed valid, if so then it will send the object to be
        /// solidify because by itself it won't be serializable due to its lazy dependencies
        /// Plus we want to send back only data that is important, not the username and password
        /// again since it can be hacked
        /// </summary>
        /// <param name="username"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        public Dictionary<String, Object> login(String username, String password)
        {

            // Create instance for mapped functions to DBprocedures to retrive data
            WeLearnDBmsEntities dbEntities = new WeLearnDBmsEntities();
            
            // Dictionary to be returned
            Dictionary<String, Object> loginData = new Dictionary<string, object>();         

            // Obtain results based on whether the person with username and password exists on the system
            // the var below is of return type -> ObjectResult<fun_IsUserInSystem_Result>
            var dbUserPropertiesLazyObjects = dbEntities.fun_IsUserInSystem(username, password);

            // Transform results in a list type -> List<fun_IsUserInSystem_Result>           
            List<fun_IsUserInSystem_Result> dbUserProfileList = dbUserPropertiesLazyObjects.ToList();

            // If list is empty then user is not valid since it did not validate againts the DB
            // If its valid send it over to get it solidified
            if (dbUserProfileList.Capacity > 0)
                user = (UserSerializable)ReshapeProperties.solidifyDatabaseObjects(dbUserProfileList);
            else
                return null;
         
            //  By now the user is validated and we have the user profile. Now retrive User Raw Courses Data
            //  Return type -> ObjectResult<fun_GetOrRetriveAllCoursesFromUser_Result> 
            var dbUserCoursesLazyObjs = dbEntities.fun_GetOrRetriveAllCoursesFromUser((long)user.getPersonId());

            // Make the Complex object into a list
            List<fun_GetOrRetriveAllCoursesFromUser_Result> dbUserCoursesList = dbUserCoursesLazyObjs.ToList();

            // Solidify User Courses 
            if (dbUserCoursesList.Capacity > 0)
                    userCourses = (List<CoursesSerializable>) ReshapeProperties.solidifyDatabaseObjects(dbUserCoursesList); 

            // Get all the user Events -> "CE" Calendar Events
            // This var is of type -> ObjectResult<fun_GetOrRetriveAllCoursesFromUser_Result> 
            var dbEventsLazyObjects = dbEntities.fun_GetOrRetriveUserDocuments((long)user.getPersonId(), "CE");

            // Now Set them into a list
            List<fun_GetOrRetriveUserDocuments_Result> dbUserEventsList = dbEventsLazyObjects.ToList();

            // Solidify them
            if (dbUserEventsList.Capacity > 0)
                userEvents = (List<EventsSerializable>)ReshapeProperties.solidifyDatabaseObjects(dbUserEventsList);

            // Lets wrap all into a dictionary
            loginData.Add("UserProfile", user);
            loginData.Add("UserCouses" , userCourses);
            loginData.Add("UserEvents" , userEvents);;

            //String testSerialization = JsonConvert.SerializeObject(loginData);

            // Lets send it back  
            return loginData;
        }
    }
}
