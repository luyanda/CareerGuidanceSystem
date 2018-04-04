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
public class Mark
  {
    private int UserId;
    private String SubjectId;
    private int FirstQuoter;
    private int SecondQuoter;
    private int ThirdQuoter;
    private String Status;

    public Mark()
      {
      }

    public Mark(int UserId, String SubjectId, int FirstQuoter, int SecondQuoter, int ThirdQuoter, String Status)
      {
        this.UserId = UserId;
        this.SubjectId = SubjectId;
        this.FirstQuoter = FirstQuoter;
        this.SecondQuoter = SecondQuoter;
        this.ThirdQuoter = ThirdQuoter;
        this.Status = Status;
      }

    public int getUserId()
      {
        return UserId;
      }

    public void setUserId(int UserId)
      {
        this.UserId = UserId;
      }

    public String getSubjectId()
      {
        return SubjectId;
      }

    public void setSubjectId(String SubjectId)
      {
        this.SubjectId = SubjectId;
      }

    public int getFirstQuoter()
      {
        return FirstQuoter;
      }

    public void setFirstQuoter(int FirstQuoter)
      {
        this.FirstQuoter = FirstQuoter;
      }

    public int getSecondQuoter()
      {
        return SecondQuoter;
      }

    public void setSecondQuoter(int SecondQuoter)
      {
        this.SecondQuoter = SecondQuoter;
      }

    public int getThirdQuoter()
      {
        return ThirdQuoter;
      }

    public void setThirdQuoter(int ThirdQuoter)
      {
        this.ThirdQuoter = ThirdQuoter;
      }

    public String getStatus()
      {
        return Status;
      }

    public void setStatus(String Status)
      {
        this.Status = Status;
      }
    
  }
