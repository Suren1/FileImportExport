/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.entity;
import com.suren.fileio.entity.Course;
/**
 *
 * @author suren
 */
public class Enquiry {
           private int id;
            private String firstName, lastName, email,contactNo;
            private Course course;

    public Enquiry() {
    }

    public Enquiry(int id,String firstName, String lastName, String email, String contactNo, Course course) {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enquiry{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNo=" + contactNo + ", course=" + course + '}';
    }
    
    
    public String toCSV(){
        return  firstName + "," +lastName + " ,"+ email + ","+contactNo+ ", " + course.getName() + "\r\n";
    } 
            
    
    
}
