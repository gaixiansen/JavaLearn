package com.github.jdbc.jdbedemo;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class Demo2 {

    @Test
    public void test1() throws SQLException, ClassNotFoundException {
//        demo1();
        //1、注册驱动
//        DriverManager.registerDriver(new Driver());
        // 因为com.mysql.jdbc.Driver中的静态代码块调用了new Driver(),所以以下方式避免了多次注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、得到连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=udn100@HW");
        //3、得到执行sql的对象
        Statement statement = conn.createStatement();
        //4、执行sql
        String sql = "select * from User";
        ResultSet resultSet = statement.executeQuery(sql);
        //5、处理返回的结果
        //返回的是一个可迭代的对象，调用next方法，游标指向下一个查出的记录，可以通过索引获取内容，也可以通过列名去获取
        while (resultSet.next()){
            System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("name"));
            System.out.println(resultSet.getObject("passwd"));
            System.out.println(resultSet.getObject("email"));
            System.out.println(resultSet.getObject("birthday"));
            System.out.println("----------------------------------------------------------------");
        }
        //6、关闭连接
        resultSet.close();
        statement.close();
        conn.close();

    }
    @Test
    public void demo1() throws ClassNotFoundException, SQLException {
        //1、注册驱动
//        DriverManager.registerDriver(new Driver());
        // 因为com.mysql.jdbc.Driver中的静态代码块调用了new Driver(),所以以下方式避免了多次注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、得到连接对象
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "udn100@HW");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",info);
        //3、得到执行sql的对象
        Statement statement = conn.createStatement();
        //4、执行sql
        String sql = "select * from User";
        ResultSet resultSet = statement.executeQuery(sql);
        //5、处理返回的结果
        //返回的是一个可迭代的对象，调用next方法，游标指向下一个查出的记录，可以通过索引获取内容，也可以通过列名去获取
        while (resultSet.next()){
            System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("name"));
            System.out.println(resultSet.getObject("passwd"));
            System.out.println(resultSet.getObject("email"));
            System.out.println(resultSet.getObject("birthday"));
            System.out.println("----------------------------------------------------------------");
        }
        //6、关闭连接
        resultSet.close();
        statement.close();
        conn.close();
    }

}
