package org.example.Controller;
import org.example.Model.User;
import org.example.Model.Post;
import org.example.Services.PostServices;
import org.example.Services.UserServices;
import org.example.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PostServices service;
    @Autowired
    private UserServices servicesOfUser;
    @RequestMapping("users/login")
    public String login()
    {
        return "users/login";
    }
    @RequestMapping(value="users/login",method= RequestMethod.POST)
    public String login(User user)
    {
        if(servicesOfUser.login(user))
        return "redirect:/posts";
    else
        return "users/login";
    }
    @RequestMapping(value="users/logout",method=RequestMethod.POST)
    public String logout(Model m)
    {
        List<Post> posts=service.getAllPosts();
        m.addAttribute("posts",posts);
        return "index";
    }
    @RequestMapping("users/register")
    public String getRegister()
    {
        return "users/registerr";
    }
    @RequestMapping(value="users/register",method=RequestMethod.POST)
    public String getRegisterUser(User user)
    {
        return "users/login";
    }
   /*@RequestMapping("/user/CreatePost")
   @ResponseBody
public String getCreatePostMethod()
    {
        return "under construction";
    } */
}
