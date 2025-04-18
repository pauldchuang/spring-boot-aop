package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.annotation.TrackTime;

@Service
public class HelloService {

    public String sayHello() {
        return "Hello!";
    }

    @TrackTime
    public String sayTrackedHello() {
        try {
            Thread.sleep(2000); // sleep for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Tracked Hello!";
    }

    public void errorMethod() {
        throw new RuntimeException("Oops!");
    }
}
