/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DataSource.DataAccessLayer;
import DataSource.Learner;
import DataSource.Subjects;
import DataSource.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CS_admin
 */
@WebServlet(name = "ProfileUpdate", urlPatterns =
  {
    "/ProfileUpdate"
  })
public class ProfileUpdate extends HttpServlet
  {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception
      {
        String email = request.getParameter("email");
        String cell = request.getParameter("cell");

        String stud_num = request.getParameter("stud_num");
        String grade = request.getParameter("grade");
        String stream = request.getParameter("stream");

        String dispatch = "LearnerProfile.jsp";
        RequestDispatcher rd = null;
        DataAccessLayer Dao = new DataAccessLayer();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("LoggedIn");
        Learner learner = null;
        Learner user_Log = null;

        ArrayList<String> errorList = new ArrayList<String>();
        try
          {
            if (email == null || email.trim().length() == 0)
              {
                errorList.add("Email is required");
              }
            if (cell == null || cell.trim().length() == 0)
              {
                errorList.add("Cell Number is required");
              }
            if (stud_num == null || stud_num.trim().length() == 0)
              {
                errorList.add("Student Number is required");
              }
            if (stream == null || stream.trim().length() == 0)
              {
                errorList.add("Class Name is required");
              }
            if (grade == null || grade.trim().length() == 0)
              {
                errorList.add("Class Name is required");
              }

            if (errorList.isEmpty())
              {
                learner.setCell(cell);
                learner.setEmail(email);
                learner.setLearner_Number(stud_num);
                learner.setLearner_Grade(grade);
                learner.setLearner_Class(stream);
                System.out.println(learner.getEmail());
                System.out.println(learner.getLearner_Number());
                System.out.println(learner.getLearner_Grade());

                user_Log = Dao.Update_Profile(learner);

                if (user_Log != null)
                  {

                    session.setAttribute("user_Id", user_Log);
                    session.setAttribute("LoggedIn", user_Log);
                    session.setMaxInactiveInterval(30 * 60);

                    Cookie userName = new Cookie("username", user_Log.getUsername());
                    userName.setMaxAge(30 * 60);
                    dispatch = "Profile.jsp";
                    response.addCookie(userName);
                    response.sendRedirect(dispatch);
                  } else
                  {
                    errorList.add("Not Updated, Please try again later");
                    dispatch = "LearnerProfile.jsp";
                    request.setAttribute("error", errorList);
                  }
              }

          } finally
          {
          }
        rd = request.getRequestDispatcher(dispatch);
        rd.forward(request, response);
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        try
          {
            processRequest(request, response);
          } catch (Exception ex)
          {
            Logger.getLogger(ProfileUpdate.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        try
          {
            processRequest(request, response);
          } catch (Exception ex)
          {
            Logger.getLogger(ProfileUpdate.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
      {
        return "Short description";
      }// </editor-fold>

  }
