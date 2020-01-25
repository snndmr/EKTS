package com.snn.ekts;


import java.sql.Timestamp;

class Event {

    private int image;
    private String ID;
    private String name;
    private String dateEnd;
    private String dateStart;
    private String timeEnd;
    private String timeStart;
    private String location;
    private String description;

    Event(int image, String name, String dateEnd, String dateStart, String timeEnd, String timeStart, String location, String description) {
        this.image = image;
        this.ID = "event_" + new Timestamp(System.currentTimeMillis());
        this.name = name;
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;
        this.location = location;
        this.description = description;
    }

    Event() {
    }

    @Override
    public String toString() {
        return "\nimage : " + image +
                "\nID : " + ID +
                "\nname : " + name +
                "\ndateEnd : " + dateEnd +
                "\ndateStart : " + dateStart +
                "\ntimeEnd : " + timeEnd +
                "\ntimeStart : " + timeStart +
                "\nlocation : " + location +
                "\ndescription : " + description;
    }

    int getImage() {
        return image;
    }

    void setImage(int image) {
        this.image = image;
    }

    String getID() {
        return ID;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDateEnd() {
        return dateEnd;
    }

    void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    String getDateStart() {
        return dateStart;
    }

    void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    String getTimeEnd() {
        return timeEnd;
    }

    void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    String getTimeStart() {
        return timeStart;
    }

    void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }
}
