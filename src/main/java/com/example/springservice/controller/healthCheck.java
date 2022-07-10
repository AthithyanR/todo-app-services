package com.example.springservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springservice.model.Response;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class healthCheck {

    @GetMapping("/healthCheck")
    public ResponseEntity<Response> healthCheckController() {
        Response response = new Response();
        return ResponseEntity.ok(response);
    }
}
