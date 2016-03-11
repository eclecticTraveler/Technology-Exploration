using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using WeLearnControllers.BusinessFunctions;
using WeLearnLib.LazyObjTransformation;

namespace AngularTestingAndDemo.ApplicationControllers
{
    public class ChatMessagesHandler : WeLearnHandlerInterface
    {
        // Remote
        private DocumentFacade userDocumentsFacade;
        private List<ChatMessagesSerializable> chatConversation;
        public void systemHandler(Dictionary<String, Object> data)
        {
            try
            {

                // Retrive context from dictionary
                HttpContext context = (HttpContext)data["HttpResponse"];

                // Set type of expected string
                context.Response.ContentType = "text/html;charset=UTF-8";

                // Authenticate user to see if it has firstly logged in if not then 
                // Redirect that person
                if (context.Session["userId"] == null &&
                    context.Session["userFistName"] == null &&
                    context.Session["userLastName"] == null)
                {
                    context.Response.Redirect("", false);
                    context.ApplicationInstance.CompleteRequest();
                    return;
                }

                // Get person that user wish to talk with from URL
                Decimal personToTalkWith = Convert.ToDecimal(context.Request.Params["to"]);

                // Dictionary to hold data to be returned
                Dictionary<String, Object> portalData = null;

                    // Retrive Person Id
                    Decimal personLogged = (Decimal)context.Session["userId"];

                    // Let us get all the users in the ChatRoom
                    userDocumentsFacade = new DocumentFacade();
                    portalData = userDocumentsFacade.getChatConversation(personLogged, personToTalkWith);

                    // Make sure PortalData is not null if its then return
                    if (portalData == null){                    
                        context.ApplicationInstance.CompleteRequest();
                        return;
                    }

                    
                    if (portalData.ContainsKey("chatMessages")){
                        chatConversation = (List<ChatMessagesSerializable>)portalData["chatMessages"];
                    } else {
                        // Redirect with error
                        context.ApplicationInstance.CompleteRequest();
                        return; 
                    }

                    String test = JsonConvert.SerializeObject(portalData);

                    // Send Object Serialized
                    context.Response.Write(JsonConvert.SerializeObject(portalData));


                   
            }
            catch (Exception e)
            {
                e.ToString();
            }



        }
    }
}
