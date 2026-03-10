package com.clasejava.demo_jpa.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    
    @GetMapping("/ping")
    public String ping() {
        return "hola mundo";
    }
}
