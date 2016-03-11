using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using WeLearnControllers.BusinessFunctions;
using WeLearnLib.WeLearnObjects;

namespace AngularTestingAndDemo.ApplicationControllers
{
    class AddEventHandler : WeLearnHandlerInterface
    {
        // Remote
        private DocumentFacade userDocumentsFacade;
        public void systemHandler(Dictionary<String, Object> data)
        {


            // Retrive context from dictionary
            HttpContext context = (HttpContext)data["HttpResponse"];

            // Set type of expected string
            context.Response.ContentType = "text/html;charset=UTF-8";

            // Initialize Value
            String userEventJSONObject = "";
            String docUUID = "";

            // Get parameters from url
            userEventJSONObject = context.Request.Params["event"];
            docUUID = context.Request.Params["ticket"]; 

            // Send values to be evaluated
            try
            {
                // Authenticate user to see if it has firstly logged in if not then 
                // Redirect that person, also to see if event is not null as well as the uuid of new document
                if ((context.Session["userId"] == null &&
                    context.Session["userFistName"] == null &&
                    context.Session["userLastName"] == null) ||
                    (userEventJSONObject == null || userEventJSONObject == "") ||
                    (docUUID == null || docUUID == ""))
                {
                    context.Response.Redirect("", false);
                    context.ApplicationInstance.CompleteRequest();
                    return;
                }
               
                // get and set the properties to send across and insert them in database with extra property userId
                UserEvent userEvent = new UserEvent(
                                            docUUID
                                          , "JSON"
                                          , "CE"
                                          , userEventJSONObject
                                          , 1
                                          , DateTime.UtcNow
                                          , "NewUserCalendarEvent"
                                          , (Decimal)context.Session["userId"]);

                //Send Object with all Data remotely to be stored eventually
                userDocumentsFacade = new DocumentFacade();
                userDocumentsFacade.setEvent(userEvent);

                // I was thinking on hitting the DB again by executing a Store Proc that can retrive ONLY the new inserted Row 
                // But since it will go its way I can just send back the JSON string I just saved to the view without having to retrive it again 
                // From the DB, if its an error its going... I should change the interface so that it returns a success of fail and then evaluate
                // Whether to send back a null for failure or the event back, REMINDER: I'll do it after I can update and delete events
                 //String test = JsonConvert.SerializeObject(portalData);

                // Send New Event back again
                context.Response.Write(userEventJSONObject);
                


            }

            catch (Exception e)
            {
                e.ToString();
            }
        }
    }
}