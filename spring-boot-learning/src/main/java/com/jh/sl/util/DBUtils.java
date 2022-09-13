package com.jh.sl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static Connection getConnection(String url, String uid, String pwd) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection(url, uid, pwd);
        conn.setAutoCommit(false);
        return conn;
    }

}
