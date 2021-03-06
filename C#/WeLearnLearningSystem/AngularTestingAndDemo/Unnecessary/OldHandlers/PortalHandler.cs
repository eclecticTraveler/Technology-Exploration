﻿using System;
using System.Web;

namespace AngularTestingAndDemo.Handlers
{
    public class PortalHandler : IHttpHandler
    {
        /// <summary>
        /// You will need to configure this handler in the Web.config file of your 
        /// web and register it with IIS before being able to use it. For more information
        /// see the following link: http://go.microsoft.com/?linkid=8101007
        /// </summary>
        #region IHttpHandler Members

        public bool IsReusable
        {
            // Return false in case your Managed Handler cannot be reused for another request.
            // Usually this would be false in case you have some state information preserved per request.
            get { return true; }
        }

        public void ProcessRequest(HttpContext context)
        {
            //write your handler implementation here.
            context.Response.ContentType = "text/html;charset=UTF-8";
          
            
            try
            {
                String username = "";
                String password = "";

                username = context.Request.Url.Segments[1];
                password = context.Request.Url.Segments[2];

                String test = username;
                String testi = password;

                // Response back to front end
                context.Response.Write("Hello from custom handler.");
                
            }
            catch (Exception e)
            {
                e.ToString();

            }
        }

        #endregion

        

    }
}
