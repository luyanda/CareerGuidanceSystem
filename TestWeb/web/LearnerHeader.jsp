<%-- 
    Document   : header
    Created on : 10 Nov 2017, 12:33:12 PM
    Author     : luyanda.mbodla
--%>

<%@page import="DataSource.User"%>
<%@page import="DataSource.Learner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <style>
        header {
            padding: 1em;
            color: #4169E1;
            background-color: lightgrey;
            clear: left;
            text-align: center;
            font-size: xx-large;
        }
        sty{
            color: orange;
            font-size: x-large;
        }
        h2
        {
            color: #4169E1;
            font-size: x-large;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #4169E1;
        }

        li {
            float: left;
            border-right:1px solid #bbb;
        }

        li:last-child {
            border-right: none;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: orange;
        }

        .active {
            background-color: #4CAF50;
        }
    </style>
</head>
<div>  
    <header>
        South African Public Traditional Universities
    </header>
    <div>
        <ul>
            <% User learner_Log = (User) session.getAttribute("LoggedIn");%>
            <li><a class="active" href="Learner.jsp">Home</a></li>
            <li><a href="#">Courses Chasing</a></li>
            <li><a href="#">Login</a></li>
            <li><a href="LearnerProfile.jsp?Learner=<%=learner_Log.getUser_UniqueId() %>">Profile</a></li>
            <li style="float:right"><a href="Logout.jsp">Log out</a></li>
        </ul>

    </div>
</div>