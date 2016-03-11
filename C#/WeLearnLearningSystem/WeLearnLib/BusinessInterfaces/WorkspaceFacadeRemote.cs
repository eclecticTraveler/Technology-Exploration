using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;

namespace WeLearnLib.BusinessInterfaces
{
    public interface WorkspaceFacadeRemote
    {

        void create(Workspace workspace, Decimal userLogged);

        void edit(Workspace workspace, Decimal userLogged);

        void remove(Workspace workspace, Decimal userLogged);

        //Workspace find(Object id);

        List<Workspace> findAll();

        //List<Workspace> findRange(int[] range);

        int count();
    }
}
