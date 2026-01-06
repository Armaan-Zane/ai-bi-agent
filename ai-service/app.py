from fastapi import FastAPI

app = FastAPI(title="AI BI Service")


@app.get("/health")
def health():
    return {"status": "AI service is running"}
