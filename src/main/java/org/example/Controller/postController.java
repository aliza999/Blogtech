package org.example.Controller;

import org.example.Model.Catagory;
import org.example.Model.Post;
import org.example.Model.User;
import org.example.Services.PostServices;
import org.example.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    public String  SavePost(Post postx, HttpSession sn)
    {   //postx.setDate(new Date());

        User u1= (User) sn.getAttribute("loggedUser");
        postx.setUser(u1); //database me post jisne create ki hai post table me user ki id saved
        if(postx.getJavaBlog()!=null)
        {
            Catagory cjava=new Catagory();
            cjava.setCatagory(cjava.getCatagory());
postx.getCatagories().add(cjava);
        }
        if(postx.getSpringBlog()!=null)
        {
            Catagory cSpring =new Catagory();
            cSpring.setCatagory(cSpring.getCatagory());
            postx.getCatagories().add(cSpring);
        }

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
    public String editPostSubmit(@RequestParam(name="postId")Integer postIdd,Post post1,HttpSession s2)
    {
       post1.setId(postIdd);//k hum olready existing ko e edit krry to tell db

      User u1=(User)s2.getAttribute("loggedUser");
      post1.setUser(u1);
       postService.updatePost(post1);
       return "redirect:/posts";
    }
@RequestMapping(value="/deletePost",method=RequestMethod.DELETE)
    public String deletePostt(@RequestParam(name="postId")Integer postId)
{
    postService.deletePost(postId);


    return "redirect:/posts";
}

}

