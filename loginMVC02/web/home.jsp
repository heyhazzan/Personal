<%-- 
    Document   : home
    Created on : May 6, 2015, 3:55:06 PM
    Author     : Hazzan
--%>
<%@page import="com.example.model.userBean"%>
<%@page import="java.util.List"%>
<%@page import="com.example.dao.UserDao"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <title>Home</title>
    </head>
    <body>
        <a href ="home.jsp">Home</a> | <a href ="profile.jsp">Profile</a> | <a href ="LogoutServlet">Logout</a>
        <h1>Hello, <%=session.getAttribute("username")%>!</h1>
        <p><a href = "UserController?action=add">Add User</a></p>
        <table border = 1>
            <thead>
            <tr>
                <td>Username</td>
                <td>Password</td>
                <td colspan = "2">Action</td>
            </tr>
            </thead>
            <tbody>
           <c:forEach items = "${users}" var = "user">
            <tr>
                <td><c:out value = "${user.username}"/></td>
                <td><c:out value = "${user.password}"/></td>
                <td><a href = "UserController?action=edit&userid="<c:out value = "${user.userid}"/>/>Edit</a></td>
                <td><a href = "UserController?action=delete&userid="<c:out value = "${user.userid}"/>/>Delete</a></td>
            </tr>
           </c:forEach>
            </tbody>
        </table>
    </body>
</html>
<% 
    }else{
         response.sendRedirect("index.html");
    }
%>
