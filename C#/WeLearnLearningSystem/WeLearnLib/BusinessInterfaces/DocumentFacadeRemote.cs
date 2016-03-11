using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;
using WeLearnLib.WeLearnObjects;

namespace WeLearnLib.BusinessInterfaces
{
    public interface DocumentFacadeRemote
    {
        void create(Document document, Decimal userId);

        void edit(Document document, Decimal userLogged);

        void remove(Document document, Decimal userLogged);

        //Document find(Object id);

        List<Document> findAll();

        Dictionary<String, Object> getChatConversation(Decimal personLoggedIn, Decimal personChattingWith);

        //List<Document> findRange(int[] range);

        int count();

       Dictionary<String, Object> addDocument(Decimal personId, String contextType, String docText, String docUrl, String docType, String shortDescr);    

       List<Document> getCourseList(Decimal personId);
   
       List<Document> getFinalGrades(Decimal personId);
       
       //List<String> getChatConversation(Decimal personId);
       void setEvent(UserEvent userEvent);

       void updateEvent(UserEvent userEvent);

       void deleteEvent(UserEvent userEvent);
    
       Dictionary<String, Object> getAllPersonsMessages(Decimal personId, Decimal workspaceId);
    
       List<Document> getMessagesForWorkspace(Decimal personId);
    
       Dictionary<String, Object> addChatMessage(Decimal personId, Decimal workspaceId, String userMessage);

       Dictionary<String, Object> getEvents(Decimal user);

        
     }
}
