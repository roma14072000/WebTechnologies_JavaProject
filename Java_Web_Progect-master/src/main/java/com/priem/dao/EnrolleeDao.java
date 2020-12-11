package com.priem.dao;

import com.priem.models.Enrollee;
import com.priem.util.DbUtil;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnrolleeDao {
    PreparedStatement ps;
    Connection connection = null;

    // Insert Enrollee
    public boolean insertEnrollee(String firstName, String lastName, String email, String address, String user, String dateOfBirth) throws NamingException, SQLException {
        boolean result = false;
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
            ps = connection.prepareStatement("INSERT INTO dbo.Enrollees (FirstName, LastName, Email, Address, UserName, DateOfBirth) VALUES (?,?,?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, user);
            ps.setString(6, dateOfBirth);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            return result;
        }
    }

    // Update Enrollee
    public boolean updateEnrollee(String firstName, String lastName, String email, String address, String dateOfBirth, String userName) throws NamingException, SQLException {
        boolean result = false;
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
            ps = connection.prepareStatement("UPDATE dbo.Enrollees SET FirstName= ?, LastName = ?, Email = ?, Address = ?, DateOfBirth = ? WHERE UserName = ?;");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, dateOfBirth);
            ps.setString(6, userName);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            return result;
        }
    }

    // Accept Enrollee
    public boolean acceptEnrollee(Integer faculty, Integer langResult, Integer mathResult, Integer physResult,
                                  Integer certificate, Integer certificateType, String userName) throws NamingException, SQLException {
        boolean result = false;
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
            ps = connection.prepareStatement("UPDATE dbo.Enrollees SET Faculty= ?, LangResult = ?, MathResult = ?, PhysResult = ?, Certificate = ?," +
                    " CertificateType = ?, IsApplied = ? WHERE UserName = ?;");
            ps.setInt(1, faculty);
            ps.setInt(2, langResult);
            ps.setInt(3, mathResult);
            ps.setInt(4, physResult);
            ps.setInt(5, certificate);
            ps.setInt(6, certificateType);
            ps.setBoolean(7, true);
            ps.setString(8, userName);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            return result;
        }
    }

    // Select Enrollee
    public Enrollee selectEnrollee(String userName) throws NamingException, SQLException{
        Enrollee enrollee = null;
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
            ps = connection.prepareStatement("SELECT FirstName, LastName, Email, Address, DateOfBirth, " +
                    "IsApplied FROM dbo.Enrollees WHERE UserName =?");
            ps.setString(1, userName);
            String firstName;
            String lastName;
            String email;
            String address;
            String dateOfBirth;
            boolean isApplied;
            for(ResultSet rs = ps.executeQuery(); rs.next(); enrollee = new Enrollee(firstName, lastName, email, address, dateOfBirth, isApplied)) {
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                email = rs.getString("Email");
                address = rs.getString("Address");
                dateOfBirth = rs.getString("DateOfBirth");
                isApplied = rs.getBoolean("IsApplied");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            return enrollee;
        }
    }

    // Select Enrollees
    public List<Enrollee> selectAllEnrolles() {
        ArrayList enrolles = new ArrayList();
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
            ps = connection.prepareStatement("SELECT * FROM dbo.Enrollees");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                Integer langResult = rs.getInt("LangResult");
                Integer mathResult = rs.getInt("MathResult");
                Integer physResult = rs.getInt("PhysResult");
                Integer certificate = rs.getInt("Certificate");
                enrolles.add(new Enrollee(firstName, lastName, langResult, mathResult, physResult, certificate));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return enrolles;
    }

    // Delete Enrollees
}
