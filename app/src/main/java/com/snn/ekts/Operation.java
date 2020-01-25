package com.snn.ekts;

class Operation {
    private String readTime;
    private String readDate;
    private String readValue;

    Operation(String readTime, String readDate, String readValue) {
        this.readTime = readTime;
        this.readDate = readDate;
        this.readValue = readValue;
    }

    String getReadTime() {
        return readTime;
    }

    void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    String getReadDate() {
        return readDate;
    }

    void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    String getReadValue() {
        return readValue;
    }

    void setReadValue(String readValue) {
        this.readValue = readValue;
    }
}
