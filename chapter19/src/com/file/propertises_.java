package com.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertises_ {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\musql.properties";
        //创建对象
        Properties properties = new Properties();
        //加载指定配置文件
        properties.load(new FileReader(filePath));
        //打印到控制台
        properties.list(System.out);
        //根据key获取对应的值
        String str = properties.getProperty("id");
        System.out.println("id = " + str);


    }
}
