using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using WeLearnLib.Model;
using WeLearnControllers.BusinessFunctions;
using System.Web.Script.Serialization;
using WeLearnLib.LazyObjTransformation;
using Newtonsoft.Json;
//using WeLearnControllers;


namespace AngularTestingAndDemo.ApplicationControllers
{
    public class LoginPortalHandler : WeLearnHandlerInterface
    {
        // Remoting
        private UserFacade userFacade;
        private UserSerializable userLogged;
 
        public void systemHandler(Dictionary<String, Object> data)
        {
    
            // Retrive context from dictionary
            HttpContext context = (HttpContext)data["HttpResponse"];

            // Set type of expected string
            context.Response.ContentType = "text/html;charset=UTF-8";

            // Initialize Values
            String username = "";
            String password = "";

            // Get parameters from url
            username = context.Request.Params["username"];
            password = context.Request.Params["password"];

            Dictionary<String, Object> portalData = null;
            // Send values to be evaluated
                try
                {

                    // Evaluate that the username and password inserted by the user are not null or empty
                    // before sending it remotely accross the web to see if it exists
                    if (username == "undefined"  ||  password == "undefined" ||
                        username == null         ||  password == null        ||
                        username == ""           ||  password == "")
                    {
                        // So if the username field or password is missing when they first log in we will redirect and terminate 
                        // the execution of the code until the fields are completed properly
                        context.Response.Redirect("index.html", true);
                    }

                    // Communicate to remote function to get all info about person trying to log-in
                    // Outside of classed is mapped to this -> private UserFacadeRemote personFacade;
                    // In java the framework will handle the instantiation and removal of objects but
                    // since I don't how to set it up in asp.net I had to do it this way

                    // Instance of userFacade
                    UserFacade userFacade = new UserFacade();
                    // Execute Remote function call to evaluate the username and password
                    portalData = userFacade.login(username, password);

                    // Evaluate if there is a user with that usename and password
                    if (portalData == null)
                    {
                        // Redirect with error
                        context.Response.Redirect("index.html", true);
                    }

                    // Up to this point user should exist so lets Store User Locally
                    // By retriving the user profile 
                    if (portalData.ContainsKey("UserProfile"))
                    {
                        userLogged = (UserSerializable)portalData["UserProfile"];
                    }
                    // and saving authentication token on session
                    context.Session["userId"] = userLogged.getPersonId();
                    context.Session["userFistName"] = userLogged.getFirstName();
                    context.Session["userLastName"] = userLogged.getLastName();

                    // Return Serialized object to Http Request back in AngularJS
                    JavaScriptSerializer js = new JavaScriptSerializer();
                    String testJSSerializer = js.Serialize(portalData);
                    String testSerialization = JsonConvert.SerializeObject(portalData);

                    // Send Object Serialized
                    context.Response.Write(JsonConvert.SerializeObject(portalData));

                  





                }
                catch (Exception ex)
                {
                    String debug = ex.ToString();
                    String de = debug;
                    
                }
        }
    }
}
