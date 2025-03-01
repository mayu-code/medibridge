package com.main.medibridge.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.UserRepo;
import com.main.medibridge.entities.User;
import com.main.medibridge.services.ServiceInterface.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User addUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User getUserById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }
    
}
