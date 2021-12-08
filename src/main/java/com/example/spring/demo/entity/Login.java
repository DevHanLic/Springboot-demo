package com.example.spring.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Login {
	
    private String id;

    private String username;

    private String password;
    
    private String email;
    
    private BigDecimal money;

    private String date;

    private List<Login> loginList;
}