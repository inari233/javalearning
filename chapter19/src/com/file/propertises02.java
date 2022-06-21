package com.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class propertises02 {
    public static void main(String[] args) throws Exception {
        String str = "src\\mysql02.properties";
        Properties properties = new Properties();
        properties.setProperty("user", "汤姆");
        properties.store(new FileOutputStream(str), null);
    }
}
