/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DataSource.DataAccessLayer;
import DataSource.Learner;
import DataSource.Schools;
import DataSource.Subjects;
import DataSource.User;
import java.io.IOException;
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
@WebServlet(name = "SignUp", urlPatterns =
  {
    "/SignUp"
  })
public class SignUp extends HttpServlet
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
        String name = request.getParameter("f_name");
        String surname = request.getParameter("l_name");
        String id_number = request.getParameter("id_number");
        String email = request.getParameter("email");
        String cell = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        String l_number = request.getParameter("l_number");
        String grade = request.getParameter("grade");
        String stream = request.getParameter("stream");

        String subject1 = request.getParameter("subject1");
        String subject2 = request.getParameter("subject2");
        String subject3 = request.getParameter("subject3");
        String subject4 = request.getParameter("subject4");
        String subject5 = request.getParameter("subject5");
        String subject6 = request.getParameter("subject6");
        String subject7 = request.getParameter("subject7");

        String school_name = request.getParameter("school_name");
        String school_address = request.getParameter("school_address");
        String school_town = request.getParameter("school_town");
        String school_province = request.getParameter("school_province");

        String dispatch = "Signup.jsp";
        RequestDispatcher rd = null;
        DataAccessLayer Dao = new DataAccessLayer();
        User user = null;
        Subjects subject = null;
        Learner learner = null;
        Schools schools = null;
        User user_Log = null;
        Boolean status = false;

        ArrayList<String> errorList = new ArrayList<String>();
        try
          {
            if (name == null || name.trim().length() == 0)
              {
                errorList.add("name is required for SignUp");
              }
            if (surname == null || surname.trim().length() == 0)
              {
                errorList.add("surname is required for SignUp");
              }
            if (id_number == null || id_number.trim().length() == 0)
              {
                errorList.add("ID Number is required for SignUp");
              }
            if (email == null || email.trim().length() == 0)
              {
                errorList.add("email is required for email");
              }
            if (cell == null || cell.trim().length() == 0)
              {
                errorList.add("Phone Number is required for SignUp");
              }
            if (username == null || username.trim().length() == 0)
              {
                errorList.add("Username is required for SignUp");
              }
            if (password == null || password.trim().length() == 0)
              {
                errorList.add("password is required for SignUp");
              }
            if (confirm_password == null || confirm_password.trim().length() == 0)
              {
                errorList.add("Valid Confirma Password not the same");
              }
            if (confirm_password.trim().length() != password.trim().length())
              {
                errorList.add("Confirm password and Password Not the same");
              }
            if (subject1 == null || subject1.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (subject2 == null || subject2.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (subject3 == null || subject3.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (subject4 == null || subject4.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (subject5 == null || subject5.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (subject6 == null || subject6.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (subject7 == null || subject7.trim().length() == 0)
              {
                errorList.add("Subject Name Missing");
              }
            if (l_number == null || l_number.trim().length() == 0)
              {
                errorList.add("Student No is required for Registration");
              }
            if (grade == null || grade.trim().length() == 0)
              {
                errorList.add("Grade No is required for Registration");
              }
            if (stream == null || stream.trim().length() == 0)
              {
                errorList.add("class is required for Registration");
              }
            if (school_name == null || school_name.trim().length() == 0)
              {
                errorList.add("School Nane is required for Registration");
              }
            if (school_address == null || school_address.trim().length() == 0)
              {
                errorList.add("School Address is required for Registration");
              }
            if (school_town == null || school_town.trim().length() == 0)
              {
                errorList.add("School Town is required for Registration");
              }
            if (school_province == null || school_province.trim().length() == 0)
              {
                errorList.add("School Province is required for Registration");
              }
            if (errorList.isEmpty())
              {
                user = new User(id_number, name, surname, cell, email, password, username);
                learner = new Learner(l_number, grade, stream);
                subject = new Subjects(subject1,subject2,subject3,subject4,subject5,subject6,subject7);
                schools = new Schools(school_name, school_address, school_town, school_province);
                user_Log = Dao.SignUp(user, learner, schools);
                if (user_Log != null)
                  {
                    Dao.SignLearnerUp(user_Log, learner, schools,subject);

                    HttpSession session = request.getSession();
                    System.out.println("User ID from DB Is" + user_Log.getUser_UniqueId());
                    session.setAttribute("user_Id", user_Log.getUser_UniqueId());
                    session.setAttribute("LoggedIn", user_Log);
                    session.setMaxInactiveInterval(30 * 60);

                    Cookie userName = new Cookie("username", user_Log.getUsername());
                    userName.setMaxAge(30 * 60);
                    dispatch = "Learner.jsp";
                    response.addCookie(userName);
                    response.sendRedirect(dispatch);

                    request.setAttribute("Successmsg", "Welcome ");
                    request.setAttribute("id", user_Log.getUser_UniqueId());
                  } else
                  {
                    errorList.add("User Not Signed Up, Please try again");
                    dispatch = "Signup.jsp";
                    request.setAttribute("error", errorList);
                    request.setAttribute("name", name);
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
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
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
