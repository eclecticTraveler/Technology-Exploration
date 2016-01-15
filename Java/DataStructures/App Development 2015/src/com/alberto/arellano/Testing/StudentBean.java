package com.alberto.arellano.Testing;

/**
 * Created by rome on 10/29/2015.
 */
public class StudentBean extends PersonBean {
    private String grade;
    private String iNumber;
    private String classification;

    public  StudentBean(String name, String last, int age, String grade, String iNumber, String classification){
        super(name, last, age);
        this.grade = grade;
        this.iNumber = iNumber;
        this.classification = classification;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getiNumber() {
        return iNumber;
    }

    public void setiNumber(String iNumber) {
        this.iNumber = iNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }



}
