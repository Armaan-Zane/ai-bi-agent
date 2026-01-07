from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI(title="AI BI Service")


class AnalyzeRequest(BaseModel):
    text: str


@app.get("/health")
def health():
    return {"status": "AI service is running"}


@app.post("/analyze")
def analyze(req: AnalyzeRequest):
    text = req.text.lower()

    insight = "No significant business insight detected."
    recommendation = "Monitor the metric regularly."

    if "sales" in text and ("drop" in text or "decrease" in text):
        insight = "Sales performance has declined, indicating potential revenue risk."
        recommendation = "Review pricing, promotions, and market demand."

    elif "sales" in text and ("increase" in text or "growth" in text):
        insight = "Sales growth detected, indicating positive business momentum."
        recommendation = "Scale successful strategies and ensure supply readiness."

    elif "churn" in text:
        insight = "Customer churn mentioned, which may affect long-term revenue."
        recommendation = "Improve customer retention and engagement strategies."

    elif "profit" in text:
        insight = "Profit-related change detected, impacting overall business health."
        recommendation = "Analyze cost structure and margin optimization."

    return {
        "input_received": req.text,
        "insight": insight,
        "recommendation": recommendation
    }
