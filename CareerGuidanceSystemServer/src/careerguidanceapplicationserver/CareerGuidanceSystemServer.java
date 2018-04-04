/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package careerguidanceapplicationserver;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author CS_admin
 */
public class CareerGuidanceSystemServer
  {
    private static final String HOST = "localhost";
    static RMICGImpl temp = null;

    public static void main(String[] args) throws Exception
      {
        SecurityManager security = System.getSecurityManager();
        if (security == null)
          {
            security = new SecurityManager();
          }
        try
          {
            temp = new RMICGImpl();
            LocateRegistry.createRegistry(1099);

            String registry = "localhost";
            if (args.length >= 1)
              {
                registry = args[0];
              }
            Naming.rebind("rmi://localhost/IRemoteProgrammes", temp);
            System.out.println("Career Guidance Server is ready!!");
            System.out.println("Running on registry");
            System.out.println(temp.getRef());
            System.out.println(temp.getRef().remoteToString());      
          } catch (Exception ex)
          {
            System.out.println("Error - " + ex.getMessage() + "\n" + ex.getStackTrace());
          }
      }
  }