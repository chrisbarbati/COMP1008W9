package com.example.comp1008w9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "root";

    /**
     * Tell the system which SQL driver to use, the IP and port, and the database name
     */
    private static String connectURL = "jdbc:mysql://127.0.0.1:3306/edmuse2023";

    private static int port = 3006;


    /**
     * Method to connect to the database and create an ArrayList of Course objects
     */
    public static ArrayList<Course> getCoursesFromDB(){
        ArrayList<Course> courses = new ArrayList<>();

        //Connect to the database
        //try() with round brackets indicate a try with resources block. Resources will automatically be closed if they
        //are opened inside the  block
        try(
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
                ){
            while(resultSet.next()){
                int crn = resultSet.getInt("crn");
                String courseCode = resultSet.getString("courseCode");
                String courseName = resultSet.getString("courseName");


                courses.add(
                        new Course(crn, courseCode, courseName)
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return courses;
    }

    private static ArrayList<Grade> getGradesFromDB(int studentNumber){
        ArrayList<Grade> grades = new ArrayList<>();

        //Connect to the database
        //try() with round brackets indicate a try with resources block. Resources will automatically be closed if they
        //are opened inside the  block
        try(
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM grades WHERE studentNum = " + studentNumber);
        ){
            while(resultSet.next()){
                int crn = resultSet.getInt("crn");
                int grade = resultSet.getInt("Grade");


                grades.add(
                        new Grade(studentNumber, crn, grade)
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return grades;
    }
}
