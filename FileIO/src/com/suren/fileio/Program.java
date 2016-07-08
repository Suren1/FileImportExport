/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio;

import com.suren.fileio.dao.CourseDAO;
import com.suren.fileio.dao.impl.CourseDAOImpl;
import com.suren.fileio.dao.impl.EnquiryDAOImpl;
import java.io.IOException;
import java.util.Scanner;
import com.suren.fileio.dao.EnquiryDAO;

/**
 *
 * @author suren
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        CourseDAO courseDAO = new CourseDAOImpl();
        EnquiryDAO enquiryDAO= new EnquiryDAOImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter File to import Course:");
        String filename = input.next();
        try {
            courseDAO.importCSV(filename);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.out.println("Enter File to import Enqiry:");
        filename = input.next();
                
        try {
            enquiryDAO.setCourseDAO(courseDAO);
            
            enquiryDAO.importCSV(filename);
          
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        enquiryDAO.getAll().forEach(e -> {
            System.out.println(e.toString());
        });
    }

}
