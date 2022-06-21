package com.jdbc;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class batch {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String password = properties.getProperty("password");

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        String sql = "select * from news where content = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,"刘德华");
        ResultSet resultSet = preparedStatement.executeQuery();
        if(preparedStatement.executeQuery().next()){
            System.out.println("ok");
        }

        preparedStatement.close();
        connection.close();
    }
}
