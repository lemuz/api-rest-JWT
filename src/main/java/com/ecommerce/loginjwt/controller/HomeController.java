package com.ecommerce.loginjwt.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping("/")
    public String getUser()
    {
        return "Welcome User or Admin!";
    }
}
