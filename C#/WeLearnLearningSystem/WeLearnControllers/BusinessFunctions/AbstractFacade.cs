using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeLearnLib.Model;

namespace WeLearnControllers.BusinessFunctions
{
    public abstract class AbstractFacade<T>
    {
        //private Class<T> entityclass;
        private Object entityClass;




        public AbstractFacade(Object entityClass)
        {
            this.entityClass = entityClass;
        }

    //    protected abstract EntityManager getEntityManager();

        public void create(T entity, Decimal userId)
        {
            if (userId <= 0)
            {
                return;
            }
            Object modelObject = entity;
            //test.Equals(WeLearnLib.Model.User
            if (modelObject is Document)
            {
                // Cast it to make sure is a Doc
                Document d = (Document)modelObject;
                //Create instance for Entities and pass info to procedure to save on database
                WeLearnDBmsEntities dbEntities = new WeLearnDBmsEntities();
                try
                {
                    dbEntities.fun_InsertUserEvent(d.docUUID, d.docType, d.docContext, d.docText, (long)d.docVersion, d.docDate, d.docDesc, (long)userId);
                    // GO back to see if we can land on the next line to be exec from the method that called this method, otherwise is going to retun all the way
                    // Without executing anything else
                    //return;

                    // Technically if it goes wrong its going to return failure and its going to send the view that status of the failure this logging the person
                    // out, this is just in the mean time that I make the storce proce return a confirmation of success on the transaction
                }
                catch (Exception ex)
                {
                    ex.ToString();
                }

            }
            else if (modelObject is User)
            {
                User u = (User)modelObject;
                String password = u.password;
                String lastName = u.lastName;
                String username = u.username;

            }

        }

        public void edit(T entity, Decimal userId)
        {
            if (userId <= 0)
            {
                return;
            }
            Object modelObject = entity;
            //test.Equals(WeLearnLib.Model.User
            if (modelObject is Document)
            {
                // Cast it to make sure is a Doc
                Document d = (Document)modelObject;
                //Create instance for Entities and pass info to procedure to save on database
                WeLearnDBmsEntities dbEntities = new WeLearnDBmsEntities();
                try
                {
                    // Update the event
                    dbEntities.fun_UpdateUserEvent(d.docUUID, d.docText, (long)d.docVersion, d.docDate, d.docDesc);
                }
                catch (Exception ex)
                {
                    ex.ToString();
                }

            }
            else if (modelObject is User)
            {
                User u = (User)modelObject;
                String password = u.password;
                String lastName = u.lastName;
                String username = u.username;

            }
          
        }

        public void remove(T entity, Decimal userId)
        {
            if (userId <= 0)
            {
                return;
            }
            Object modelObject = entity;
            //test.Equals(WeLearnLib.Model.User
            if (modelObject is Document)
            {
                // Cast it to make sure is a Doc
                Document d = (Document)modelObject;
                //Create instance for Entities and pass info to procedure to save on database
                WeLearnDBmsEntities dbEntities = new WeLearnDBmsEntities();
                try
                {
                    //dbEntities.fun_InsertUserEvent(d.docUUID, d.docType, d.docContext, d.docText, (long)d.docVersion, d.docDate, d.docDesc, (long)userId);
                    dbEntities.spDeleteUserEvent(d.docUUID);
                    // GO back to see if we can land on the next line to be exec from the method that called this method, otherwise is going to retun all the way
                    // Without executing anything else
                    //return;

                    // Technically if it goes wrong its going to return failure and its going to send the view that status of the failure this logging the person
                    // out, this is just in the mean time that I make the storce proce return a confirmation of success on the transaction
                }
                catch (Exception ex)
                {
                    ex.ToString();
                }

            }
            else if (modelObject is User)
            {
                User u = (User)modelObject;
                String password = u.password;
                String lastName = u.lastName;
                String username = u.username;

            }
        }

        //public T find(Object id)
        //{
        //    //return getEntityManager().find(entityClass, id);
        //    String f = "";
        //    return f;
        //}

        public List<T> findAll()
        {
            //javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            //cq.select(cq.from(entityClass));
            //return getEntityManager().createQuery(cq).getResultList();
            return null;
        }

        //public List<T> findRange(int[] range)
        //{
        //    //javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //    //cq.select(cq.from(entityClass));
        //    //javax.persistence.Query q = getEntityManager().createQuery(cq);
        //    //q.setMaxResults(range[1] - range[0] + 1);
        //    //q.setFirstResult(range[0]);
        //    //return q.getResultList();

        //    return null;
        //}

        public int count()
        {
            //javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            //javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
            //cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            //javax.persistence.Query q = getEntityManager().createQuery(cq);
            //return ((Long)q.getSingleResult()).intValue();
            return 5;

        }
    }
}
