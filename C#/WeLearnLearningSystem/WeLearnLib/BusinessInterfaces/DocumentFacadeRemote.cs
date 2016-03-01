using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;

namespace WeLearnLib.BusinessInterfaces
{
    public interface DocumentFacadeRemote
    {
        void create(Document document);

        void edit(Document document);

        void remove(Document document);

        //Document find(Object id);

        List<Document> findAll();
    
        List<Document> getEvents(User user);

        //List<Document> findRange(int[] range);

        int count();

       Dictionary<String, Object> addDocument(Decimal personId, String contextType, String docText, String docUrl, String docType, String shortDescr);    

       List<Document> getCourseList(Decimal personId);
   
       List<Document> getFinalGrades(Decimal personId);
       
       List<String> getMessages(Decimal personId);
    
       Dictionary<String, Object> getAllPersonsMessages(Decimal personId, Decimal workspaceId);
    
       List<Document> getMessagesForWorkspace(Decimal personId);
    
       Dictionary<String, Object> addChatMessage(Decimal personId, Decimal workspaceId, String userMessage);
    
     }
}
