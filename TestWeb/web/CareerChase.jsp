<%-- 
    Document   : CareerChase
    Created on : 18-Jul-2017, 10:09:31
    Author     : CS_admin
--%>


<%@page import="DataSource.Programmes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataSource.Functions"%>
<%@page import="DataSource.DAO"%>
<%@page import="DataSource.User"%>

<!--past here-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Career Guidance Application</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="style.css" rel="stylesheet" type="text/css" />

        <script type='text/javascript' src='js/jquery.min.js'></script>
        <script type='text/javascript' src='js/jquery.scrollTo-min.js'></script>
        <script type='text/javascript' src='js/jquery.localscroll-min.js'></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $.localScroll();
            });
        </script> 


    </head>
    <body>

        <div><h2>Welcome back 
                <%if (request.getAttribute("Successmsg") != null)
                      {
                        String text = (String) request.getAttribute("Successmsg");
                %>
                <%=text%>
                <%  }
                %> 
            </h2>
        </div>
        <%
            //if(request.getParameter("id") != null)
            //  {
            Functions f = new DAO();
            //User user = new User();

            Programmes course = f.GetCareerChase(request.getParameter("id"));
        %>
        <table border="1" width="1000" align="center">
            <thead>
                <tr>
                    <th>Course</th>
                    <th>Field</th>
                    <th>Title</th>
                    <th>Duration</th>
                    <th>Varsity</th>
                    <th>Minimum APS</th>
                    <th>Careers</th>
                    <th>Subjects</th>
                    <th>Status</th>
                    <th>Material</th>
                    <th>Tips</th>
                    <th>News</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td><!--%= course.getName()%--></td>
                    <td><!--%= course.getField()%--></td>
                    <td><!--%= course.getTitle()%--></td>
                    <td><!--%= course.getDuration()%--></td>
                    <td><!--%= course.getInstitution()%--></td>
                    <td><!--%= course.getAps()%--></td>
                    <td><!--%= course.getCarees()%--></td>
                    <td><!--%= course.getSubjects()%--></td>
                    <td><!--%= course.getStatus()%--></td>
                    <td><!--%= course.getExtraMaterial()%--></td>
                    <td><!--%= course.getStudyTips()%--></td>
                    <td><!--%= course.getNews()%--></td>
                </tr>
                <% //} %>
            </tbody>
        </table>
    </body>
</html>

