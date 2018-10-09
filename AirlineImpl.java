import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.sql.*;

public class AirlineImpl extends UnicastRemoteObject implements AirlineInterface
{
	Connection conn;

	// Server Constructor
	public AirlineImpl() throws RemoteException
	{
		super();
		System.out.println("Initializing the Server");
	}

	// The bookSeat() method.
	public int bookSeat(String dept, String land)
	{
		int seatdtls=0;
		// System.out.println("Flight is " + FlightNo);

		try
		{
			// Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flightsData";
			// Pass the static fields containing the data source name
			conn = DriverManager.getConnection(url,"root","32232665");

			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("Select Seats from Flights where TakeOff ='" +dept+ "' and Land = '"+land+"'");

			while (rs.next())
			{
				seatdtls = rs.getInt("Seats");
			}
      System.out.println("seats="+seatdtls);
		}

		catch(Exception excp) {
			excp.printStackTrace();
    }

		if (seatdtls > 0 )
			return seatdtls;
		else
			return 0;
	}  //End of bookSeat() method

	// Implement the main() method
} // End of Server class
