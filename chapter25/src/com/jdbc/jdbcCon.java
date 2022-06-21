package com.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcCon {

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/db01";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");

        Connection connection = (Connection) driver.connect(url, properties);

        String sql = "insert into actor values(1, '刘德华')";

        Statement statement = (Statement) connection.createStatement();

        System.out.println(connection);


        statement.close();
        connection.close();
    }

    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db01";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");

        Connection connection = (Connection) driver.connect(url, properties);

        String sql = "insert into actor values(1, '刘德华')";

        Statement statement = (Statement) connection.createStatement();

        System.out.println(connection);


        statement.close();
        connection.close();

    }

    @Test
    public void connect03() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db01";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");

        DriverManager.registerDriver(driver);

        java.sql.Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);


    }

    /**
     * 推荐使用这种方式
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db01";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");

        java.sql.Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);

    }

    @Test
    public void connect05() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String password = properties.getProperty("password");

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        String sql = "insert into news values(1, '刘德华')";

        Statement statement = (Statement) connection.createStatement();

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }

}
