package org.example.repository;

import org.example.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

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
}
