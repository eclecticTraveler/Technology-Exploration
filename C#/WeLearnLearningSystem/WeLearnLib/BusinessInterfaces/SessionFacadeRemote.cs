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
        void create(Session session, Decimal userLogged);

        void edit(Session session, Decimal userLogged);

        void remove(Session session, Decimal userLogged);

        //Session find(Object id);

        List<Session> findAll();

        //List<Session> findRange(int[] range);

        int count();

    }
}
