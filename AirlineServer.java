import java.net.*;
import java.rmi.*;

public class AirlineServer{
  public static void main(String args[]){
    try{
      // create an instance of the Server object to export
      AirlineImpl arlnServer = new AirlineImpl();
      Naming.rebind("AirlineServer", arlnServer);

      /* airlineServ is the name under which the server registers itself in the RMI registry. */
      System.out.println("Server Ready");
    } // End of try block

    catch (RemoteException RemotExcp){
      System.out.println("Remote Server Error: " + RemotExcp.getMessage());
      System.exit(0);
    }

    catch (Exception excp){
      System.out.println("Error: " + excp.getMessage());
      System.exit(0);
    }
  }
}
