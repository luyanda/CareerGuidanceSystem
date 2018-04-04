<%-- 
    Document   : Profile
    Created on : 09-Feb-2018, 09:31:29
    Author     : CS_admin
--%>

<%@page import="DataSource.User"%>
<%@page import="DataSource.DataAccessLayer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="LearnerHeader.jsp"%>
        <%
            String username = null;
            int userId = 0;
            User id = new User();
            if (session.getAttribute("LoggedIn") == null)
              {
                response.sendRedirect("Login.jsp");
              } else
              {
                username = (String) session.getAttribute("username");
                userId = (int) session.getAttribute("Learner");
                id.setUser_UniqueId(userId);
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
        <div>
            <%
                if (request.getAttribute("error") != null)
                  {
                    ArrayList<String> errors = (ArrayList<String>) request.getAttribute("error");
                    String str = "";
                    for (String e : errors)
                      {
                        str = e.toString();

            %>
            <table>
                <tr><span style="color: chartreuse"><%=str%></span></tr> 
            </table>

            <%        }
                  }
            %>
            <p style="color: #b5ff5e"><%=request.getAttribute("Successmsg") == null ? "" : request.getAttribute("Successmsg")%></p>
            <table border="1" width="100%" >
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>SA ID No</th>
                        <th>Email Address</th>
                        <th>Cell No</th>
                        <th>Username</th>
                        <th>Student No.</th>
                        <th>Grade</th>
                        <th>Class Name</th>
                    </tr>
                </thead>
                <%
                    DataAccessLayer dao = new DataAccessLayer();
                    Learner user = dao.GetProfile(id);
                %>
                <tbody>
                    <tr>
                        <td><%= user.getName() %></td>
                        <td><%= user.getSurname() %></td>
                        <td><%= user.getIdNumber() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getCell() %></td>
                        <td><%= user.getSurname() %></td>
                        <td><%= user.getLearner_Number() %></td>
                        <td><%= user.getLearner_Grade() %></td>
                        <td><%= user.getLearner_Class() %></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
