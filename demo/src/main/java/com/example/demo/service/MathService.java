package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.annotation.TrackTime;

@Service
public class MathService {

    public void doSomeMath() {
        System.out.println("Calculated value: " + Math.sqrt(Math.random() * 1000000000));
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
}
