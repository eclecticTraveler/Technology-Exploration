using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace WeLearnLib.WeLearnObjects
{
    [DataContract]
   public class UserEvent
    {
        [DataMember]
        private String docUUID;
        [DataMember]
        private String docType;
        [DataMember]
        private String docContext;
        [DataMember]
        private String docText;
        [DataMember]
        private Decimal docVersion;
        [DataMember]
        private DateTime docDate;
        [DataMember]
        private String docDesc;
        [DataMember]
        private Decimal userLogged;


        public UserEvent(String docUUID, String docType, String docContext, String docText, Decimal docVersion, DateTime docDate, String docDesc, Decimal userLogged)
        {
            this.docUUID = docUUID;
            this.docType = docType;
            this.docContext = docContext;
            this.docText = docText;
            this.docVersion = docVersion;
            this.docDate = docDate;
            this.docDesc = docDesc;
            this.userLogged = userLogged;
        }


        public String DocUUID
        {
            get { return docUUID; }
            set { docUUID = value; }
        }


        public String DocType
        {
            get { return docType; }
            set { docType = value; }
        }


        public String DocContext
        {
            get { return docContext; }
            set { docContext = value; }
        }


        public String DocText
        {
            get { return docText; }
            set { docText = value; }
        }

        public Decimal DocVersion
        {
            get { return docVersion; }
            set { docVersion = value; }
        }

        public DateTime DocDate
        {
            get { return docDate; }
            set { docDate = value; }
        }


        public String DocDesc
        {
            get { return docDesc; }
            set { docDesc = value; }
        }

        public Decimal UserLogged
        {
            get { return userLogged; }
            set { userLogged = value; }
        }
    }
}
