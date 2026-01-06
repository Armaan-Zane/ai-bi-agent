from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI(title="AI BI Service")


class AnalyzeRequest(BaseModel):
    text: str


@app.get("/health")
def health():
    return {"status": "AI service is running"}


@app.post("/analyze")
def analyze(request: AnalyzeRequest):
    # Dummy AI logic for now
    return {
        "input_received": request.text,
        "analysis": "This is a placeholder AI-generated insight"
    }
