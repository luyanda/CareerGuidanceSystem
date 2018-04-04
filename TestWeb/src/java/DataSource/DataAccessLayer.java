/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author CS_admin
 */
public class DataAccessLayer implements UserOperations
  {
        public DataAccessLayer()
      {
      }

    private DataSource getDataSource() throws Exception
      {
        InitialContext cont = new InitialContext();
        if (cont == null)
          {
            throw new Exception("Bhuti your DataSource is on subscriber....");
          }
        DataSource source = (DataSource) cont.lookup("java:/comp/env/jdbc/careerappBC");
        if (source == null)
          {
            throw new Exception("your source not available");
          }
        return source;
      }

    private Connection getConnection() throws SQLException, Exception
      {
        Connection conn = getDataSource().getConnection();
        return conn;
      }

    private void closeDBResource(ResultSet rs, PreparedStatement st, Connection con) throws SQLException
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
        if (con != null)
          {
            con.close();
            con = null;
          }
      }
    
        @Override
    public User SignUp( User user, Learner learner, Schools school) throws SQLException, Exception
      {
        User user_Log = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        String query = "{call addUser(?,?,?,?,?,?,?)}";
        try
          {
            conn = getConnection();
            cs = conn.prepareCall(query);
            cs.setString(1, user.getIdNumber());
            cs.setString(2, user.getName());
            cs.setString(3, user.getSurname());
            cs.setString(4, user.getEmail());
            cs.setString(5, user.getCell());
            cs.setString(6, user.getUsername());
            cs.setString(7, user.getPassword());
            
            cs.executeQuery();
            rs = cs.getResultSet();
            if (rs.next())
              {
                user_Log = new User();
                user_Log.setUser_UniqueId(rs.getInt(1));
                user_Log.setIdNumber(rs.getString(2));
                user_Log.setName(rs.getString(3));
                user_Log.setSurname(rs.getString(4));
                user_Log.setEmail(rs.getString(5));
                user_Log.setCell(rs.getString(6));
                user_Log.setUsername(rs.getString(7));
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
        return user_Log;
      }

    @Override
    public User SignIn(User user) throws SQLException, Exception
      {
        boolean status = false;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        User user_Log = null;
        String query = "{call Signin(?,?)}";
        try
          {
            conn = this.getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, user.getUsername());
            cs.setString(2, user.getPassword());
             
            cs.executeQuery();
            rs = cs.getResultSet();
            if (rs.next())
              {
            user_Log = new User();
            user_Log.setUser_UniqueId(rs.getInt(1));
            user_Log.setName(rs.getString(2));
            user_Log.setSurname(rs.getString(3));
            user_Log.setEmail(rs.getString(4));
            user_Log.setUsername(rs.getString(5));
            user_Log.setCell(rs.getString(6));
          }
          }
        catch(SQLException e)
          {
              System.out.println(e.getStackTrace());
          }
        finally
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
        return user_Log;
      }

    @Override
    public Learner GetProfile(int user) throws SQLException, Exception
      {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        User user_Log = null;
        Learner learner_Log = null;
        String query = "{call getUserProfile(?)}";

        try
          {
            conn = this.getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, user);
            
            cs.executeQuery();
            rs = cs.getResultSet();
            if (rs.next())
              {
                learner_Log = new Learner();
                        
                learner_Log.setId(rs.getString(1));
                learner_Log.setName(rs.getString(2));
                learner_Log.setSurname(rs.getString(3));
                learner_Log.setEmail(rs.getString(4));
                learner_Log.setCell(rs.getString(5));
                learner_Log.setUsername(rs.getString(6));
                
                learner_Log.setLearner_Number(rs.getString(7));
                learner_Log.setLearner_Grade(rs.getString(8));
                learner_Log.setLearner_Class(rs.getString(9));
               
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
        return learner_Log;
      }

    @Override
    public Learner Update_Profile(Learner learner) throws SQLException, Exception
      {
        Connection conn = null;
        CallableStatement cs = null;
        Learner learner_Log = null;
        ResultSet rs = null;
        String query = "{call updateUser(?,?,?,?,?,?)}";
        
        try
          {
            conn = this.getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, learner.getUser_UniqueId());
            cs.setString(2, learner.getEmail());
            cs.setString(3, learner.getCell());
            cs.setString(4, learner.getLearner_Number());
            cs.setString(5, learner.getLearner_Grade());
            cs.setString(6, learner.getLearner_Class());
                    
            cs.executeQuery();
            rs = cs.getResultSet();
            if(rs.next())
              {
                learner_Log = (Learner) new User();
                        
                learner_Log.setId(rs.getString(1));
                learner_Log.setName(rs.getString(2));
                learner_Log.setSurname(rs.getString(3));
                learner_Log.setEmail(rs.getString(4));
                learner_Log.setCell(rs.getString(5));
                learner_Log.setUsername(rs.getString(6));
                
                learner_Log.setLearner_Number(rs.getString(7));
                learner_Log.setLearner_Grade(rs.getString(8));
                learner_Log.setLearner_Class(rs.getString(9));
               }
          }catch (SQLException e)
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
        return learner_Log;
      }

    @Override
    public User SignLearnerUp(User user, Learner learner, Schools schools, Subjects subject) throws SQLException, Exception
      {
        User user_Log = null;
        Learner learner_Log = null;
        Schools schools_Log = null;
        Subjects subject_Log = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        String query = "{call SignLearnerUp(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try
          {
            conn = getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, user.getUser_UniqueId());
            cs.setString(2, learner.getLearner_Number());
            cs.setString(3, learner.getLearner_Grade());
            cs.setString(4, learner.getLearner_Class());
            cs.setString(5, schools.getSchool_Name());
            cs.setString(6, schools.getSchool_Address());
            cs.setString(7, schools.getSchool_Town());
            cs.setString(8, schools.getSchool_Province());
            cs.setString(9, subject.getSubject_Name1());
            cs.setString(10, subject.getSubject_Name2());
            cs.setString(11, subject.getSubject_Name3());
            cs.setString(12, subject.getSubject_Name4());
            cs.setString(13, subject.getSubject_Name5());
            cs.setString(14, subject.getSubject_Name6());
            cs.setString(15, subject.getSubject_Name7());
            
            cs.executeQuery();
            rs = cs.getResultSet();
            if (rs.next())
              {
                user_Log = new User();
                learner_Log = new Learner();
                schools_Log = new Schools();
                
                user_Log.setUser_UniqueId(rs.getInt(1));
                user_Log.setIdNumber(rs.getString(2));
                user_Log.setName(rs.getString(3));
                user_Log.setSurname(rs.getString(4));
                user_Log.setEmail(rs.getString(5));
                user_Log.setCell(rs.getString(6));
                user_Log.setUsername(rs.getString(7));
                user_Log.setPassword(rs.getString(8));
                
                learner_Log.setLearner_Number(rs.getString(9));
                learner_Log.setLearner_Grade(rs.getString(10));
                learner_Log.setLearner_Class(rs.getString(11));
                
                schools_Log.setSchool_Name(rs.getString(12));
                schools_Log.setSchool_Address(rs.getString(13));
                schools_Log.setSchool_Town(rs.getString(14));
                schools_Log.setSchool_Province(rs.getString(15));
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
        return user_Log;
      }

  }
