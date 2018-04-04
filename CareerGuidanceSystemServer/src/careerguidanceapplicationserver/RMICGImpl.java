/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package careerguidanceapplicationserver;

import RMI.Programmes;
import RMI.IRemoteProgrammes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CS_admin
 */
public class RMICGImpl extends UnicastRemoteObject implements IRemoteProgrammes
  {

    static DAO dao = null;

    static
      {
        dao = new DAO();
      }

    private static ArrayList<Programmes> programme;

    
    public RMICGImpl(ArrayList<Programmes> program) throws RemoteException
      {
        super(0);
        programme = program;
      }

    public RMICGImpl() throws RemoteException
      {
        super(0);
      }

    @Override
    public ArrayList<Programmes> EPSprogrammes(String word) throws RemoteException
      {
        try
          {
            programme = dao.EPSprogrammes(word);
          } catch (SQLException e)
          {
            Logger.getLogger(RMICGImpl.class.getName()).log(Level.SEVERE, null, e);
          } catch (Exception ex)
          {
            Logger.getLogger(RMICGImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        return programme;
      }

    public ArrayList<Programmes> SPSprogrammes(String word) throws RemoteException
      {
        try
          {
            programme = dao.SPSprogrammes(word);
          } catch (SQLException e)
          {
            Logger.getLogger(RMICGImpl.class.getName()).log(Level.SEVERE, null, e);
          } catch (Exception ex)
          {
            Logger.getLogger(RMICGImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        return programme;
      }

  }
