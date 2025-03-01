package com.main.medibridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.medibridge.entities.User;


public interface UserRepo extends JpaRepository<User,Long>{
    User findByEmail(String email);
}
