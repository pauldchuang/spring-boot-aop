package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return service.sayHello();
    }

    @GetMapping("/tracked")
    public String tracked() {
        return service.sayTrackedHello();
    }

    @GetMapping("/error")
    public String error() {
        service.errorMethod();
        return "unreachable";
    }
}