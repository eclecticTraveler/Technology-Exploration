using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AngularTestingAndDemo.Handlers
{
    /// <summary>
    /// \]=
    /// "-09RUYHRJBN VCT
    /// Summary description foraz MainPortalHandler
    /// </summary>
    public class MainPortalHandler : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            //context.Response.ContentType = "text/plain";
            context.Response.ContentType = "text/html;charset=UTF-8";

            // Initialize Values
            String username = "";
            String password = "";
            // Get parameters from url
            username = context.Request.Params["username"];
            password = context.Request.Params["password"];

            String test = username;
            String testi = password;





            // Response back
            context.Response.Write("Hello World");
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