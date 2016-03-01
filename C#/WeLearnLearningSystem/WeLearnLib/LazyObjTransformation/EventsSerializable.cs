using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace WeLearnLib.LazyObjTransformation
{
    //[Serializable()]
    [DataContract]
    public class EventsSerializable
    {
        [DataMember]
        private String docText;
        [DataMember]
        private String docDesc;
        [DataMember]
        private String docDate;

        public EventsSerializable(String docText, String docDesc, String docDate)
        {
            this.docText = docText;
            this.docDesc = docDesc;
            this.docDate = docDate;
        }

        public String getDocText()
        {
            return docText;
        }

        public void setDocText(String docText)
        {
            this.docText = docText;
        }
        public String getDocDesc()
        {
            return docDesc;
        }

        public void setDocDesc(String docDesc)
        {
            this.docDesc = docDesc;
        }
        public String getDocDate()
        {
            return docDate;
        }

        public void setDocDate(String docDate)
        {
            this.docDate = docDate;
        }
        
    }
}
