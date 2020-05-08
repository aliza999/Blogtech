package org.example.Services;

import org.example.Model.post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;

@Service
public class postServices {

    public postServices()
    {
        System.out.println("******services*****");
    }
    public ArrayList<post> getAllPost()
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

        return post;
    }
    public ArrayList<post>getOnePost()
    {
        ArrayList<post>list1=new ArrayList<>();
        post post1=new post();
        post1.setTitle("coding");
        post1.setBody(" coding is an essential skill in 2020 ");
        post1.setDate(new Date());
        list1.add(post1);
        return list1;

    }
}
