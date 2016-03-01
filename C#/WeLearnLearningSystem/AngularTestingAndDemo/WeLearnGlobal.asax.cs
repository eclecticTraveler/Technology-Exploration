using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.SessionState;

namespace AngularTestingAndDemo
{
    public class WeLearnGlobal : System.Web.HttpApplication
    {
        
        protected void Application_Start(object sender, EventArgs e)
        {
            Application["UsersConnected"] = 0;
        }

        protected void Session_Start(object sender, EventArgs e)
        {
            // Ensure one therad enters and modifies it at a time
            Application.Lock();
            Application["UsersConnected"] = (Decimal)Application["UsersConnected"] + 1;
            Application.UnLock();
        }

        protected void Application_BeginRequest(object sender, EventArgs e)
        {

        }

        protected void Application_AuthenticateRequest(object sender, EventArgs e)
        {

        }

        protected void Application_Error(object sender, EventArgs e)
        {

        }

        protected void Session_End(object sender, EventArgs e)
        {
            // Ensure one therad enters and modifies it at a time
            Application.Lock();
            Application["UsersConnected"] = (Decimal)Application["UsersConnected"] - 1;
            Application.UnLock();

        }

        protected void Application_End(object sender, EventArgs e)
        {

        }
    }
}