package org.example.Controller;

import org.example.Model.Post;
import org.example.Services.PostServices;
import org.example.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class postController {
    @Autowired
    PostServices postService;

     @RequestMapping("posts")
    public String getUsersPosts(Model model)//CRUD operations

    {
                List<Post> listt = new ArrayList<>();
                Post pp=postService.getOnePost();
                listt.add(pp);
                 model.addAttribute("posts", listt);
                 return "posts";
    }
    @RequestMapping("/user/CreatePost")

    public String CreatePost()
    {
        return "posts/createPost";
    }
    @RequestMapping(value="posts/CreatePost",method=RequestMethod.POST)
    public String SavePost(Post postx)
    {
        postService.createPost(postx); //ui se data database me jaau via post services
        return "redirect:/posts";
    }
}

