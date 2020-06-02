package org.example.repository;

import org.example.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {
    @PersistenceUnit(unitName ="technicalblog")
    EntityManagerFactory emf;
    public void register(User u)
    {       EntityManager em= emf.createEntityManager();
            EntityTransaction et =em.getTransaction();
        try
        {
            et.begin();
            em.persist(u);
            et.commit();
        }
        catch(Exception e)
        {
            et.rollback();
        }
    }
    public User checkUser(String username,String password)
    {
       EntityManager em= emf.createEntityManager();
       try {
           TypedQuery<User> tp = em.createQuery(" SELECT u FROM User u where u.username=:username AND u.password=:password", User.class); //dynamic query

           tp.setParameter("username", username);
           tp.setParameter("password", password);

           return tp.getSingleResult();//   no resultexception
       }
       catch(Exception e)
       {
           return null;
       }

    }
}
