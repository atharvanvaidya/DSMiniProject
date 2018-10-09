import java.rmi.*;

public interface AirlineInterface extends Remote
{
	public int bookSeat(String dept, String land) throws RemoteException;
}