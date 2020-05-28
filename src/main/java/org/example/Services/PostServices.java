package org.example.Services;

import org.example.Model.Post;
import org.example.Model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServices {

    @PersistenceUnit(name="TechnicalBlog")
    private EntityManagerFactory emf;
    public List getAllPost()
    {
        List<Post> pp=new ArrayList<Post>();
       EntityManager em= emf.createEntityManager();
      TypedQuery<Post> tp= em.createQuery("SELECT P from Post P", Post.class);
        pp = tp.getResultList();
        return pp;
    }
   /* public List getOnePost()
    {List <Post> list1=new ArrayList<Post>();
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
    }*/
    public  void createPost(Post u)
    {

    }
}
