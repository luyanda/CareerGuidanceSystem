/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package careerguidanceapplicationserver;

import RMI.Programmes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CS_admin
 */
public class DAO
  {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String username = "root"; //use your username given
    private String password = "root"; // password may be different

    public DAO()
      {
        try
          {
            Class<?> forName = Class.forName(driver);
          } catch (ClassNotFoundException ex)
          {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    /**
     * Getting a connection to the database
     *
     * @return
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException
      {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
      }

    /**
     * Closing database resources
     */
    private void closeResources(ResultSet rs, PreparedStatement st, Connection conn) throws SQLException
      {
        if (rs != null)
          {
            rs.close();
            rs = null;
          }
        if (st != null)
          {
            st.close();
            st = null;
          }
        if (conn != null)
          {
            conn.close();
            conn = null;
          }
      }

    public ArrayList<Programmes> SPSprogrammes(String word) throws SQLException, Exception
      {
        ArrayList<Programmes> list = new ArrayList<>();
        boolean status = false;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Programmes p = null;
        String query = "{call getSPSProgrammes(?)}";
        try
          {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, word);

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next())
              {
                p = new Programmes();

                p.setName(rs.getString(1));
                p.setTitle(rs.getString(2));
                p.setAps(rs.getString(3));
                p.setInstitution(rs.getString(4));
                p.setSubjects(rs.getString(5));
                p.setDuration(rs.getString(6));
                p.setCarees(rs.getString(7));
                list.add(p);
              }

          } catch (SQLException e)
          {
            System.out.println(e.getStackTrace());
          } finally
          {
            if (cs != null)
              {
                cs.close();
              }
            if (conn != null)
              {
                conn.close();
              }
          }
        return list;
      }

    public ArrayList<Programmes> EPSprogrammes(String word) throws SQLException, Exception
      {
        ArrayList<Programmes> list = new ArrayList<Programmes>();
        boolean status = false;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Programmes p = null;
        String query = "{call getEPSProgrammes(?)}";
        try
          {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, word);
            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next())
              {
                p = new Programmes();

                p.setName(rs.getString(1));
                p.setTitle(rs.getString(2));
                p.setAps(rs.getString(3));
                p.setInstitution(rs.getString(4));
                p.setSubjects(rs.getString(5));
                p.setDuration(rs.getString(6));
                p.setCarees(rs.getString(7));
                list.add(p);
              }

          } catch (SQLException e)
          {
            System.out.println(e.getStackTrace());
          } finally
          {
            if (cs != null)
              {
                cs.close();
              }
            if (conn != null)
              {
                conn.close();
              }
          }
        return list;
      }

  }
