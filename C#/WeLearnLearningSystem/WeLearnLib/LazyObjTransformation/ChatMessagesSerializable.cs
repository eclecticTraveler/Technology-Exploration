using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace WeLearnLib.LazyObjTransformation
{
    //[Serializable]
     [DataContract]
    public class ChatMessagesSerializable
    {

      
        [DataMember]
        private String message;

        public ChatMessagesSerializable(String message)
        {
            this.message = message;
        }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    }
}
