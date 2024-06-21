package com.example.HNG_stage_1.controller;

import com.example.HNG_stage_1.model.Visitor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public ResponseEntity<Visitor> greeting(@RequestParam(name = "visitor_name") String visitor_name, HttpServletRequest request){
        return greetings(visitor_name, request);
    }

    private ResponseEntity<Visitor> greetings(String visitor_name, HttpServletRequest request){
        String clientIp = request.getRemoteAddr();
        Visitor visitor = new Visitor();
        visitor.setClient_ip(clientIp);
        visitor.setLocation("Abuja");
        visitor.setGreeting("Hello," + visitor_name);
        return ResponseEntity.ok(visitor);
    }
}
