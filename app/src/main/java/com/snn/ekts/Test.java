package com.snn.ekts;

import java.util.ArrayList;

class Test {
    static ArrayList<Event> events = new ArrayList<>();
    static ArrayList<Person> people;
    static ArrayList<Operation> operations;

    Test() {
        events = new ArrayList<>();
        people = new ArrayList<>();
        operations = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            events.add(new Event(
                    R.drawable.event_default,
                    "Event : " + i,
                    (i + 1) + "/9/2020",
                    i + "/9/2020",
                    "14:30",
                    "12:00",
                    "Etlik Kampüsü",
                    "Tanışma Etkinliği"
            ));
        }

        for (int i = 0; i < 1000; i++) {
            people.add(new Student(
                    "Sinan " + i,
                    "sinan" + i + "@mail.com",
                    "+(90) 555 555 55 55",
                    "Computer Engineering",
                    "12345678910"
            ));
        }

        for (int i = 0; i < 100; i++) {
            people.add(new NonStudent(
                    "Sinan " + i,
                    "sinan" + i + "@mail.com",
                    "+(90) 555 555 55 55"
            ));
        }

        for (int i = 0; i < 3000; i++) {
            operations.add(new Operation(
                    i + "/9/2020",
                    "14:30",
                    "val_" + i
            ));
        }
    }
}
