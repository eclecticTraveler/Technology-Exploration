using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;
using WeLearnControllers.BusinessFunctions;
using WeLearnLib.WeLearnObjects;

namespace AngularTestingAndDemo.ApplicationControllers
{
    class DeleteEventHandler : WeLearnHandlerInterface
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
            Dictionary<String, Object> portalData = new Dictionary<string, object>();
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
                // The docVersion should not be hardcoded I am just tired and I want to get the big Pic done
                UserEvent userEvent = new UserEvent(
                                            docUUID
                                          , "JSON"
                                          , "CE"
                                          , userEventJSONObject
                                          , 2
                                          , DateTime.UtcNow
                                          , "DeleteCalendarEvent"
                                          , (Decimal)context.Session["userId"]);

                //Send Object with all Data remotely to be stored eventually
                userDocumentsFacade = new DocumentFacade();
                userDocumentsFacade.deleteEvent(userEvent);

                // Get all the events
                portalData = userDocumentsFacade.getEvents((Decimal)context.Session["userId"]);

                // Test
                String test = JsonConvert.SerializeObject(portalData);

                // Send New Event back again
                context.Response.Write(JsonConvert.SerializeObject(portalData));



            }

            catch (Exception e)
            {
                e.ToString();
            }
        }
    }
}