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
public class Subjects
  {
    private int Subject_Id;
    private String Subject_Name1;
    private String subject_Name2;
    private String subject_Name3;
    private String subject_Name4;
    private String subject_Name5;
    private String subject_Name6;
    private String subject_Name7;

    
    public Subjects()
      {
      }

    public Subjects(String Subject_Name1, String subject_Name2, String subject_Name3, String subject_Name4, String subject_Name5, String subject_Name6, String subject_Name7)
      {
        this.Subject_Name1 = Subject_Name1;
        this.subject_Name2 = subject_Name2;
        this.subject_Name3 = subject_Name3;
        this.subject_Name4 = subject_Name4;
        this.subject_Name5 = subject_Name5;
        this.subject_Name6 = subject_Name6;
        this.subject_Name7 = subject_Name7;
      }

    public String getSubject_Name1()
      {
        return Subject_Name1;
      }

    public void setSubject_Name1(String Subject_Name1)
      {
        this.Subject_Name1 = Subject_Name1;
      }

    public String getSubject_Name2()
      {
        return subject_Name2;
      }

    public void setSubject_Name2(String subject_Name2)
      {
        this.subject_Name2 = subject_Name2;
      }

    public String getSubject_Name3()
      {
        return subject_Name3;
      }

    public void setSubject_Name3(String subject_Name3)
      {
        this.subject_Name3 = subject_Name3;
      }

    public String getSubject_Name4()
      {
        return subject_Name4;
      }

    public void setSubject_Name4(String subject_Name4)
      {
        this.subject_Name4 = subject_Name4;
      }

    public String getSubject_Name5()
      {
        return subject_Name5;
      }

    public void setSubject_Name5(String subject_Name5)
      {
        this.subject_Name5 = subject_Name5;
      }

    public String getSubject_Name6()
      {
        return subject_Name6;
      }

    public void setSubject_Name6(String subject_Name6)
      {
        this.subject_Name6 = subject_Name6;
      }

    public String getSubject_Name7()
      {
        return subject_Name7;
      }

    public void setSubject_Name7(String subject_Name7)
      {
        this.subject_Name7 = subject_Name7;
      }

    public Subjects(int Subject_Id, String Subject_Name)
      {
        this.Subject_Id = Subject_Id;
        this.Subject_Name1 = Subject_Name;
      }

    public int getSubject_Id()
      {
        return Subject_Id;
      }

    public void setSubject_Id(int Subject_Id)
      {
        this.Subject_Id = Subject_Id;
      }

    public String getSubject_Name()
      {
        return Subject_Name1;
      }

    public void setSubject_Name(String Subject_Name)
      {
        this.Subject_Name1 = Subject_Name;
      }
    
  }
