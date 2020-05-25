package org.example.Controller;

import org.example.Model.UserPost;
import org.example.Model.post;
import org.example.Services.postServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class postController {
    @Autowired
    postServices postService;

    @RequestMapping("posts")
    public String getUsersPosts(Model model)//CRUD operations

    {
        ArrayList<post> listt = postService.getOnePost();
        model.addAttribute("posts", listt);
        return "posts";
    }
    @RequestMapping("/user/CreatePost")

    public String CreatePost()
    {
        return "posts/createPost";
    }
    @RequestMapping(value="posts/CreatePost",method=RequestMethod.POST)
    public String SavePost(post postx)
    {
        postService.createPost(postx); //ui se data database me jaau via post services
        return "redirect:/posts";
    }
}