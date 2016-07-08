/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suren.fileio.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suren
 */
public class FileHelper {
    public static void write(String fileName,String content) throws IOException{
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
                
    }
    public static List<String> read(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader (fileName ));
        List<String> content = new ArrayList<>();
        String line= "";
        while((line= reader.readLine())!=null){
            content.add(line);
          
        }
        reader.close();
        return content;
       
        
    }

    
}
