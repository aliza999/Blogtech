package org.example.Services;

import org.example.Model.post;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class postServices
{
    @PersistenceUnit(unitName = "TechnicalBlog")
      private EntityManagerFactory emf;

    public postServices()
    {
        System.out.println("******services*****");
    }
    public List<post> getAllPost() {


        //ArrayList<post>postlist=new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<post> tp = em.createQuery("SELECT p from post p", post.class);
        List<post> resultListt = tp.getResultList();
        return resultListt;

    }


        Connection connection=null;
       // post post1=new post();
        //post1.setTitle("post1");
        //post1.setBody("body1");
        //post1.setDate(new Date());
        //post post2=new post();
        //post2.setTitle("post2");
        //post2.setBody("body2");
        //post2.setDate(new Date());

        //post post3=new post();
        //post3.setTitle("post3");
        //post3.setBody("body3");
        //post3.setDate(new Date());

        //post.add(post1);
        //post.add(post2);
        //post.add(post3);

        //return post;
        //try {
          //  Class.forName("org.postgresql.Driver");
           // connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TechnicalBlog","postgres","9814453900");
            //Statement statement= connection.createStatement();
           //ResultSet resultset= statement.executeQuery("SELECT * FROM post");
           //while(resultset.next())
           //{
             //  post postt=new post();
               //postt.setTitle(resultset.getString("title"));
               //postt.setBody(resultset.getString("body"));
               //postlist.add(postt);
           //}
        //}
        //catch (ClassNotFoundException | SQLException e) {
          //  e.printStackTrace();
        //}
        //finally
        //{
          //  try {
            //    connection.close();
            //} catch (SQLException throwables) {
               // throwables.printStackTrace();
            //}
        //}
 //return  postlist;


   public ArrayList<post>getOnePost()
   { ArrayList<post>list1=new ArrayList<>();
        post post1=new post();
        post1.setTitle("coding");
        post1.setBody(" coding is an essential skill in 2020 ");
        post1.setDate(new Date());
        list1.add(post1);
Connection c=null;
     try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TechnicalBlog", "postgres", "9814453900");
         Statement s = c.createStatement();
         ResultSet rs = s.executeQuery("SELECT * FROM post where id=2");
         while (rs.next()) {
             post p = new post();
             p.setTitle(rs.getString("title"));
             p.setBody(rs.getString("body"));

             list1.add(p);
         }
     }

        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
           try {
               c.close();
            } catch (SQLException throwables) {
               throwables.printStackTrace();
            }

        }
        return list1;

    }

    public void createPost(post newpost) //data save krrry ui se
    {

    }
}
