<%-- 
    Document   : CoursesChasing
    Created on : 26-Jul-2017, 17:31:31
    Author     : CS_admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataSource.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Course</th>
                    <th>Field</th>
                    <th>Title</th>
                    <th>Duration</th>
                    <th>Careers</th>
                    <th>Institutions</th>
                    <th>Subjects</th>
                    <th>APS</th>
                    <th>Status</th>
                    <th>Material</th>
                    <th>Study-Tips</th>
                    <th>News</th>
                    <th>Read More</th>
                    <th>Other</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <%
                Functions action= new DAO();
                ArrayList<Programmes> courses = action.GetChasingCourses();
              for(Programmes p: courses)
                  {
            %>
            <tbody>
                <tr>
                    <td><%= p.getName() %></td>
                    <td><%= p.getField() %></td>
                    <td><%= p.getTitle() %></td>
                    <td><%= p.getDuration() %></td>
                    <td><%= p.getInstitution() %></td>
                    <td><%= p.getAps() %></td>
                    <td><%= p.getCarees() %></td>
                    <td><%= p.getSubjects() %></td>
                    <td><%= p.getStatus() %></td>
                    <td><%= p.getExtraMaterial() %></td>
                    <td><%= p.getStudyTips() %></td>
                    <td><%= p.getNews() %></td>
                    <td><a href="">read more</a>></td><!--Linke to -->
                    <td></td>
                    <td><a href="RemoveProgram?=<%=%>" />Remove</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
