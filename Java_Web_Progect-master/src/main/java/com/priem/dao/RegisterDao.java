package com.priem.dao;

import com.priem.util.DbUtil;

import javax.naming.NamingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
    public static boolean register(String userName, String password) throws NamingException, SQLException {
        PreparedStatement ps;
        Connection connection = null;
        try {
            if (connection == null || connection.isClosed()) {
                connection = DbUtil.getConnection();
            }
                String passwordToHash = password;
                byte[] salt = getSalt();

                String securePassword = getSecurePassword(passwordToHash, salt);

                ps = connection.prepareStatement("insert into dbo.Users (Login, Hash, Salt) values (?,?,?)");
                ps.setString(1, userName);
                ps.setString(2, securePassword);
                ps.setString(3, new String(salt));
                ps.executeUpdate();
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}

