import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.sql.*;

public class AirlineImpl extends UnicastRemoteObject implements AirlineInterface, Serializable
{
	Connection conn;
        ArrayList<Flight_details> send=new ArrayList<Flight_details>();
	// Server Constructor
	public AirlineImpl() throws RemoteException
	{
		super();
		System.out.println("Initializing the Server");
	}

	// The bookSeat() method.
	public ArrayList<Flight_details> bookSeat(String dept, String land)
	{
		int seatdtls=0;
		// System.out.println("Flight is " + FlightNo);

		try
		{
			// Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flightsData";
			// Pass the static fields containing the data source name
			conn = DriverManager.getConnection(url,"root","ragz");

			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("Select * from Flights where TakeOff ='" +dept+ "' and Land = '"+land+"'");
			while (rs.next())
			{
                              
                              send.add(new Flight_details(rs.getString("Airline"),rs.getTime("DeptTime"),rs.getTime("ArrTime"),rs.getInt("FlightNo"),rs.getInt("seats")));
			}
     
		}

		catch(Exception excp) {
			excp.printStackTrace();
    }

		return send;
	}  //End of bookSeat() method

	// Implement the main() method
} // End of Server class

