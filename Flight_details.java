
import java.io.Serializable;
import java.sql.Time;

class Flight_details implements Serializable
{
    String Airline;
    Time DeptTime,ArrTime;
    int flight_no,seats;
    Flight_details(String Airline,Time DeptTime,Time ArrTime,int flight_no,int seats)
    {
        this.Airline=Airline;
        this.DeptTime=DeptTime;
        this.ArrTime=ArrTime;
        this.flight_no=flight_no;
        this.seats=seats;
        
    }
    String getAirline()
    {
        return this.Airline;
    }
    Time getDeptTime()
    {
        return this.DeptTime;
    }
    Time getArrTime()
    {
        return this.ArrTime;
    }
    int getflight_no()
    {
        return this.flight_no;
    }
    int getseats()
    {
        return this.seats;
    }
}
