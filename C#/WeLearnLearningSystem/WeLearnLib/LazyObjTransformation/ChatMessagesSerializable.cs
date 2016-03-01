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
        private String from;
        [DataMember]
        private String subject;
        [DataMember]
        private String timeSent;
        [DataMember]
        private String message;

        public ChatMessagesSerializable(String from, String subject, String timeSent, String message)
        {
            this.from = from;
            this.subject = subject;
            this.timeSent = timeSent;
            this.message = message;
        }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    }
}
