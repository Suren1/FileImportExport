/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.entity;

/**
 *
 * @author suren
 */
public class Course {
    private int id ;
    private String name; 
    private double fees; 
    private boolean status; 

    public Course() {
    }

    public Course(int id, String name, double fees, boolean status) {
        this.id = id;
        this.name = name;
        this.fees = fees;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cource{" + "id=" + id + ", name=" + name + ", fees=" + fees + ", status=" + status + '}';
    }
    
    
    public String toCSV(){
        return id + "," + name+ "," +fees + " ,"+ ((status)?1:0) + "\r\n";
    }
    
}
