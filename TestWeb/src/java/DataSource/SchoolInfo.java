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
public class SchoolInfo
  {
    private String SchoolId;
    private String Name;
    private String Address;
    private String Town;
    private String Province;

    public SchoolInfo(String SchoolId, String Name, String Address, String Town, String Province)
      {
        this.SchoolId = SchoolId;
        this.Name = Name;
        this.Address = Address;
        this.Town = Town;
        this.Province = Province;
      }

    public String getSchoolId()
      {
        return SchoolId;
      }

    public void setSchoolId(String SchoolId)
      {
        this.SchoolId = SchoolId;
      }

    public String getName()
      {
        return Name;
      }

    public void setName(String Name)
      {
        this.Name = Name;
      }

    public String getAddress()
      {
        return Address;
      }

    public void setAddress(String Address)
      {
        this.Address = Address;
      }

    public String getTown()
      {
        return Town;
      }

    public void setTown(String Town)
      {
        this.Town = Town;
      }

    public String getProvince()
      {
        return Province;
      }

    public void setProvince(String Province)
      {
        this.Province = Province;
      }
  }
