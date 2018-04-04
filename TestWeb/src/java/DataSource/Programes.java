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
public class Programes
  {
    private int Programe_Id;
    private String Programe_Name;
    private String Programe_Title;
    private String Programe_Duration;
    private String Programe_APS;

    public Programes()
      {
      }

    public Programes(int Programe_Id, String Programe_Name, String Programe_Title, String Programe_Duration, String Programe_APS)
      {
        this.Programe_Id = Programe_Id;
        this.Programe_Name = Programe_Name;
        this.Programe_Title = Programe_Title;
        this.Programe_Duration = Programe_Duration;
        this.Programe_APS = Programe_APS;
      }

    public int getPrograme_Id()
      {
        return Programe_Id;
      }

    public void setPrograme_Id(int Programe_Id)
      {
        this.Programe_Id = Programe_Id;
      }

    public String getPrograme_Name()
      {
        return Programe_Name;
      }

    public void setPrograme_Name(String Programe_Name)
      {
        this.Programe_Name = Programe_Name;
      }

    public String getPrograme_Title()
      {
        return Programe_Title;
      }

    public void setPrograme_Title(String Programe_Title)
      {
        this.Programe_Title = Programe_Title;
      }

    public String getPrograme_Duration()
      {
        return Programe_Duration;
      }

    public void setPrograme_Duration(String Programe_Duration)
      {
        this.Programe_Duration = Programe_Duration;
      }

    public String getPrograme_APS()
      {
        return Programe_APS;
      }

    public void setPrograme_APS(String Programe_APS)
      {
        this.Programe_APS = Programe_APS;
      }
    
  }
