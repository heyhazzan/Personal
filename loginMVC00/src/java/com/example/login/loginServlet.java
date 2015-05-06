/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.userBean;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Hazzan
 */
public class loginServlet extends HttpServlet{
     public void init() throws ServletException{
    }
     public void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
            String username = request.getParameter("username");
            String pass = request.getParameter("pass");
            
            userBean ub = new userBean();
            
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            boolean isUserValid = ub.isUserValid(username, pass);
            if(isUserValid){
                RequestDispatcher view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            }else{
                //RequestDispatcher view = request.getRequestDispatcher("index.html");
                //view.forward(request, response);
                response.sendRedirect("index.html");
            }
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
