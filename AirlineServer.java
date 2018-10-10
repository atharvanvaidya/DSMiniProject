
import java.net.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class AirlineServer{
  public static void main(String args[]){
    try{
        System.setProperty("java.rmi.server.hostname","192.168.43.141");
      // create an instance of the Server object to export
      AirlineImpl arlnServer = new AirlineImpl();
      Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
      
      Naming.rebind("AirlineServer", arlnServer);

      /* airlineServ is the name under which the server registers itself in the RMI registry. */
      System.out.println("Server Ready");
    } // End of try block

    catch (RemoteException RemotExcp){
      RemotExcp.printStackTrace();
      System.exit(0);
    }

    catch (Exception excp){
      System.out.println("Error: " + excp.getMessage());
      System.exit(0);
    }
  }
}
