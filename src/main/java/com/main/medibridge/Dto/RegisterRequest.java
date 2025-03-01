package com.main.medibridge.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String degree;
    private String organization;
    private String email;
    private String contact;
    private String gender;
    private String password; 
    private String role;
}
