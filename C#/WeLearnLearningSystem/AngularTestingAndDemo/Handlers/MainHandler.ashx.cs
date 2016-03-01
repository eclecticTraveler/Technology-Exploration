using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.SessionState;

namespace AngularTestingAndDemo.Handlers.OldHandlers
{
    /// <summary>
    /// Summary description for MainHandler
    /// the IRequiresSessionState needs to be set in order to use Session insertion
    /// and session retrival of information for servlets that inheret from the IHttpHandler
    /// </summary>
    public class MainHandler : IHttpHandler, IRequiresSessionState
    {
        private ApplicationControllers.ApplicationController appController = new ApplicationControllers.ApplicationController();
       
        public void init()
        {
          
            appController.mapCommand("login"       , new ApplicationControllers.LoginPortalHandler());
            appController.mapCommand("loadMessages", new ApplicationControllers.ChatMessagesHandler());
            appController.mapCommand("loadUsers"   , new ApplicationControllers.ChatUsersHandler());
            appController.mapCommand("userEvents"  , new ApplicationControllers.CalendarHandler());

            

        }
        public void ProcessRequest(HttpContext context)
        {
            try
            {
                // Initialize all handlers before anything else
                init();
                //context.Response.ContentType = "text/plain";
                context.Response.ContentType = "text/html;charset=UTF-8";

                // Get the type of command
                String command = "";
                command = (String)context.Request.Params["cmd"];

                if (command == null || command == "")
                {
                    //context.Response.Output.NewLine = "Invalid";
                    command = "default";
                }

               // Add Http and the proper command triggered
                Dictionary<String, Object> dataMap = new Dictionary<string, object>();
                dataMap.Add("cmd", command);
                dataMap.Add("HttpResponse", context);
     
                // Redirect it to the right place
                appController.handleRequest(command, dataMap);
            }
            catch (Exception e)
            {
                e.ToString();
            }
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }


    }
}