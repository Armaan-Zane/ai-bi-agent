package com.armaanzane.backend.dto;

public class AnalyzeResponse {

    private String input_received;
    private String insight;
    private String recommendation;

    public AnalyzeResponse() {}

    public String getInput_received() {
        return input_received;
    }

    public void setInput_received(String input_received) {
        this.input_received = input_received;
    }

    public String getInsight() {
        return insight;
    }

    public void setInsight(String insight) {
        this.insight = insight;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
