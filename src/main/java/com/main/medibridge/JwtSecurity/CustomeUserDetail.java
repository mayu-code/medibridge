package com.main.medibridge.JwtSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.UserRepo;
import com.main.medibridge.entities.User;

@Service
public class CustomeUserDetail implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(username);
        if (user == null) {
            throw new BadCredentialsException("User Not Found");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .authorities(user.getAuthorities())
                .build();
    }
}
