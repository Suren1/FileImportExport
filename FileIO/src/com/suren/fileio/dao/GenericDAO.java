/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.dao;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author suren
 */
public interface GenericDAO <T>{
    List<T> getAll();
    T getByID(int id);
    boolean insert(T t);
    boolean delete(int id);
    void importCSV(String filName) throws IOException;
    void exportCSV(String fileName) throws IOException;
    
    
}
