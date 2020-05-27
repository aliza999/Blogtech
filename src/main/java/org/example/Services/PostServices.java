package org.example.Services;

import org.example.Model.Post;
import org.example.Model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServices {

    @PersistenceUnit(unitName="TechnicalBlog")
    private EntityManagerFactory emf;
    public List getAllPost()
    {
        List<Post> p=new ArrayList<>();
       EntityManager em= emf.createEntityManager();
      TypedQuery<Post>tp= em.createQuery("SELECT p from Post p",Post.class);
        List<Post> rs = tp.getResultList();
        return rs;
    }
    public List getOnePost()
    {List <Post> list1=new ArrayList<>();
        Connection c=null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/TechnicalBlog", "postgres", "9814453900");
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM post where id=2");
            while (res.next()) {
Post pp=new Post();
pp.setTitle(res.getString("title"));
pp.setTitle(res.getString("body"));

            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
return list1;
    }
    public  void createPost(Post u)
    {

    }
}
