package org.example.repository;

import org.example.Model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class PostRepository {
    @PersistenceUnit(unitName = "technicalblog")
    private EntityManagerFactory emf;
    public List<Post> getAllPosts() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        return query.getResultList();
    }
    public Post getLatestPost()
    {
       EntityManager em= emf.createEntityManager();
       return em.find(Post.class,2);
    }
}
