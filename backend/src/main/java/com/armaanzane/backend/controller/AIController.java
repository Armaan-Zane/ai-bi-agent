package com.armaanzane.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/analyze")
public class AIController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public String analyze(@RequestBody Map<String, Object> body) {
        String aiServiceUrl = "http://localhost:8000/analyze";
        return restTemplate.postForObject(aiServiceUrl, body, String.class);
    }
}
