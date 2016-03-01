using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.BusinessInterfaces;
using WeLearnLib.Model;

namespace WeLearnControllers.BusinessFunctions
{
   public class SessionFacade : AbstractFacade<Session>, SessionFacadeRemote
    {
        public SessionFacade() 
            : base(typeof(Session)){

         }

       

    }
}
