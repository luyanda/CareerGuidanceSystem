<%-- 
    Document   : Learner_Reg
    Created on : 25-Jan-2018, 12:40:12
    Author     : CS_admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataSource.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
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
        <div>
            <!--% User ppp = (User) session.getAttribute("LoggedIn");%-->
            <%
                String username = null;
                int userId = 0;
                if (session.getAttribute("LoggedIn") == null || session.getAttribute("user_Id")==null)
                  {
                    response.sendRedirect("Signup.jsp");
                  } else
                  {
                    username = (String) session.getAttribute("username");
                    userId = (int) session.getAttribute("user_Id");
                  session.setAttribute("userId", userId);
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
        </div>
        <form action="Controller" method="POST" id="learnerReg" class="modal-content animate">
            <input type="hidden" name="action" value="RegisterLearner"/>
            <div class="imgcontainer">
                    <strong>Learner Registration</strong>
            </div>
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
                                      }%>
            <p style="color: #b5ff5e"><%=request.getAttribute("Successmsg") == null ? "" : request.getAttribute("Successmsg")%></p>
            <div class="container">
                <strong>Personal Details:</strong>
                    <p><input type="text" placeholder="Student Number..." oninput="this.className = ''" name="l_number" required></p>
                    <p><input type="text" placeholder="Grade No..." oninput="this.className = ''" name="grade" required></p>
                    <p><input type="text" placeholder="Class Stream" oninput="this.className = ''" name="stream" required></p>
                <strong>School Info:</strong>
                <p><input type="text" placeholder="School Name..." oninput="this.className = ''" name="school_name" required></p>
                <p><input type="text" placeholder="City Address..." oninput="this.className = ''" name="school_address" required></p>
                <p><input type="text" placeholder="City Name..." oninput="this.className = ''" name="school_town" required></p>
                <p><select name="school_province" oninput="this.className = ''" required>
                        <option>Western Cape</option>
                        <option>Eastern Cape</option>
                        <option>Northern Cape</option>
                        <option>Kwa Zulu Natal</option>
                        <option>Free State</option>
                        <option>Mpumalanga</option>
                        <option>Gauteng</option>
                        <option>Limpopo</option>
                        <option>North West</option>
                    </select>
                </p>
                <button type="submit" name="submit" form="learnerReg">Add Learner</button>
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <button type="reset" form="learnerReg" class="cancelbtn">Cancel</button>
            </div>
        </form>
    </body>
</html>