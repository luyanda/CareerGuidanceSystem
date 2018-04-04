<%-- 
    Document   : LearnerProfile
    Created on : 08-Feb-2018, 15:15:10
    Author     : CS_admin
--%>

<%@page import="DataSource.User"%>
<%@page import="DataSource.DataAccessLayer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
        <style>
            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            /* Center the image and position the close button */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
                font-size: x-large;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 40%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }
            form
            {
                color: orange;
            }
            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {-webkit-transform: scale(0)} 
                to {-webkit-transform: scale(1)}
            }

            @keyframes animatezoom {
                from {transform: scale(0)} 
                to {transform: scale(1)}
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
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
                response.sendRedirect("Login.jsp");
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
                <tr><span style="color: red"><%=str%></span></tr> 
            </table>
            <%        }
                  }
            %>
            <p style="color: #b5ff5e"><%=request.getAttribute("Successmsg") == null ? "" : request.getAttribute("Successmsg")%></p>
            <%
                if (request.getParameter("Learner") != null);
                  {

                    Learner learner = null;
                    User user = (User) session.getAttribute("Learner");
                    DataAccessLayer dao = new DataAccessLayer();
                    int id = Integer.parseInt(request.getParameter("Learner"));
                    learner = dao.GetProfile(id);
            %>
            <form action="Controller" method="POST" id="form1" class="modal-content animate" >
                <input type="hidden" name="action" value="ProfileUpdate"/>
                <div class="imgcontainer">
                    <strong>Profile Update</strong>
                </div>
                <div class="container">
                    <label><b>Cell</b></label>
                    <input type="text" value="<%=learner.getCell()%>" name="email" required/>

                    <label><b>Email</b></label>
                    <input type="text" value="<%=learner.getEmail()%>" name="cell" required/>

                    <label><b>Student Number</b></label>
                    <input type="text" value="<%=learner.getLearner_Number()%>" name="stud_num" required/>

                    <label><b>Grade</b></label>
                    <input type="text" value="<%=learner.getLearner_Grade()%>" name="grade" required/>

                    <label><b>Class</b></label>
                    <input type="text" value="<%=learner.getLearner_Class()%>" name="stream" required/>

                    <button type="submit" name="submit" form="form1">Update & View</button>
                    <input type="checkbox" checked="checked"> Remember me
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="submit" form="form1" class="cancelbtn">Update Details</button>
                </div>
            </form>
            <% }

            %>
        </div>
        <%@include file="Foot.jsp" %>>
    </body>
</html>
