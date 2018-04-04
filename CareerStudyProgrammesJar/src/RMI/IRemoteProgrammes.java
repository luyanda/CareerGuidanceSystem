/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;


import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CS_admin
 */
public interface IRemoteProgrammes extends java.rmi.Remote
  {
    public ArrayList<Programmes> EPSprogrammes(String word) throws RemoteException,SQLException;
    public ArrayList<Programmes> SPSprogrammes(String word) throws RemoteException,SQLException;
  }
