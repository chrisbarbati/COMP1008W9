package com.example.comp1008w9;

public class Course {

    //Instance variables
    private int crn;
    private String courseCode, courseName;

    public Course(int crn, String courseCode, String courseName) {
        setCrn(crn);
        setCourseCode(courseCode);
        setCourseName(courseName);
    }

    /**
     * Valid CRNs have 5 digits
     * @param crn
     */
    public void setCrn(int crn) {
        if (crn >= 10000 && crn <= 99999) {
            this.crn = crn;
        }else{
            throw new IllegalArgumentException("CRN must be in the range 10000 - 99999 inclusive.");
        }
    }

    /**
     * Valid course code has four uppercase letters followed by four numbers. Example COMP 1008, MGMT 2003,etc.
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {

        //Define a regular expression to check the course code
        String courseCodePattern = "[A-Z]{4}\\s[0-9]{4}";

        courseCode = courseCode.toUpperCase();

        if(courseCode.matches(courseCodePattern)) {
            this.courseCode = courseCode;
        }else{
            throw new IllegalArgumentException("Course code must be four letters, followed by a space, followed by four digits");
        }

    }

    /**
     * Course name can be a variety of different things. Remove leading and trailing whitespace and also check size.
     * @param courseName
     */
    public void setCourseName(String courseName) {
        //Remove whitespace
        courseName = courseName.trim();

        if(courseName.length() >= 2 && courseName.length() <= 30){
            this.courseName = courseName;
        }else{
            throw new IllegalArgumentException("Course name must be 2 to 30 characters in length.");
        }

    }

    public String toString(){
        return String.format("%d %s %s", crn, courseCode, courseName);
    }
}
