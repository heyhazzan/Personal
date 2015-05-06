/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hazzan
 */
public class ProcessAdminServlet {
     public void init() throws ServletException{
    }
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String[] lang = request.getParameterValues("lang");
        String[] box = request.getParameterValues("box");
        String type = request.getParameter("type");
        PrintWriter out = response.getWriter();
        
        out.println("<h1>User Level: "+ type +"</h1>");
        out.println("<h1>Hello "+ name +"!</h1>");
        out.println("<h2>Welcome to the "+ course +" course!</h2>");
        out.println("<h3>For you to graduate, you must master the ff. languages: <h3>");
        for(int x = 0; x<lang.length;x++){
            out.println("<h3>"+ lang[x] +"</h3>");
        }
            out.println("<h1>Your'e a  "+ box[0] +" fan!</h1>");
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
    public void destroy(){
    }
}
