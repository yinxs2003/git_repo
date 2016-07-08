package com.jdbc;

import java.sql.*;

public class DBQueryThread implements Runnable {
    @Override
    public void run() {
        Connection conn;
        String sql;
        String url = "jdbc:mysql://172.27.12.61:4006/test?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

        try {
            Class.forName("com.mysql.jdbc.Driver");

//            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

//            System.out.println("创建数据表成功");
            sql = "select * from seq_num";
            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println("number " + rs.getString(1));
//            }
            if(rs.next()){
                System.out.println("success");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
