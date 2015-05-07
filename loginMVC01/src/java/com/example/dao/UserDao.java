/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.userBean;
import com.example.util.DbUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hazzan
 */
public class UserDao {
    public static boolean isValid(userBean user) throws SQLException, IOException{
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(""
                    +"select * from users where username = ? and password = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                result = true;
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            System.out.println("Connection Problem.");
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) throws SQLException, IOException{
        userBean user = new userBean();
        user.setPassword("hazzan");
        user.setUsername("hazzan");
        
        System.out.println(UserDao.isValid(user));
    }
}
