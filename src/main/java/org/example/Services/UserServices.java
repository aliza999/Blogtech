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
public User login(User u)
{ User existingUser= userRepo.checkUser(u.getUsername(),u.getPassword());

    if(existingUser!=null)

        return existingUser;
    else
        return null;
}
public void registerUser(User u)

{
    userRepo.register(u);
}
}
