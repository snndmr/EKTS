package com.snn.ekts;

class Student extends Person {

    private String department;
    private String schoolNumber;

    Student(String name, String mail, String phone, String department, String schoolNumber) {
        super(name, mail, phone);

        this.department = department;
        this.schoolNumber = schoolNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ndepartment : " + department +
                "\nschoolNumber : " + schoolNumber;
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    String getSchoolNumber() {
        return schoolNumber;
    }

    void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }
}
