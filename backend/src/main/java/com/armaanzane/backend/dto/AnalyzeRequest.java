package com.armaanzane.backend.dto;

public class AnalyzeRequest {

    private String text;

    public AnalyzeRequest() {
        // default constructor REQUIRED for JSON binding
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
