/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DataSource.DataAccessLayer;
import DataSource.Learner;
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
@WebServlet(name = "Login", urlPatterns =
  {
    "/Login"
  })
public class Login extends HttpServlet
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
        String username = request.getParameter("User_name");
        String password = request.getParameter("Password");
        String dispatch = "Login.jsp";
        String id = "error";
        RequestDispatcher rd;
        String cell=null;
        User user = null;
        User user_Log = null;
        DataAccessLayer dao = new DataAccessLayer();
                
        int userId = 0;
        ArrayList<String> errorList = new ArrayList<String>();
        try
          {
            if (username == null || username.trim().length() == 0)
              {
                errorList.add("username is required for Login");
              }
            if (password == null || password.trim().length() == 0)
              {
                errorList.add("password is required for Login");
              }

            if (errorList.isEmpty())
              {
                user = new User(username,password);
                user_Log = dao.SignIn(user);

                if (user_Log != null)
                  {
                    HttpSession session = request.getSession();
                    session.setAttribute("LoggedIn", user_Log);
                    session.setMaxInactiveInterval(30*60);
                    
                    Cookie userName = new Cookie("username",user_Log.getUsername());
                    userName.setMaxAge(30*60);
                    dispatch = "Learner.jsp";
                    response.addCookie(userName);
                    response.sendRedirect(dispatch);
                    
                    id = user.getName();
                    cell = user.getCell();
                    request.setAttribute("Successmsg", "Welcome "+id);
                  } else
                  {
                    errorList.add("invalid password or username");
                    dispatch = "Login.jsp";
                    request.setAttribute("error", errorList);
                    request.setAttribute("id", cell);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
