package org.example.Controller;

import org.example.Model.Post;
import org.example.Services.PostServices;
import org.example.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class postController {
    @Autowired
    PostServices postService;

     @RequestMapping("posts")
    public String getUsersPosts(Model model)//CRUD operations

    {
                List<Post> listt = new ArrayList<>();
                 listt =postService.getAllPosts();
                //listt.add(pp);
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
    {   //postx.setDate(new Date());
        postService.createPost(postx); //ui se data database me jaau via post services
        return "redirect:/posts";
    }
    @RequestMapping(value="/editPost",method=RequestMethod.GET)
    public String editPost(@RequestParam(name="postId")Integer postId,Model m)
    {
       Post p1 = postService.getPost(postId);
       m.addAttribute("p1",p1);
       return "posts/edit"; //database se data ui pe jaara hai
    }
    @RequestMapping(value="/editPost",method=RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId")Integer postIdd,Post post1)
    {
       post1.setId(postIdd);
       postService.updatePost(post1);
       return "redirect:/posts";
    }


}

