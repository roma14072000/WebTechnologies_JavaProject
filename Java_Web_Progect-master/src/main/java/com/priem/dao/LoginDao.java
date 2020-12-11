package com.priem.dao;

import com.priem.util.DbUtil;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class LoginDao {
    public static boolean validate(String userName, String password) throws NamingException, SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Connection connection = null;
        boolean status = false;
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
            ps = connection.prepareStatement("SELECT * FROM dbo.Users where LOGIN=?");
            ps.setString(1, userName);
            rs= ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
