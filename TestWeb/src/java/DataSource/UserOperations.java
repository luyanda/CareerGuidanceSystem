/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CS_admin
 */
public interface UserOperations
  {
   
    public User SignIn(User user) throws SQLException, Exception;//String Username, String Password
    public User SignUp( User user, Learner learner, Schools schools) throws SQLException, Exception;//String Name, String Surname, String Password, int Id, String CellNumber
    public Learner GetProfile(int user) throws SQLException, Exception;
    public Learner Update_Profile(Learner learner) throws SQLException, Exception;
    public User SignLearnerUp(User user, Learner learner, Schools schools, Subjects subject) throws SQLException, Exception;
  }
