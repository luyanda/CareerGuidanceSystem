<%-- 
    Document   : signIn
    Created on : 08 Nov 2013, 10:21:30 AM
    Author     : CS_admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessions = request.getSession(false);
    sessions.removeAttribute("LoggedIn");
    sessions.getMaxInactiveInterval();
    response.sendRedirect("Home.jsp");
%>