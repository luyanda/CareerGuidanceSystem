<%-- 
    Document   : checkLogin
    Created on : 08 Nov 2013, 10:21:30 AM
    Author     : Group 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <style>
        header {
            padding: 1em;
            color: #4169E1;
            background-color: lightgrey;
            clear: left;
            text-align: left;
            font-size: small;
        }
    </style>
</head>
<%
    if ((session.getAttribute("LoggedIn") == null) || (session.getAttribute("LoggedIn") == ""))
      {
        response.sendRedirect("Logout.jsp");
      } else
      {
%>
<header>Welcome, You are Logged<br></header>
    <%
          }
    %> 
