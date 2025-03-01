package com.main.medibridge.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
public class UserController {
    
}
