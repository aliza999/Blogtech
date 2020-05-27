package org.example.Controller;

import org.example.Services.PostServices;
import org.example.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.example.Model.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
public HomeController()
{
    System.out.println("*****home****");
}
    @Autowired
     PostServices services;//loose coupling
    @RequestMapping("/")
    public String getPost(Model model)
    {
 List<Post> posts=services.getAllPost();
model.addAttribute("posts",posts);
return "index";
    }

}
