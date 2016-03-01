using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.BusinessInterfaces;
using WeLearnLib.Model;

namespace WeLearnControllers.BusinessFunctions
{
   public class DocumentFacade : AbstractFacade<Document>, DocumentFacadeRemote
    {
 
        public DocumentFacade() 
            : base(typeof(Document)){

        }

        public Dictionary<String, Object> addDocument(Decimal personId, String contextType, String docText, String docUrl, String docType, String shortDescr)
        {
            return null;
        }

       public List<Document> getCourseList(Decimal personId)
        {
            return null;
        }

       public List<Document> getFinalGrades(Decimal personId)
       {
           return null;
       }

       public List<String> getMessages(Decimal personId)
       {
           return null;
       }

       public Dictionary<String, Object> getAllPersonsMessages(Decimal personId, Decimal workspaceId)
       {
           return null;
       }

       public List<Document> getMessagesForWorkspace(Decimal personId)
       {
           return null;
       }

       public Dictionary<String, Object> addChatMessage(Decimal personId, Decimal workspaceId, String userMessage)
       {
           return null;
       }

       public List<Document> getEvents(User user)
       {
           return null;
       }
    }
}
