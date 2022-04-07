package com.th.ask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class TestController {
    @GetMapping("/test")
    @RolesAllowed("user")
    public String test() {
        return "Hello ASK!";
    }

    @GetMapping("/test-admin")
    @RolesAllowed("admin")
    public String testAdmin() {
        return "Hello ASK admin!";
    }
}
