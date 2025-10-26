package com.example.vit.model;

public class vitResult {
    private long normalTime;
    private long springBootTime;
    private double improvement;
    private String message;

    public long getNormalTime() {
        return normalTime;
    }

    public void setNormalTime(long normalTime) {
        this.normalTime = normalTime;
    }

    public long getSpringBootTime() {
        return springBootTime;
    }

    public void setSpringBootTime(long springBootTime) {
        this.springBootTime = springBootTime;
    }

    public double getImprovement() {
        return improvement;
    }

    public void setImprovement(double improvement) {
        this.improvement = improvement;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
