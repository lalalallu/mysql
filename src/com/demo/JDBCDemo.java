package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url="jdbc:mysql://localhost/demo";
        String username="root";
        String password="TY1472583690";
        Connection conn = DriverManager.getConnection(url,username,password);

        //定义sql
        String sql="update demo set money=2000 where id = 1";

        //获取执行sql的对象Statement
        Statement stmt = conn.createStatement();

        //执行sql
        int count= stmt.executeUpdate(sql);//返回受影响的行数

        //处理结果
        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();
    }
}