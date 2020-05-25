package org.example.Services;

import org.example.Model.User;
import org.springframework.stereotype.Service;

//for authenticating user login details
@Service
public class UserServices {
public boolean login(User u)
{
    if(u.getUsername().equals("valid"))
        return true;
    else
        return false;
}

}
