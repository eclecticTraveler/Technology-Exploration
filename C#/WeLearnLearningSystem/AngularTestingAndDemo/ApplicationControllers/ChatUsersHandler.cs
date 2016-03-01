using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace AngularTestingAndDemo.ApplicationControllers
{
    class ChatUsersHandler : WeLearnHandlerInterface
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
                    + "\"people\": [ "
                    + "{ "
                    + "\"personId\": \"1\", "
                    + "\"firstName\": \"Noam\", "
                    + "\"lastName\": \"Chomsky\", "
                    + "\"picture\": \"https://goo.gl/iF6m7A\" "
                    + "}, "
                    + "{ "
                    + "\"personId\": \"2\", "
                    + "\"firstName\": \"Michael\", "
                    + "\"lastName\": \"Foucault\", "
                    + "\"picture\": \"https://goo.gl/11ZVA2\" "
                    + "}, "
                    + "{ "
                    + "\"personId\": \"3\", "
                    + "\"firstName\": \"Martin\", "
                    + "\"lastName\": \"Heidegger\", "
                    + "\"picture\": \"http://goo.gl/8RaJgz\" "
                    + "}, "
                    + "{ "
                    + "\"personId\": \"4\", "
                    + "\"firstName\": \"Emma\", "
                    + "\"lastName\": \"Goldman\", "
                    + "\"picture\": \"https://goo.gl/hQqw1y\" "
                    + "} "
                    + "] "
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
