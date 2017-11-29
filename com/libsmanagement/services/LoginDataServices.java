/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libsmanagement.services;

import com.libsmanagement.business.LoginBean;
import com.libsmanagement.common.ConnectionConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sohel1
 */
public class LoginDataServices {

    public int save(LoginBean login) throws SQLException {
        Connection con = DriverManager.getConnection(ConnectionConstants.URL, ConnectionConstants.USERNAME,
                ConnectionConstants.PASSWORD);

        PreparedStatement pstmt = con.prepareStatement("insert into lib_login values (?,?)");
        pstmt.setString(1, login.getUsername());
        pstmt.setString(2, login.getPassword());
        return pstmt.executeUpdate();
    }

    public int update(LoginBean login) throws SQLException {
        Connection con = DriverManager.getConnection(ConnectionConstants.URL, ConnectionConstants.USERNAME,
                ConnectionConstants.PASSWORD);

        PreparedStatement pstmt = con.prepareStatement("update lib_login set password = ? where username = ?");
        pstmt.setString(2, login.getUsername());
        pstmt.setString(1, login.getPassword());
        return pstmt.executeUpdate();
    }

    public int delete(LoginBean login) throws SQLException {
        Connection con = DriverManager.getConnection(ConnectionConstants.URL, ConnectionConstants.USERNAME,
                ConnectionConstants.PASSWORD);

        PreparedStatement pstmt = con.prepareStatement("delete from lib_login where username = ?");
        pstmt.setString(1, login.getUsername());
        return pstmt.executeUpdate();
    }
    
    public ResultSet validate(String username, String password) throws SQLException
    {
          Connection con = DriverManager.getConnection(ConnectionConstants.URL, ConnectionConstants.USERNAME,
                ConnectionConstants.PASSWORD);

        PreparedStatement pstmt = con.prepareStatement("select * from lib_login where username = ? and password = ?");
        ResultSet result = pstmt.executeQuery();
        
        return result;
    }

}
