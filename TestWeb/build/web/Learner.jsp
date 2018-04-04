<%-- 
    Document   : Learner
    Created on : 29-Nov-2017, 01:20:47
    Author     : CS_admin
--%>

<%@include file="checkLogin.jsp"%>
<%@page import="DataSource.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            div.container {
                width: 10%;
                border: 10px solid gray;
            }
            aside{

            }
            section {
                float: left;
                width: 10%;
                margin: 0;
                padding: 1em;
            }
            nav ul {
                list-style-type: none;
                padding: 0;
            }
            article {
                margin-left: 3600px;
                border-left: 1px solid gray;
                padding: 1em;
                overflow: hidden;
            }
            label.one{
                font: bold;
                color: red;
            }
            label.two{
                font-family: serif,cursive;
                color: green;
            }
            table{
                align-content: center;
            }
        </style>
    </head>
    <body>
        <%@include file="LearnerHeader.jsp"%>
                    <%
                String username = null;
                int userId = 0;
                if (session.getAttribute("LoggedIn") == null)
                  {
                    response.sendRedirect("Learner.jsp");
                  } else
                  {
                    username = (String) session.getAttribute("username");
                  }

                String userName = null;
                String sessionID = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null)
                  {
                    for (Cookie cookie : cookies)
                      {
                        if (cookie.getName().equals("username"))
                          {
                            sessionID = cookie.getValue();
                          }
                      }
                  }
            %>
        <h1>Leaner home page</h1>
        <table border="1" width="1000" align="center">
            <thead>
                <tr>
                    <th>
                        Subject
                    </th>
                    <th>
                        First Quarter
                    </th>
                    <th>Second Quarter</th>
                    <th>Third Quarter</th>
                    <th>Fourth Quarter</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <label class="one">
                            <center> Subject Name </center>
                        </label>
                    </td>
                    <td>
                        <label class="one">
                            Mark
                        </label>
                        <label class="two">
                            Colour
                        </label>
                    </td>
                    <td>
                        <label class="one">
                            Mark 
                        </label>
                        <label class="two">
                            Colour
                        </label>
                    </td>
                    <td>
                        <label class="one">
                            Mark 
                        </label>
                        <label class="two">
                            Colour
                        </label>
                    </td>
                    <td>
                        <label class="one">
                            Mark 
                        </label>
                        <label class="two">
                            Colour
                        </label>
                    </td>
                </tr>
            </tbody>
        </table>
        <hr>
        <h2>Current Career Chase</h2>
        <table border="1" width="1000" align="center">
            <thead>
                <tr>
                    <th>Priority</th>
                    <th>Overall Mark</th>
                    <th>Colour</th>
                    <th>Expected Mark</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>No. and Subject Name</td>
                    <td>Overall Mark in %</td>
                    <td>Green If great</td>
                    <td>Up to </td>
                </tr>
            </ tbody>
        </table>
        <%@include file="Foot.jsp" %>>
    </body>
</html>
