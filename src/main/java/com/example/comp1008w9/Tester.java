package com.example.comp1008w9;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Course> courses = DBUtility.getCoursesFromDB();

        System.out.println(courses);

        ArrayList<Grade> grades = DBUtility.getGradesFromDB(100000001);

        System.out.println(grades);
    }
}
