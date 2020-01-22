package com.snn.ekts;

class Event {
    private long ID;
    private int image;
    private String name;
    private String dateEnd;
    private String dateStart;
    private String timeEnd;
    private String timeStart;
    private String location;
    private String description;

    Event() {
        this.ID = System.currentTimeMillis() / 1000;

        this.image = R.drawable.test_event;
        this.name = "Etkinlik Adı Yok";
        this.dateEnd = "1/1/1970";
        this.dateStart = "1/1/1970";
        this.timeEnd = "00:00";
        this.timeStart = "00:00";
        this.location = "Konum Yok";
        this.description = "Tanım Yok";
    }

    long getID() {
        return ID;
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
