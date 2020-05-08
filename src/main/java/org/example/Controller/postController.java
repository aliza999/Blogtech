package org.example.Controller;

import org.example.Model.post;
import org.example.Services.postServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class postController {
    @Autowired
    postServices postService;

    @RequestMapping("posts")
    public String getUsersPosts(Model model)//CRUD operations

    {
        ArrayList<post>listt=postService.getOnePost();
        model.addAttribute("posts",listt);
         return "posts";
    }
}
