package com.example.comp1008w9;

public class Grade {
    //Instance variables
    private int studentNum, crn, grade;

    public Grade(int studentNum, int crn, int grade) {
        this.studentNum = studentNum;
        this.crn = crn;
        this.grade = grade;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }


    public int getGrade() {
        return grade;
    }

    /**
     * Grade must be 0-100
     * @param grade
     */
    public void setGrade(int grade) {
        if(grade >=0 && grade <= 100){
            this.grade = grade;
        }else{
            throw new IllegalArgumentException("Grade must be in range 0-100");
        }
    }
}
