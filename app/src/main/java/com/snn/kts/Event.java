package com.snn.kts;

class Event {
    private long eventID;
    private int image;
    private String name;
    private String date;
    private String description;

    Event(int image, String name, String date, String description) {
        this.eventID = System.currentTimeMillis() / 1000;
        this.image = image;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    long getEventID() {
        return eventID;
    }

    int getImage() {
        return image;
    }

    void setImage(int image) {
        this.image = image;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDate() {
        return date;
    }

    void setDate(String date) {
        this.date = date;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }
}
