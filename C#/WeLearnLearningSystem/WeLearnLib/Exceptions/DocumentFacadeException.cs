using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WeLearnLib.Exceptions
{
    class DocumentFacadeException : Exception
    {
            public DocumentFacadeException()
            {
            }

            public DocumentFacadeException(String message) 
            : base(message)
            {
        
            }

            public DocumentFacadeException(String message, Exception cause)
            :base(message, cause)
            {
                
            }

            //public DocumentFacadeException(Exception cause) 
            //    : base(cause)
            //{
                
            //}

            //public DocumentFacadeException(String message, Exception cause, bool enableSuppression, bool writableStackTrace) 
            //    :base(message, cause, enableSuppression, writableStackTrace)
            //{
                
            //}
    }
}
