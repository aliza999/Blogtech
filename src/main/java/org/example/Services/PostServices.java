package org.example.Services;

import org.example.Model.Post;
import org.example.Model.User;
import org.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServices {
@Autowired
PostRepository repo;
public List<Post>getAllPosts()
{

    return repo.getAllPosts();

}
    public Post getOnePost()
    {  return repo.getLatestPost();
        /*List <Post> list1=new ArrayList<Post>();
        Connection c=null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/technicalblog", "postgres", "9814453900");
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM posts where id=2");
            while (res.next()) {
Post pp=new Post();
pp.setTitle(res.getString("title"));
pp.setTitle(res.getString("body"));

            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
return list1; */

    }
    public  void createPost(Post u)
    {

    }
}
