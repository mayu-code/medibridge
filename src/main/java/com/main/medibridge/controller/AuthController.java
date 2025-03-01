package com.main.medibridge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.medibridge.Dto.LoginRequest;
import com.main.medibridge.Dto.RegisterRequest;
import com.main.medibridge.Dto.SuccessResponse;
import com.main.medibridge.Helper.Role;
import com.main.medibridge.JwtSecurity.CustomeUserDetail;
import com.main.medibridge.JwtSecurity.JwtProvider;
import com.main.medibridge.entities.User;
import com.main.medibridge.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5173/"})
public class AuthController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private CustomeUserDetail customerUserDetail;
    
    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody RegisterRequest request) {
        SuccessResponse response = new SuccessResponse();
        User user = new User();

        if(this.userServiceImpl.getUserByEmail(request.getEmail())!=null){
            response.setMessage("User Alredy present !");
            response.setStatus(HttpStatus.ALREADY_REPORTED);
            response.setStatusCode(208);
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(response);
        }

        user.setEmail(request.getEmail());
        user.setContact(request.getContact());
        user.setName(request.getName());
        user.setDegree(request.getDegree());
        user.setGender(request.getGender());
        user.setOrganization(request.getRole());
        user.setRole(Role.valueOf(request.getRole()));
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        this.userServiceImpl.addUser(user);

        response.setMessage("Register Successful");
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(200);

        return ResponseEntity.of(Optional.of(response));
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest request) {
        // User user = this.userServiceImpl.getUserByEmail(request.getEmail());
        // if (user == null) {
        //     SuccessResponse response = new SuccessResponse();
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        // }

        // UserDetails userDetails = this.customerUserDetail.loadUserByUsername(request.getEmail());
        // boolean isMatchPassword = new BCryptPasswordEncoder().matches(request.getPassword(), userDetails.getPassword());
        // if (!isMatchPassword) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        // }

        // Authentication authentication = authentication(request.getEmail(), request.getPassword());
        // String jwt = JwtProvider.generateJwtToken(authentication);

        // LoginResponse response = new LoginResponse();
        // response.setHttpStatus(HttpStatus.OK);
        // response.setToken(jwt);
        // response.setRole(user.getRole().toString());
        // response.setMessage("Login successful");
        // response.setStatusCode(200);

        // return ResponseEntity.ok(response);
        return null;
    }

    public Authentication authentication(String email, String password) {
        UserDetails userDetails = this.customerUserDetail.loadUserByUsername(email);
        if (userDetails == null) {
            throw new UsernameNotFoundException("Invalid credentials");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }
}
