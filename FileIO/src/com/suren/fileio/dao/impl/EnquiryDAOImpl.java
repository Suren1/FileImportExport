/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.dao.impl;

import com.suren.fileio.dao.CourseDAO;
import com.suren.fileio.dao.EnquiryDAO;
import com.suren.fileio.entity.Course;
import com.suren.fileio.entity.Enquiry;
import com.suren.fileio.helper.FileHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suren
 */
public class EnquiryDAOImpl implements EnquiryDAO {
    private List<Enquiry> enquiryList = new ArrayList<>();
    private CourseDAO courseDAO;
    
    
    //@Override;
    public List<Enquiry> getAll() {
      return enquiryList;
    }

    @Override
    public Enquiry getByID(int id) {
      for(Enquiry c: enquiryList){
          if(c.getId()==id){
              return c;
              
          }
        }
      return null;
    }

    @Override
    public boolean insert(Enquiry t) {
        return enquiryList.add(t);
    }

    @Override
    public boolean delete(int id) {
       Enquiry c= getByID(id);
       if(c!=null){
           enquiryList.remove(c);
           return true;
       }
       return false;
    }

    @Override
    public void importCSV(String filName) throws IOException{
        //CourseDAO courseDAO = new CourseDAOImpl();
       List<String> datas= FileHelper.read(filName);
       for(String line:datas){
           String[] tokens= line.split(",");
           Enquiry e= new Enquiry();
           e.setFirstName(tokens[0]);
           e.setLastName(tokens[1]);
           e.setEmail(tokens[2]);
           e.setContactNo(tokens[3]);
           Course course= courseDAO.getByName(tokens[4]);
           e.setCourse(course);
         
           enquiryList.add(e);
    }}

    @Override
     public void exportCSV(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        for (Enquiry e : enquiryList) {
            content.append(e.toCSV());
        }
        FileHelper.write(fileName, content.toString());
    }

    @Override
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO= courseDAO;
    }
    
}
