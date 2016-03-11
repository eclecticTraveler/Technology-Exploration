using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.BusinessInterfaces;
using WeLearnLib.LazyObjTransformation;
using WeLearnLib.Model;
using WeLearnLib.WeLearnObjects;

namespace WeLearnControllers.BusinessFunctions
{
   public class DocumentFacade : AbstractFacade<Document>, DocumentFacadeRemote
    {
       private List<ChatMessagesSerializable> chatMessagesList;
       private List<EventsSerializable> userEvents;
 
        public DocumentFacade() 
            : base(typeof(Document)){

        }

        public Dictionary<String, Object> addDocument(Decimal personId, String contextType, String docText, String docUrl, String docType, String shortDescr)
        {
            return null;
        }

       public List<Document> getCourseList(Decimal personId)
        {
            return null;
        }

       public List<Document> getFinalGrades(Decimal personId)
       {
           return null;
       }

       public void setEvent(UserEvent userEvent)
       {
           // Check if what we recieve is not not
           if (userEvent == null)
        	{
                return;		 
	        }

           Document calendarEvent = new Document();
           calendarEvent.docUUID = userEvent.DocUUID;
           calendarEvent.docType = userEvent.DocType;
           calendarEvent.docContext = userEvent.DocContext;
           calendarEvent.docText = userEvent.DocText;
           calendarEvent.docVersion = (long)userEvent.DocVersion;
           calendarEvent.docDate = userEvent.DocDate;
           calendarEvent.docDesc = userEvent.DocDesc;
           // Send object to be created in Database
           this.create(calendarEvent, userEvent.UserLogged);
       }

       public void updateEvent(UserEvent userEvent)
       {
           // Check if what we recieve is not not
           if (userEvent == null)
           {
               return;
           }

           Document updateEvent = new Document();
           updateEvent.docUUID = userEvent.DocUUID;
           updateEvent.docType = userEvent.DocType;
           updateEvent.docContext = userEvent.DocContext;
           updateEvent.docText = userEvent.DocText;
           updateEvent.docVersion = (long)userEvent.DocVersion;
           updateEvent.docDate = userEvent.DocDate;
           updateEvent.docDesc = userEvent.DocDesc;
           // Send object to be created in Database
           this.edit(updateEvent, userEvent.UserLogged);


       }
       public void deleteEvent(UserEvent userEvent)
       {
           // Check if what we recieve is not not
           if (userEvent == null)
           {
               return;
           }

           Document updateEvent = new Document();
           updateEvent.docUUID = userEvent.DocUUID;
           updateEvent.docType = userEvent.DocType;
           updateEvent.docContext = userEvent.DocContext;
           updateEvent.docText = userEvent.DocText;
           updateEvent.docVersion = (long)userEvent.DocVersion;
           updateEvent.docDate = userEvent.DocDate;
           updateEvent.docDesc = userEvent.DocDesc;
           // Send object to be created in Database
           this.remove(updateEvent, userEvent.UserLogged);
       }

       public Dictionary<String, Object> getChatConversation(Decimal personLoggedIn, Decimal personChattingWith)
       {
           // Return if null values are send
           if ((personLoggedIn <= 0) || (personChattingWith <= 0))
           {
               return null;
           }
           // Dictionary to be returned and list of chats
           Dictionary<String, Object> loginData = new Dictionary<string, object>();
           chatMessagesList = new List<ChatMessagesSerializable>();
           // Create instance for mapped functions to DBprocedures to retrive data
           WeLearnDBmsEntities dbEntities = new WeLearnDBmsEntities();
           // Call Function mapped to Sto Proc  type -> ObjectResult<spGetUserChatConversation_Result>
           var dbAllChatConversation = dbEntities.spGetUserChatConversation((long)personLoggedIn, (long)personChattingWith);
           // Transform results in a list type           
           List<spGetUserChatConversation_Result> dbChatConversation = dbAllChatConversation.ToList();
           // If its valid send it over to get it solidified 
           if (dbChatConversation.Capacity > 0)
               foreach (var chatConversation in dbChatConversation)
               {
                   chatMessagesList.Add(new ChatMessagesSerializable(chatConversation.docText));
               }
           else
               return null;
               
           
           // Lets wrap all into a dictionary
           loginData.Add("chatMessages", chatMessagesList);


           return loginData;
       }

       public Dictionary<String, Object> getAllPersonsMessages(Decimal personId, Decimal workspaceId)
       {
           return null;
       }

       public List<Document> getMessagesForWorkspace(Decimal personId)
       {
           return null;
       }

       public Dictionary<String, Object> addChatMessage(Decimal personId, Decimal workspaceId, String userMessage)
       {
           return null;
       }

       public Dictionary<String, Object> getEvents(Decimal user)
       {
           // Return if null values are send
           if ((user <= 0) || (user <= 0))
           {
               return null;
           }

           // Dictionary to be returned and list of chats
           Dictionary<String, Object> loginData = new Dictionary<string, object>();
           // Create instance for mapped functions to DBprocedures to retrive data
           WeLearnDBmsEntities dbEntities = new WeLearnDBmsEntities();

           // Get all the user Events -> "CE" Calendar Events
           // This var is of type -> ObjectResult<fun_GetOrRetriveAllCoursesFromUser_Result> 
           var dbEventsLazyObjects = dbEntities.fun_GetOrRetriveUserDocuments((long)user, "CE");

           // Now Set them into a list
           List<fun_GetOrRetriveUserDocuments_Result> dbUserEventsList = dbEventsLazyObjects.ToList();

           // Solidify them
           if (dbUserEventsList.Capacity > 0)
               userEvents = (List<EventsSerializable>)ReshapeProperties.solidifyDatabaseObjects(dbUserEventsList);

           // Lets wrap all into a dictionary
           loginData.Add("UserEvents", userEvents); ;

           //String testSerialization = JsonConvert.SerializeObject(loginData);

           // Lets send it back  
           return loginData;
       }
    }
}
