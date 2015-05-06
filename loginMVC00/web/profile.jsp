<%-- 
    Document   : profile.jsp
    Created on : May 6, 2015, 4:04:28 PM
    Author     : Hazzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged-in</title>
    </head>
    <body>
        <a href ="home.jsp">Home</a> | <a href ="profile.jsp">Profile</a>
        <h1>Hello, <%=session.getAttribute("username")%>!</h1>
    </body>
</html>
