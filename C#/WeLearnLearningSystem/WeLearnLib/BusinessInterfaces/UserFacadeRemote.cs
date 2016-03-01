using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;
using WeLearnLib.LazyObjTransformation;

namespace WeLearnLib.BusinessInterfaces
{
    public interface UserFacadeRemote
    {
        void create(User user);

        void edit(User user);

        void remove(User user);

        //User find(Object id);

        List<User> findAll();

        //List<User> findRange(int[] range);

        int count();

        Dictionary<String, Object> login(String username, String password);

        List<User> getAllUsers();

        List<UserSerializable> getPeople(List<User> personsLazy, Decimal personId);

        List<UserSerializable> getUsers(List<User> personsLazy, Decimal personId);
    

    }
}
