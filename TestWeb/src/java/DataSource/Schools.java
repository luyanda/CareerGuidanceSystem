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
public class Schools
  {
    private int School_Id;
    private String School_Name;
    private String School_Address;
    private String School_Town;
    private String School_Province;

    public String getSchool_Town()
      {
        return School_Town;
      }

    public void setSchool_Town(String School_Town)
      {
        this.School_Town = School_Town;
      }

    public String getSchool_Province()
      {
        return School_Province;
      }

    public void setSchool_Province(String School_Province)
      {
        this.School_Province = School_Province;
      }

    public Schools(String School_Name, String School_Address, String School_Town, String School_Province)
      {
        this.School_Name = School_Name;
        this.School_Address = School_Address;
        this.School_Town = School_Town;
        this.School_Province = School_Province;
      }

    public Schools(int School_Id, String School_Name, String School_Address, String School_Town, String School_Province)
      {
        this.School_Id = School_Id;
        this.School_Name = School_Name;
        this.School_Address = School_Address;
        this.School_Town = School_Town;
        this.School_Province = School_Province;
      }

    public Schools()
      {
      }

    public Schools(int School_Id, String School_Name, String School_Address, String School_Location)
      {
        this.School_Id = School_Id;
        this.School_Name = School_Name;
        this.School_Address = School_Address;
        this.School_Town = School_Location;
      }

    public int getSchool_Id()
      {
        return School_Id;
      }

    public void setSchool_Id(int School_Id)
      {
        this.School_Id = School_Id;
      }

    public String getSchool_Name()
      {
        return School_Name;
      }

    public void setSchool_Name(String School_Name)
      {
        this.School_Name = School_Name;
      }

    public String getSchool_Address()
      {
        return School_Address;
      }

    public void setSchool_Address(String School_Address)
      {
        this.School_Address = School_Address;
      }

    public String getSchool_Location()
      {
        return School_Town;
      }

    public void setSchool_Location(String School_Location)
      {
        this.School_Town = School_Location;
      }
    
  }
