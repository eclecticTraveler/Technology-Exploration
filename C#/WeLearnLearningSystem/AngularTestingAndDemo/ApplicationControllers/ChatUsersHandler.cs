using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using WeLearnControllers.BusinessFunctions;

namespace AngularTestingAndDemo.ApplicationControllers
{
    class ChatUsersHandler : WeLearnHandlerInterface
    {
        // Remoting
        private UserFacade userFacade;

        public void systemHandler(Dictionary<String, Object> data)
        {


            // Retrive context from dictionary
            HttpContext context = (HttpContext)data["HttpResponse"];

            // Set type of expected string
            context.Response.ContentType = "text/html;charset=UTF-8";


            // Authenticate user to see if it has firstly logged in if not then 
            // Redirect that person
            if (context.Session["userId"] ==  null       &&
                context.Session["userFistName"] ==  null &&
                context.Session["userLastName"] == null)
            {
                context.Response.Redirect("", false);
                context.ApplicationInstance.CompleteRequest();
                return; 
            }

            // Dictionary to hold data to be returned
            Dictionary<String, Object> portalData = null;

            try
            {
                // Retrive Person Id
                Decimal personId = (Decimal)context.Session["userId"];

                // Let us get all the users in the ChatRoom
                userFacade = new UserFacade();
                portalData = userFacade.getAllUsersInChatRoom(personId);

                //String test = JsonConvert.SerializeObject(portalData);

                // Send Object Serialized
                context.Response.Write(JsonConvert.SerializeObject(portalData));

            }
            catch (Exception ex)
            {
                ex.ToString();
            }

        }
    }
}
