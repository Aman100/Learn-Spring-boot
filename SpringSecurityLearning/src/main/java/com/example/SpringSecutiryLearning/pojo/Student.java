package com.example.SpringSecutiryLearning.pojo;

public class Student {
    private String name;
    private Double percentage;

    public Student() {}

    public Student(String name, Double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
