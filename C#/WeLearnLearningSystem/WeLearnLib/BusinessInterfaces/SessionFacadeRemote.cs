using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;

namespace WeLearnLib.BusinessInterfaces
{
    public interface SessionFacadeRemote
    {
        void create(Session session);

        void edit(Session session);

        void remove(Session session);

        //Session find(Object id);

        List<Session> findAll();

        //List<Session> findRange(int[] range);

        int count();

    }
}
