package com.example.spring.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Login {
	
    private String id;

    private String username;

    private String password;
    
    private String email;
    
    private BigDecimal money;

    private String date;
}