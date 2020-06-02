  package org.example.repository;

import org.example.Model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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

    public Post getLatestPost() {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, 2);
    }

    public Post getOnePost(Post newPost) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(newPost);  //after persist() the @GeneratedValue call hougi and id no bind hoga
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
        return newPost;
    }

    public Post getPost(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, id);
    }

    public void update(Post updated) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            em.merge(updated);  // we are updating the values
            et.commit();
        }
        catch (Exception e)
        {
            et.rollback();
        }
    }
    public void deletePost(Integer id)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            Post postt= em.find(Post.class,id);
            em.remove(postt);  // we are updating the values
            et.commit();
        }
        catch (Exception e)
        {
            et.rollback();
        }
    }
}