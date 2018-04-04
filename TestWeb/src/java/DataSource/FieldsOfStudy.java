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
public class FieldsOfStudy
  {
    private int Field_UniqueId;
    private String Field_Id;
    private String Institution_Id;
    private String Field_Name;

    public FieldsOfStudy()
      {
      }

    public int getField_UniqueId()
      {
        return Field_UniqueId;
      }

    public void setField_UniqueId(int Field_UniqueId)
      {
        this.Field_UniqueId = Field_UniqueId;
      }

    public FieldsOfStudy(int Field_UniqueId, String Institution_Id, String Field_Name)
      {
        this.Field_UniqueId = Field_UniqueId;
        this.Institution_Id = Institution_Id;
        this.Field_Name = Field_Name;
      }

    public FieldsOfStudy(int Field_UniqueId)
      {
        this.Field_UniqueId = Field_UniqueId;
      }

    public FieldsOfStudy(String Field_Id, String Institution_Id, String Field_Name)
      {
        this.Field_Id = Field_Id;
        this.Institution_Id = Institution_Id;
        this.Field_Name = Field_Name;
      }

    public String getField_Id()
      {
        return Field_Id;
      }

    public void setField_Id(String Field_Id)
      {
        this.Field_Id = Field_Id;
      }

    public String getInstitution_Id()
      {
        return Institution_Id;
      }

    public void setInstitution_Id(String Institution_Id)
      {
        this.Institution_Id = Institution_Id;
      }

    public String getField_Name()
      {
        return Field_Name;
      }

    public void setField_Name(String Field_Name)
      {
        this.Field_Name = Field_Name;
      }
    
  }
