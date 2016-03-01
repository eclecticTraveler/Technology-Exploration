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

        void create(Workspace workspace);

        void edit(Workspace workspace);

        void remove(Workspace workspace);

        //Workspace find(Object id);

        List<Workspace> findAll();

        //List<Workspace> findRange(int[] range);

        int count();
    }
}
