/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.userBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hazzan
 */
public class UserController extends HttpServlet{
    private static final String addOrEdit = "/user.jsp";
    private static final String home = "/home.jsp";
     public void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, SQLException{
         
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        String forward = "";
        String action = request.getParameter("action");
        System.out.println(action);
        try{
        if (action.equals("edit")){
            int userid = Integer.parseInt(request.getParameter("userid"));
            userBean user = UserDao.getUserbyID(userid);
            request.setAttribute("user", user);
            forward = addOrEdit;
        }else if(action.equals("add")){
            forward = addOrEdit;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }else if(action.equals("delete")){
            int userid = Integer.parseInt(request.getParameter("userid"));
            UserDao.deleteUser(userid);
            forward = home;
            HttpSession session = request.getSession();
            session.setAttribute("users", UserDao.getAllUsers());
        }  
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        System.out.println(action);
        try{
        if (action.equals("edit")){
            int userid = Integer.parseInt(request.getParameter("userid"));
            userBean user = UserDao.getUserbyID(userid);
            request.setAttribute("user", user);
            forward = addOrEdit;
        }else if(action.equals("add")){
            forward = addOrEdit;
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }else if(action.equals("delete")){
            int userid = Integer.parseInt(request.getParameter("userid"));
            UserDao.deleteUser(userid);
            forward = home;
            HttpSession session = request.getSession();
            session.setAttribute("users", UserDao.getAllUsers());
        }  
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}