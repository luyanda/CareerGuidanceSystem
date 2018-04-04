/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

/**
 *
 * @author CS_admin
 */
public class Learner extends User
  {
    private int Learner_UniqueId;
    private String Learner_id;
    private String Learner_Number;
    private String Learner_Grade;
    private String Learner_Class;

    
    public int getLearner_UniqueId()
      {
        return Learner_UniqueId;
      }

    public void setLearner_UniqueId(int Learner_UniqueId)
      {
        this.Learner_UniqueId = Learner_UniqueId;
      }

    public Learner(int Learner_UniqueId, String Learner_Number, String Learner_Grade, String Learner_Class)
      {
        this.Learner_UniqueId = Learner_UniqueId;
        this.Learner_Number = Learner_Number;
        this.Learner_Grade = Learner_Grade;
        this.Learner_Class = Learner_Class;
      }

    public Learner(int Learner_UniqueId)
      {
        this.Learner_UniqueId = Learner_UniqueId;
      }
    
    public Learner()
      {
      }

    public Learner( String Learner_Number, String Learner_Grade, String Learner_Class)
      {
        this.Learner_Number = Learner_Number;
        this.Learner_Grade = Learner_Grade;
        this.Learner_Class = Learner_Class;
      }

    public String getLearner_id()
      {
        return Learner_id;
      }

    public void setLearner_id(String Learner_id)
      {
        this.Learner_id = Learner_id;
      }

    public String getLearner_Number()
      {
        return Learner_Number;
      }

    public void setLearner_Number(String Learner_Number)
      {
        this.Learner_Number = Learner_Number;
      }

    public String getLearner_Grade()
      {
        return Learner_Grade;
      }

    public void setLearner_Grade(String Learner_Grade)
      {
        this.Learner_Grade = Learner_Grade;
      }

    public String getLearner_Class()
      {
        return Learner_Class;
      }

    public void setLearner_Class(String Learner_Class)
      {
        this.Learner_Class = Learner_Class;
      }
    
  }
