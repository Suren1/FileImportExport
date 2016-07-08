/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.dao.impl;

import com.suren.fileio.dao.CourseDAO;
import com.suren.fileio.entity.Course;
import com.suren.fileio.helper.FileHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suren
 */
public class CourseDAOImpl implements CourseDAO {

    private List<Course> courseList = new ArrayList<>();

    //@Override;
    public List<Course> getAll() {
        return courseList;
    }

    @Override
    public Course getByID(int id) {
        for (Course c : courseList) {
            if (c.getId() == id) {
                return c;

            }
        }
        return null;
    }

    @Override
    public boolean insert(Course t) {
        return courseList.add(t);
    }

    @Override
    public boolean delete(int id) {
        Course c = getByID(id);
        if (c != null) {
            courseList.remove(c);
            return true;
        }
        return false;
    }

    @Override
    public void importCSV(String filName) throws IOException {
        List<String> datas = FileHelper.read(filName);
        try {
            for (String line : datas) {

                String[] tokens = line.split(",");
                Course c = new Course();

                c.setId(Integer.parseInt(tokens[0]));
                c.setName(tokens[1]);
                c.setFees(Double.parseDouble(tokens[2]));
                c.setStatus(tokens[3].equalsIgnoreCase("1"));

                courseList.add(c);
                System.out.println(c);
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        //return courseList();

    }

    @Override
    public void exportCSV(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        for (Course c : courseList) {
            content.append(c.toCSV());
        }
        FileHelper.write(fileName, content.toString());
    }

    public Course getByName(String name) {
        for (Course c : courseList) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {

                return c;

            }

        }
        return null;
    }

}
