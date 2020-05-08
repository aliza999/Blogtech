package org.example.Controller;
import org.example.Model.User;
import org.example.Model.post;
import org.example.Services.postServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    private postServices service;
    @RequestMapping("users/login")
    public String login()
    {
        return "users/login";
    }

    @RequestMapping(value="users/login",method= RequestMethod.POST)
    public String login(User user)

    {
     return "redirect:/posts";
    }
    @RequestMapping(value="users/logout",method=RequestMethod.POST)
    public String logout(Model m)
    {
        ArrayList<post> posts=service.getAllPost();
        m.addAttribute("posts",posts);
        return "index";
    }
}
