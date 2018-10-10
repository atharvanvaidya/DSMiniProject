import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirlineImpl extends UnicastRemoteObject implements AirlineInterface, Serializable
{
	Connection conn;
        ArrayList<Flight_details> send=new ArrayList<Flight_details>();
	// Server Constructor
	public AirlineImpl() throws RemoteException, ClassNotFoundException, SQLException
	{
//		super();
		System.out.println("Initializing the Server");
                // Load the Driver
                Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/flightsData";
			// Pass the static fields containing the data source name
			conn = DriverManager.getConnection(url,"root","ragz");
	}

	// The bookSeat() method.
	public ArrayList<Flight_details> bookSeat(String dept, String land)
	{
		int seatdtls=0;
		// System.out.println("Flight is " + FlightNo);

		try
		{
			
			

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

        public boolean senddetails(int flightno,int seats)
        {
            		Statement stmt;
            try {
                stmt = conn.createStatement();
                        ResultSet rs1=stmt.executeQuery("select seats from flights where FlightNo='"+flightno+"'");
                        int fl=0;
                        while(rs1.next())
                        {
                            fl=rs1.getInt("seats");
                        }
                        fl=fl-seats;
			int rs= stmt.executeUpdate("update flights set seats='"+fl+"' where FlightNo='"+flightno+"'");
			if(rs==1)
			{
                              return true;
                              
			}
                        else
                            return false;
                        } catch (SQLException ex) {
                Logger.getLogger(AirlineImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
	// Implement the main() method
} // End of Server class

