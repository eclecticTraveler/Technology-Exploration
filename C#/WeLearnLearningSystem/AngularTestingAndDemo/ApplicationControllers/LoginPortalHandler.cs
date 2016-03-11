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
using System.Runtime.Remoting.Contexts;
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
                    // Double check just in the very remote case the front end did not handle well the input for these fields
                    // before sending it remotely accross the web to see if it exists
                    if (username == "undefined"  ||  password == "undefined" ||
                        username == null         ||  password == null        ||
                        username == ""           ||  password == "")
                    {
                        // So if the username field or password is missing when they first log in we will redirect and terminate 
                        // the execution of the code until the fields are completed properly
                        // Since I am using the $locationProvider on the front end I don't need to specify the root since it will handle
                        // all for me otherwise when it makes a 404 no found it will return the whole index html page 
                        context.Response.Redirect("", false);
                        context.ApplicationInstance.CompleteRequest();
                        return;                   
                       
                    }

                    // Communicate to remote function to get all info about person trying to log-in
                    // Outside of classed is mapped to this -> private UserFacadeRemote personFacade;
                    // In java the framework will handle the instantiation and removal of objects but
                    // since I don't how to set it up in asp.net I had to do it this way

                    // Instance of userFacade
                    userFacade = new UserFacade();
                    // Execute Remote function call to evaluate the username and password
                    portalData = userFacade.login(username, password);

                    // Evaluate if there is a user with that usename and password
                    if (portalData == null)
                    {
                        // Redirect with error, tipically its documented to use true
                        // for the second parameter but that causes to through an exceptio
                        // which is aborting thread which does the trick but its definetely 
                        // poor login so I use false which does the redirect but won't terminate the execution of the code
                        // the following line will terminate the request and I use return to not allow any further code to be executed
                        // Since I am using the $locationProvider on the front end I don't need to specify the root since it will handle
                        // all for me otherwise when it makes a 404 no found it will return the whole index html page 
                        context.Response.Redirect("", false);
                        context.ApplicationInstance.CompleteRequest();
                        return;
                    }

                    // Up to this point user should exist so lets Store User Locally
                    // By retriving the user profile 
                    if (portalData.ContainsKey("UserProfile")){
                        userLogged = (UserSerializable)portalData["UserProfile"];
                    }
                    else {
                        // Redirect with error
                        context.Response.Redirect("", false);
                        context.ApplicationInstance.CompleteRequest();
                        return; 
                    }
                       
                    // and saving authentication token on session
                    context.Session["userId"] = userLogged.getPersonId();
                    context.Session["userFistName"] = userLogged.getFirstName();
                    context.Session["userLastName"] = userLogged.getLastName();

                    // Return Serialized object to Http Request back in AngularJS
                    //JavaScriptSerializer js = new JavaScriptSerializer();
                    //String testJSSerializer = js.Serialize(portalData);
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
