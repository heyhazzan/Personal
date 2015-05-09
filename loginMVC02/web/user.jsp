<%-- 
    Document   : user
    Created on : May 8, 2015, 1:29:52 PM
    Author     : Hazzan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.example.model.userBean"%>
<% 
    response.setHeader("Cache-Control","no-store, must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",-1);
    
    if(session.getAttribute("username") != null){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <a href ="home.jsp">Home</a> | <a href ="profile.jsp">Profile</a> | <a href ="LogoutServlet">Logout</a>
        <h1>Hello, <%=session.getAttribute("username")%>!</h1>
        <form method = "POST" action = "UserController">
            <p>Username:<input type = "text" name = "username" /></p>
            <p>Password:<input type = "text" name = "password" /></p>
            <p><input type = "submit" value = "Submit" /></p>
        </form>
    </body>
</html>
<% 
    }else{
         response.sendRedirect("index.html");
    }
%>