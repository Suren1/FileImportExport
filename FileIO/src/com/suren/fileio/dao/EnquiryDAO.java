/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.dao;

import com.suren.fileio.entity.Enquiry;

/**
 *
 * @author suren
 */
public interface EnquiryDAO extends GenericDAO<Enquiry>{
    void setCourseDAO(CourseDAO courseDAO);
    
}
