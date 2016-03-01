using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace AngularTestingAndDemo.ApplicationControllers
{
    public class ApplicationController
    {
        // Private Instance Variable Which key is a String and Value is a Handler Interface
        private Dictionary<String, WeLearnHandlerInterface> handlerMap = new Dictionary<String, WeLearnHandlerInterface>();

        // Method which receives a String and a HashMap with a String and a Object
        public void handleRequest(String command, Dictionary<String, Object> data)
        {
            try
            {
                // Since Handler is an interface you cannot instantiate it
                // Rather you store the handlerMap HashMap's Key of type String
                // to the Handler
                WeLearnHandlerInterface aCommandHandler = handlerMap[command];
                // If whatever was returned is not null, because its possible
                // Then get Handler's method which parameter is a Dictionary
                // and pass the object to it.
                if (aCommandHandler != null)
                {
                    aCommandHandler.systemHandler(data);
                }
            }
            catch (Exception e)
            {
                e.ToString();
            }
        }


        public void mapCommand(String aCommand, WeLearnHandlerInterface acHandler)
        {

            // Add to the handler HashMap the string and the Handler
            handlerMap.Add(aCommand, acHandler);
        }
    }
}
