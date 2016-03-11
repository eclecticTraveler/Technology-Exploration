using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnControllers.BusinessFunctions;
using WeLearnLib.Model;

namespace WeLearnControllers.TestControllers
{
    public class loginTest
    {

        public static Dictionary<String, Object> login(String username, String password)
        {
            Dictionary<String, Object> loginData = new Dictionary<string, object>();
            UserFacade userFac = new UserFacade();
            loginData = userFac.login(username, password);

            try
            {

            }
            catch (Exception e)
            {
                String t = e.ToString();
                String f = t;
            }

            //userFac.create("Hello");
            
            String Teee = "Fee";
            String test = username;
            String test2 = password;



            
            loginData.Add(test, Teee);
            return loginData;
        }
    }
}
