package org.example.Services;

import org.example.Model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//for authenticating user login details
@Service
public class UserServices {
    @Autowired
    UserRepository userRepo;
public boolean login(User u)
{

    if(u.getUsername().equals("valid"))
        return true;
    else
        return false;
}
public void registerUser(User u)
{
    userRepo.register(u);
}
}
