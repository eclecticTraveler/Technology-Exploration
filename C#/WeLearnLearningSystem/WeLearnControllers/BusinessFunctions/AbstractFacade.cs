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

        public void create(T entity)
        {

            Object test = entity;
            //test.Equals(WeLearnLib.Model.User
            if (test is User)
            {
                User u = (User)test;
                String password = u.password;
                String lastName = u.lastName;
                String username = u.username;

            }

            String objType = test.ToString();
            switch (objType)
            {
                case "WeLearnLib.Model.User":
                        User u = (User)test;
                        String password = u.password;
                        String lastName = u.lastName;
                        String username = u.username;
                        break;
                case "WeLearnLib.Model.Document":
                        break;
                default:
                        break;
            }
          
    
            //    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            //Validator validator = factory.getValidator();
            //Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
            //if(constraintViolations.size() > 0){
            //    Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            //    while(iterator.hasNext()){
            //        ConstraintViolation<T> cv = iterator.next();
            //        System.err.println(cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());

            //        System.out.println(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            //    }
            //}else{
            //    getEntityManager().persist(entity);
            //}
        }

        public void edit(T entity)
        {
            //getEntityManager().merge(entity);
        }

        public void remove(T entity)
        {
            //getEntityManager().remove(getEntityManager().merge(entity));
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
