import java.rmi.*;
import java.util.*;
public interface AirlineInterface extends Remote
{
	public ArrayList<Flight_details> bookSeat(String dept, String land) throws RemoteException;
        public boolean senddetails(int flightno, int seats) throws RemoteException;
}
