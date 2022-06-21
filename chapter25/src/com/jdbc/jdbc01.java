package com.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;
import java.util.Properties;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {

        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/db01";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");

        Connection connection = (Connection) driver.connect(url, properties);

        String sql = "insert into actor values(1, '刘德华')";

        Statement statement = (Statement) connection.createStatement();
        int rows = statement.executeUpdate(sql);

        System.out.println(rows > 0 ? "成功" : "失败" );

        statement.close();
        connection.close();
    }
}
