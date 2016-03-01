using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace AngularTestingAndDemo.ApplicationControllers
{
    class CalendarHandler : WeLearnHandlerInterface
    {
        public void systemHandler(Dictionary<String, Object> data)
        {


            // Retrive context from dictionary
            HttpContext context = (HttpContext)data["HttpResponse"];

            // Set type of expected string
            context.Response.ContentType = "text/html;charset=UTF-8";

            try
            {
                string jsonString =
             "{ "
            + "\"events\": [ "
            + "{ "
            + "\"eventId\": \"1\", "
            + "\"description\": \"Math 108: Quadratic formula asssignment\", "
            + "\"date\": \"10/26/2015\" "
            + "}, "
            + "{ "
            + "\"eventId\": \"2\", "
            + "\"description\": \"CIT 460: EUI Prototype demo\", "
            + "\"date\": \"10/26/2015\" "
            + "}, "
            + "{ "
            + "\"eventId\": \"3\", "
            + "\"description\": \"CIT 425: Dimensional Model presentation\", "
            + "\"date\": \"10/28/2015\" "
            + "}, "
            + "{ "
            + "\"eventId\": \"4\", "
            + "\"description\": \"Internship interview with USAA\", "
            + "\"date\": \"10/29/2015\" "
            + "} "
            + "]"
            + "}";
                String test = jsonString;
               
                context.Response.Write(jsonString);



            }

            catch (Exception e)
            {
                e.ToString();
            }
        }
    }
}
