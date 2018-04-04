<%-- 
    Document   : Learner
    Created on : 23-Mar-2017, 12:49:50
    Author     : CS_admin
--%>

<%@page import="DataSource.User"%>
<!--%@include file="checkLogin.jsp"%-->
<%@page import="DataSource.Programmes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataSource.Functions"%>
<%@page import="DataSource.DAO"%>

<!--past here-->
<html>
    <head>
        <title>Career Guidance Application</title>
    </head>
    <body>

        <!--past here-->
        <div>
            <!--% User ppp = (User) session.getAttribute("LoggedIn");%-->
            <%String username = null;
                if (session.getAttribute("username") == null)
                  {
                    response.sendRedirect("Home.jsp");
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
        </div>
        <h2>Welcome <%= userName%>
            <%if (request.getAttribute("Successmsg") != null)
                  {
                    String text = (String) request.getAttribute("Successmsg");
            %>
            <%=text%>
            <%  }
            %> 
        </h2>

        <div class="content">
            <div class="image_wrapper image_fl"><a rel="nofollow" href="#"><img src="images/read.gif" alt="Image" /></a><span></span></div>
            <p><em>Experts say that studying in a group can be more effective than studying alone. Students say it can be more fun, too! Here are a few tips for organising a study group.</em></p>
            <p><a rel="nofollow" href="#" target="_parent">Group:</a> It often works best to have just three to five people in a study group. That way, each person gets the time to talk and make sure she understands the material</p>
            <p>take the time to discuss "why" questions. For example, Why do monarch butterflies migrate? .</p>
            <div class="cleaner h30"></div>
            <div class="col_w340 float_l">
                <h3>Study Tips</h3>
                <ul class="tmo_list">
                    <li>STUDY EVERY DAY</li>
                    <li>DISCOVER YOUR STUDY STYLE</li>
                    <li>REVIEW AND REVISE</li>
                    <li>CONSULT YOUR TEACHER</li>
                    <li>COME UP WITH YOUR OWN STRATEGIES</li>
                    <li>PUSH YOURSELF TO THE LIMIT</li>
                </ul>
            </div>
            <div class="col_w340 float_r">
                <h3>Career Chasing</h3>
                <blockquote>
                    <p>Career Chasing gives you the opportunity to set your goal career study programme and help execute it throughout the year. We provide proper support for you to succeed.</p>
                    <cite>LM - <span>Chief Editor</span></cite></blockquote>
            </div>

            <div class="cleaner"></div>
        </div>

        <div class="content_bottom content_cb"><a href="#header" class="gototop">Go To Top</a></div>
    </div> 

    <div id="careeChasing" class="content_top"></div>
    <div class="content_box">
        <div class="content_title content_ct"><h2>Career Chasing</h2></div>
        <div class="content">
            <!--past here-->
            <div class="image_wrapper image_fr"><a rel="nofollow" href="#learner"><img src="images/grad.jpg" alt="Image" /></a><span></span></div>
            <p><em>CAREER CHASING OPTIONS</em></p>
            <!--past here-->
            <p>Mauris aliquam facilisis ante vitae pulvinar. Suspendisse neque dui, rutrum at est et, fringilla sodales erat. Cras ullamcorper, sem a ultrices suscipit, nunc orci vehicula lacus, vitae hendrerit tellus dolor dictum velit. </p>
            <p>Etiam sagittis, quam non suscipit condimentum, sapien eros semper tortor, ac aliquam urna diam vitae neque. Mauris eros mi, bibendum vel massa vitae, lacinia viverra odio.</p>
            <div class="cleaner h30"></div>
            <div class="col_w340 float_l">
                <h3>Specialized Team</h3>
                <form method="post" action="controller">
                    <input type="hidden" name="action" value="signup"/>
                    <ul class="tmo_list">
                        <li>Select 1st Field of study: 
                            <select name="fieldOfStudy">
                                <option>
                                    -- Select --
                                </option>
                                <%
                                    Functions f = new DAO();
                                    ArrayList<Programmes> list = f.GetFieldOfStudy();
                                    //Programmes pp = null;
                                    String choice = "Military";
                                    for (Programmes pp : list)
                                      {
                                %>
                                <option value="<%=pp.getName()%>"/>
                                <%=pp.getName()%>
                                </option>
                                <%
                                        //choice = pp.getName();
                                      }
                                    choice = request.getParameter("fieldOfStudy");
                                %>
                            </select>
                        </li>
                        <li>
                        <option>
                            -- Select --                                          
                        </option>
                        <%
                            Functions function = new DAO();
                            //ArrayList<Programmes> list = function.SPSprogrammes(fieldOfStudy);
%>
                        <option>
                            <%%>                                          
                        </option>
                        </li>
                        <li><%=choice%></li>
                        <li>Ut tristique sagittis arcu, vel laoreet turpis</li>
                    </ul>
                </form>
            </div>
            <div class="col_w340 float_r">
                <h3>Testimonial</h3>
                <blockquote>
                    <p>Suspendisse fringilla ornare arcu, in malesuada nulla ultrices eu. Aenean eros neque, sollicitudin quis dolor gravida, adipiscing accumsan lorem. Suspendisse elementum pretium nibh, a molestie enim tempor et.</p>
                    <cite>George - <span> Marketing Officer</span></cite></blockquote>

            </div>

            <div class="cleaner"></div>
        </div>

        <div class="content_bottom content_cb"><a href="#templatemo_header" class="gototop">Go To Top</a></div>
    </div>  

    <div id="careeChasing" class="content_top"></div>
    <div class="content_box">
        <div class="content_title content_ct"><h2>Career Chasing</h2></div>
        <div class="content">

            <div class="image_wrapper image_fr"><a rel="nofollow" href="#learner"><img src="images/grad.jpg" alt="Image" /></a><span></span></div>
            <p><em>CAREER CHASING OPTIONS</em></p>
            <!--past here-->
            <p>Mauris aliquam facilisis ante vitae pulvinar. Suspendisse neque dui, rutrum at est et, fringilla sodales erat. Cras ullamcorper, sem a ultrices suscipit, nunc orci vehicula lacus, vitae hendrerit tellus dolor dictum velit. </p>
            <p>Etiam sagittis, quam non suscipit condimentum, sapien eros semper tortor, ac aliquam urna diam vitae neque. Mauris eros mi, bibendum vel massa vitae, lacinia viverra odio.</p>
            <div class="cleaner h30"></div>
            <div class="col_w340 float_l">
                <h3>Specialized Team</h3>
                <ul class="tmo_list">
                    <li>Nulla facilisi. Maecenas ac odio ipsum donec cursus</li>
                    <li>Fusce risus tortor, interdum in malesuada pulvinar</li>
                    <li>Proin facilisis ullamcorper turpis, in placerat</li>
                    <li>Sed vel justo quis ligula blandit commodo molestie</li>
                    <li>Ut tristique sagittis arcu, vel laoreet turpis</li>
                </ul>
            </div>
            <div class="col_w340 float_r">
                <h3>Testimonial</h3>
                <blockquote>
                    <p>Suspendisse fringilla ornare arcu, in malesuada nulla ultrices eu. Aenean eros neque, sollicitudin quis dolor gravida, adipiscing accumsan lorem. Suspendisse elementum pretium nibh, a molestie enim tempor et.</p>
                    <cite>George - <span> Marketing Officer</span></cite></blockquote>

            </div>

            <div class="cleaner"></div>
        </div>

        <div class="content_bottom content_cb"><a href="#templatemo_header" class="gototop">Go To Top</a></div>
    </div>         

    <div id="news" class="content_top"></div>
    <div class="content_box">
        <div class="content_title content_ct"><h2> Blog Posts</h2></div>
        <div class="content">
            <p>Nullam a tortor est, congue fermentum nisi. Maecenas nulla nulla, lobortis eu volutpat euismod, scelerisque ut dui. Integer luctus tellus ac mi malesuada dignissim. Sed id diam dui. In ut nunc urna.</p>
            <div class="cleaner h30"></div>
            <div class="post_box float_l">
                <div class="image_fr"><span></span><img src="images/templatemo_image_07.jpg" alt="Image 3" /></div>
                <p class="post_meta"><span class="cat">Posted in <a href="#">Media</a>, <a href="#">Advertising</a></span> | <a href="#">Comment - 512</a></p>
                <h3>Donec consectetur auctor quam</h3>
                <p>Aliquam tincidunt neque quis blandit dapibus. Integer sed pretium urna, in interdum metus. Nulla facilisi. Proin fermentum viverra sem viverra dignissim. <a href="#">more...</a></p>
                <div class="cleaner"></div>
            </div>

            <div class="post_box float_r">
                <div class="image_fr"><span></span><img src="images/templatemo_image_08.jpg" alt="Image 4" /></div>
                <p class="post_meta"><span class="cat">Posted in <a href="#">Design</a>, <a href="#">Printing</a></span> | <a href="#">Comment - 256</a></p>
                <h3>Sed sollicitudin vitae mi vel tincidunt</h3>
                <p>Mauris quis lobortis augue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc eget neque purus. <a href="#">more...</a></p>
                <div class="cleaner"></div>
            </div>

            <div class="cleaner"></div>

            <div class="post_box float_l">
                <div class="image_fr"><span></span><img src="images/templatemo_image_05.jpg" alt="Image 5" /></div>
                <p class="post_meta"><span class="cat">Posted in <a href="#">Website</a>, <a href="#">Layout</a></span> | <a href="#">Comment - 128</a></p>
                <h3>Phasellus eget pellentesque dui</h3>
                <p>Suspendisse rutrum laoreet orci, nec porta elit porttitor eu. Nulla tincidunt augue in vestibulum tempor. Proin eget ipsum vel orci tristique interdum a eu mi. <a href="#">more...</a></p>
                <div class="cleaner"></div>
            </div>

            <div class="post_box float_r">
                <div class="image_fr"><span></span><img src="images/templatemo_image_06.jpg" alt="Image 6" /></div>
                <p class="post_meta"><span class="cat">Posted in <a href="#">Templates</a>, <a href="#">Freebies</a></span> | <a href="#">Comment - 64</a></p>
                <h3>Quisque cursus eget augue in vestibulum</h3>
                <p>Vestibulum adipiscing tempus elit eu condimentum. Fusce at mi felis. Etiam sed velit nibh. Nunc bibendum justo nec eros elementum auctor. <a href="#">more...</a></p>
                <div class="cleaner"></div>
            </div>

            <div class="cleaner"></div>

        </div>

        <div class="content_bottom content_cb"><a href="#templatemo_header" class="gototop">Go To Top</a></div>
    </div>   

    <div id="portfolio" class="content_top"></div>
    <div class="content_box">
        <div class="content_title content_ct"><h2>Portfolio</h2></div>
        <div class="content">

            <div class="cleaner"></div>
            <p>This section is featuring a collection of <a rel="nofollow" href="http://www.templatemo.com">high quality templates</a>. Nullam a tortor est, congue fermentum nisi. Maecenas nulla nulla, lobortis eu volutpat euismod, scelerisque ut dui. Integer luctus tellus ac mi malesuada dignissim. Sed id diam dui. In ut nunc urna.</p>
            <div class="cleaner h30"></div>
            <div id="gallery">
                <ul>
                    <li class="float_l"><a rel="nofollow" href="http://www.templatemo.com/page/1" title="1"><span></span><img src="images/gallery/image_01_s.jpg" alt="Image 1" /></a></li>
                    <li class="float_r"><a rel="nofollow" href="http://www.templatemo.com/page/2" title="2"><span></span><img src="images/gallery/image_02_s.jpg" alt="Image 2" /></a></li>
                    <li class="float_l"><a rel="nofollow" href="http://www.templatemo.com/page/3" title="3"><span></span><img src="images/gallery/image_03_s.jpg" alt="Image 3" /></a></li>
                    <li class="float_r"><a rel="nofollow" href="http://www.templatemo.com/page/4" title="4"><span></span><img src="images/gallery/image_04_s.jpg" alt="Image 4" /></a></li>
                    <li class="float_l"><a rel="nofollow" href="http://www.templatemo.com/page/5" title="5"><span></span><img src="images/gallery/image_05_s.jpg" alt="Image 5" /></a></li>
                    <li class="float_r"><a rel="nofollow" href="http://www.templatemo.com/page/6" title="6"><span></span><img src="images/gallery/image_06_s.jpg" alt="Image 6" /></a></li>
                </ul>
            </div>

            <div class="cleaner"></div>
        </div>

        <div class="content_bottom content_cb"><a href="#templatemo_header" class="gototop">Go To Top</a></div>
    </div> 

    <div id="contactus" class="content_top"></div>
    <div class="content_box">
        <div class="content_title content_ct"><h2>Social Circle </h2><h4>Sharing innovative ideas</h4></div>
        <div class="content">

            <p>Nam vitae lectus sodales, condimentum metus nec, tempus massa. Sed at ullamcorper risus. Quisque in purus fermentum, gravida tortor id, suscipit risus. Nunc sodales mi at leo facilisis, convallis scelerisque leo convallis.</p>
            <div class="cleaner h30"></div>

            <div class="col_w340 float_l">
                <h4> Contact Form</h4>

                <div id="contact_form">
                    <form method="post" name="contact" action="#contactus">

                        <label for="author">Name:</label> <input type="text" id="author" name="author" class="input_field" />
                        <div class="cleaner h10"></div>

                        <label for="email">Email:</label> <input type="text" id="email" name="email" class="input_field" />
                        <div class="cleaner h10"></div>

                        <label for="text">Message:</label> <textarea id="text" name="text" rows="0" cols="0"></textarea>
                        <div class="cleaner h10"></div>

                        <input type="submit" class="submit_btn float_l" name="submit" id="submit" value="Send" />
                        <input type="reset" class="submit_btn float_r" name="reset" id="reset" value="Reset" />

                    </form>

                </div> 

            </div>

            <div class="col_w340 float_r">
                <h4>Our Location</h4>
                <div class="image_wrapper"><span></span><img src="images/map_thumb.jpg" alt="Maps" /></div>                
                <div class="cleaner h30"></div>

                <h4>Our Address</h4>
                630-180 Aliquam tincidunt neque, <br />
                Suspendisse potenti, 16250<br />
                Etiam ut orci malesuada<br />
            </div>

            <div class="cleaner"></div>
        </div>

        <div class="content_bottom content_cbf"><a href="#templatemo_header" class="gototop">Go To Top</a></div>
    </div> 


<div id="templatemo_footer">

    Copyright © 2072 Your Company Name<br /> 
    <!-- Credit: www.templatemo.com -->

    <div class="cleaner"></div>
</div>

</body>
</html>

