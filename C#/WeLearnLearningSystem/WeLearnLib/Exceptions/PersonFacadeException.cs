using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WeLearnLib.Exceptions
{
    class PersonFacadeException : Exception
    {
        public PersonFacadeException()
        {
        }

        public PersonFacadeException(String message)
            : base(message)
        {
            
        }

        public PersonFacadeException(String message, Exception cause)
            : base(message, cause)
        {
            
        }

        //public PersonFacadeException(Exception cause)
        //    : base(cause)
        //{
            
        //}

        //public PersonFacadeException(String message, Exception cause, bool enableSuppression, bool writableStackTrace) 
        //    :  base(message, cause, enableSuppression, writableStackTrace)
        //{
           
        //}
    
    }
}
