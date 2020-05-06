package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.example.Model.post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getPost(Model model)
    {
        ArrayList<post>post=new ArrayList<>();
        post post1=new post();
        post1.setTitle("post1");
        post1.setBody("body1");
        post1.setDate(new Date());
        post post2=new post();
        post2.setTitle("post2");
        post2.setBody("body2");
        post2.setDate(new Date());

        post post3=new post();
        post3.setTitle("post3");
        post3.setBody("body3");
        post3.setDate(new Date());

post.add(post1);
post.add(post2);
post.add(post3);
model.addAttribute("posts",post);
        return "index";
    }

}
