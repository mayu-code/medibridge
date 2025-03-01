package com.main.medibridge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.medibridge.Helper.Role;
import com.main.medibridge.entities.User;


public interface UserRepo extends JpaRepository<User,Long>{
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> getAllPathologists(@Param("role") Role role);

}
