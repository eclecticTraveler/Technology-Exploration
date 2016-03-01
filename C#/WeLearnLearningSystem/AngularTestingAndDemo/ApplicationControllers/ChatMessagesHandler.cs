using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace AngularTestingAndDemo.ApplicationControllers
{
    public class ChatMessagesHandler : WeLearnHandlerInterface
    {
        public void systemHandler(Dictionary<String, Object> data)
        {
            try
            {

                // Retrive context from dictionary
                HttpContext context = (HttpContext)data["HttpResponse"];

                // Set type of expected string
                context.Response.ContentType = "text/html;charset=UTF-8";









                string jsonString =
                   "{ "
               + "\"chatMesseages\": [ "
               + "{ "
               + "\"Receiver\": \"Emma Goldman\", "
               + "\"Sender\": \"Noam Chomsky\", "
               + "\"Message\": \"Hey girl this is Noam Chomsky\", "
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:08:56\", "
               + "\"Id\": \"1\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Emma Goldman\", "
               + "\"Sender\": \"Noam Chomsky\", "
               + "\"Message\": \"I was wondering if you have that book I lend you\", "
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:09:56\", "
               + "\"Id\": \"2\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Emma Goldman\", "
               + "\"Sender\": \"Noam Chomsky\", "
               + "\"Message\": \"If not its ok\", "
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:10:56\", "
               + "\"Id\": \"3\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Noam Chomsky\", "
               + "\"Sender\": \"Emma Goldman\", "
               + "\"Message\": \"Which one do you need?\" ,"
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:11:02\", "
               + "\"Id\": \"4\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Emma Goldman\", "
               + "\"Sender\": \"Noam Chomsky\", "
               + "\"Message\": \"Intro to Anarchism\", "
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:11:56\", "
               + "\"Id\": \"5\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Noam Chomsky\", "
               + "\"Sender\": \"Emma Goldman\", "
               + "\"Message\": \"I think I have it!\" ,"
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:12:02\", "
               + "\"Id\": \"6\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Emma Goldman\", "
               + "\"Sender\": \"Noam Chomsky\", "
               + "\"Message\": \"Case 1 - Requirements document\", "
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:12:56\", "
               + "\"Id\": \"7\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Noam Chomsky\", "
               + "\"Sender\": \"Emma Goldman\", "
               + "\"Message\": \"Come pick it up\", "
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:13:56\", "
               + "\"Id\": \"8\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Noam Chomsky\", "
               + "\"Sender\": \"Emma Goldman\", "
               + "\"Message\": \"I'll be here all day\" ,"
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:14:56\", "
               + "\"Id\": \"9\" "
               + "}, "
               + "{ "
               + "\"Receiver\": \"Emma Goldman\", "
               + "\"Sender\": \"Noam Chomsky\", "
               + "\"Message\": \"Great Thanks!\" ,"
               + "\"Date\": \"2016-01-20\", "
               + "\"Time\": \"02:15:56\", "
               + "\"Id\": \"10\" "
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
