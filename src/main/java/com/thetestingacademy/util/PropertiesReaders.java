package com.thetestingacademy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaders {

    public static String readkey(String key) {

        Properties p=null;

        try {
            FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
            p=new Properties();
            p.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Input Output exception");

        }
         return p.getProperty(key);


    }
}
