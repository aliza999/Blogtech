package org.example.Controller;

import org.example.Services.postServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.Model.post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
public HomeController()
{
    System.out.println("*****home****");
}

    @Autowired
    private postServices services; //loose coupling

    @RequestMapping("/")
    public String getPost(Model model)
    {
ArrayList<post>posts=services.getAllPost();
model.addAttribute("posts",posts);
return "index";
    }

}
