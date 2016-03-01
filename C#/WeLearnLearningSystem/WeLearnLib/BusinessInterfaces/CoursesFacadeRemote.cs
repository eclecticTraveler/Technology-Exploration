using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;

namespace WeLearnLib.BusinessInterfaces
{
    public interface CoursesFacadeRemote
    {
        void create(Course course);

        void edit(Course course);

        void remove(Course course);

        //Course find(Object id);

        List<Course> findAll();

        //List<Course> findRange(int[] range);

        int count();
    }
}
