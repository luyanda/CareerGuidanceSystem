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
public class User
  {

    private int User_UniqueId;
    private String id;
    private String idNumber;
    private String name;
    private String surname;
    private String cell;
    private String email;
    private String password;
    private String username;

    public User(String id)
      {
        this.id = id;
      }

    public User()
      {
      }

    public User(String username, String password)
      {
        this.password = password;
        this.username = username;
      }



    public int getUser_UniqueId()
      {
        return User_UniqueId;
      }

    public void setUser_UniqueId(int User_UniqueId)
      {
        this.User_UniqueId = User_UniqueId;
      }

    public User(int User_UniqueId)
      {
        this.User_UniqueId = User_UniqueId;
      }

    public User(int User_UniqueId, String idNumber, String name, String surname, String cell, String email, String password, String username)
      {
        this.User_UniqueId = User_UniqueId;
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.cell = cell;
        this.email = email;
        this.password = password;
        this.username = username;
      }

    public User(String idNumber, String name, String surname, String cell, String email, String password, String username)
      {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.cell = cell;
        this.email = email;
        this.password = password;
        this.username = username;
      }

    public String getIdNumber()
      {
        return idNumber;
      }

    public void setIdNumber(String idNumber)
      {
        this.idNumber = idNumber;
      }

    public String getUsername()
      {
        return username;
      }

    public void setUsername(String username)
      {
        this.username = username;
      }

    public User(String id, String idNumber, String name, String surname, String cell, String email, String password, String username)
      {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.cell = cell;
        this.email = email;
        this.password = password;
        this.username = username;
      }

    public User(String name, String surname, String cell, String email, String password)
      {
        this.name = name;
        this.surname = surname;
        this.cell = cell;
        this.email = email;
        this.password = password;
      }

    public String getId()
      {
        return id;
      }

    public void setId(String id)
      {
        this.id = id;
      }

    public String getName()
      {
        return name;
      }

    public void setName(String name)
      {
        this.name = name;
      }

    public String getSurname()
      {
        return surname;
      }

    public void setSurname(String surname)
      {
        this.surname = surname;
      }

    public String getCell()
      {
        return cell;
      }

    public void setCell(String cell)
      {
        this.cell = cell;
      }

    public String getEmail()
      {
        return email;
      }

    public void setEmail(String email)
      {
        this.email = email;
      }

    public String getPassword()
      {
        return password;
      }

    public void setPassword(String password)
      {
        this.password = password;
      }

  }
