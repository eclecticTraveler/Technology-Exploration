using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace AngularTestingAndDemo.ApplicationControllers
{
    public interface WeLearnHandlerInterface
    {
        //Method signature
        // It does not have public because it reduntant for interfaces
        void systemHandler(Dictionary<String, Object> data);
    }
}
