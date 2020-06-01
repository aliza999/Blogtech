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
import java.util.Date;

@Service
public class PostServices {
    @Autowired
    PostRepository repo;

    public List<Post> getAllPosts() {

        return repo.getAllPosts();

    }

    public Post getOnePost() {
        return repo.getLatestPost();

    }

    public void createPost(Post newPost)
    {  newPost.setDate(new Date());
        repo.getOnePost(newPost);
    }

    public Post getPost(Integer pid) {
         return repo.getPost(pid);
    }
    public  void updatePost(Post p)
    {
        p.setDate(new Date());
          repo.update(p);
    }
}