/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.userBean;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Hazzan
 */
public class loginServlet extends HttpServlet{
     public void init() throws ServletException{
    }
     public void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, SQLException{
         
            String link;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            userBean ub = new userBean();
            ub.setUsername(username);
            ub.setPassword(password);
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            if(UserDao.isValid(ub)){
            link = "home.jsp";
            }else{link = "index.jsp";}
            
            RequestDispatcher view = request.getRequestDispatcher(link);
            view.forward(request, response);
            
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
