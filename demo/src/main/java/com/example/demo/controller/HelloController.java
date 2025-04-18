package com.example.demo.controller;

import com.example.demo.service.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final MathService service;

    public HelloController(MathService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public void hello() {
        service.doSomeMath();
    }

    @GetMapping("/tracked")
    public String tracked() {
        return service.sayTrackedHello();
    }
}