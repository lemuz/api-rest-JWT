package com.ecommerce.loginjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AdminController {
	
	@GetMapping("")
    public String hello()
    {
        return "Welcome Admin to '/' !";
    }
	
    @GetMapping("admin")
    public String getAdmin()
    {
        return "Welcome Admin!";
    }
    
    @GetMapping("user")
    public String getTest()
    {
        return "Welcome User!";
    }
}