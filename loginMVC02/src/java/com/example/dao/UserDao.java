/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.userBean;
import com.example.util.DbUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 CHECKS IF USER IS VALI
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
    
     public static void addUser(String username,
             String password) throws SQLException, IOException{
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""
                    +"INSERT INTO users (username, password) VALUES (?,?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeQuery();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            System.out.println("Connection Problem.");
            e.printStackTrace();
        }
    }
     public static void deleteUser(int id) throws SQLException, IOException{
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(""
                    +"DELETE FROM users WHERE userid=?");
            stmt.setInt(1, id);
            stmt.executeQuery();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            System.out.println("Connection Problem.");
            e.printStackTrace();
        }
    }
     public static void updateUser(int id) throws SQLException, IOException{
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(""
                    +"UPDATE users SET username=?,password=? WHERE userid=?");
     //       stmt.setString(1, id);
     //       stmt.setString(2, id);
            stmt.setInt(3, id);
            stmt.executeQuery();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            System.out.println("Connection Problem.");
            e.printStackTrace();
        }
    }
     public static List<userBean> getAllUsers() throws IOException{
        List<userBean> users = new ArrayList();
        DbUtil db = new DbUtil();
        try{
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while(rs.next()){
                userBean user = new userBean();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
     public static userBean getUserbyID(int id) throws SQLException, IOException{
        userBean user = new userBean();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        try{
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from users WHERE userid = "+ id);
            if(rs.next()){
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println("Connection Problem.");
            e.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) throws SQLException, IOException{
        userBean user = new userBean();
        user.setPassword("hazzan");
        user.setUsername("hazzan");
        
        System.out.println(UserDao.isValid(user));
    }
}
