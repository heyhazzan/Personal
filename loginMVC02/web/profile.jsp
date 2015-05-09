<%-- 
    Document   : profile.jsp
    Created on : May 6, 2015, 4:04:28 PM
    Author     : Hazzan
--%>
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
        <title>Profile</title>
    </head>
    <body>
        <a href ="home.jsp">Home</a> | <a href ="profile.jsp">Profile</a> | <a href ="LogoutServlet">Logout</a>
        <h1>Hello, <%=session.getAttribute("username")%>!</h1>
    </body>
</html>
<% 
    }else{
         response.sendRedirect("index.html");
    }
%>
