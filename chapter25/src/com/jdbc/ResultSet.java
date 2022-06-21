package com.jdbc;

import com.mysql.jdbc.Statement;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ResultSet {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String password = properties.getProperty("password");

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        String sql = "select * from news";

        Statement statement = (Statement) connection.createStatement();

        java.sql.ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.println(anInt + string);
        }

        statement.close();
        connection.close();
        resultSet.close();
    }
}
