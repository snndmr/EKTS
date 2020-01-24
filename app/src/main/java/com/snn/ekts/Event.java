package com.snn.ekts;

import java.util.Calendar;

class Event {
    private static long sID = 1;
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
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
        String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);

        this.ID = sID;

        switch ((int) (sID % 3)) {
            case 0:
                this.image = R.drawable.event_test1;
                break;
            case 1:
                this.image = R.drawable.event_test2;
                break;
            case 2:
                this.image = R.drawable.event_test3;
                break;
        }
        this.name = Event.class.getSimpleName() + " : " + this.ID;
        this.dateEnd = date;
        this.dateStart = date;
        this.timeEnd = time;
        this.timeStart = time;
        this.location = "Konum Yok";
        this.description = Event.class.getName() + " : " + this.ID + "";

        sID += 1;
    }

    @Override
    public String toString() {
        return "\n\t Event {" +
                "\n\t ID=" + ID +
                "\n\t image=" + image +
                "\n\t name='" + name + '\'' +
                "\n\t dateEnd='" + dateEnd + '\'' +
                "\n\t dateStart='" + dateStart + '\'' +
                "\n\t timeEnd='" + timeEnd + '\'' +
                "\n\t timeStart='" + timeStart + '\'' +
                "\n\t location='" + location + '\'' +
                "\n\t description='" + description + '\'' +
                "\n\t }";
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
