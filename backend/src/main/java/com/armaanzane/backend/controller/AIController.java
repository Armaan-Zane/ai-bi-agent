package com.armaanzane.backend.controller;

import com.armaanzane.backend.dto.AnalyzeRequest;
import com.armaanzane.backend.dto.AnalyzeResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/analyze")
@CrossOrigin(origins = "*")
public class AIController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public AnalyzeResponse analyze(@RequestBody AnalyzeRequest request) {

        AnalyzeResponse fallback = new AnalyzeResponse();

        if (request.getText() == null || request.getText().trim().isEmpty()) {
            fallback.setInsight("Invalid input");
            fallback.setRecommendation("Please provide a valid business statement");
            return fallback;
        }

        try {
            String aiServiceUrl = "http://localhost:8000/analyze";

            AnalyzeResponse response =
                    restTemplate.postForObject(
                            aiServiceUrl,
                            request,
                            AnalyzeResponse.class
                    );

            return response;

        } catch (Exception e) {
            fallback.setInsight("AI service unavailable");
            fallback.setRecommendation("Please try again later");
            return fallback;
        }
    }
}
