package hbrs.ooka;

import hbrs.ooka.hotel.Hotel;
import hbrs.ooka.hotel.Hotelsuche;
import hbrs.ooka.system.Buchungssystem;
import hbrs.ooka.system.PortCaching;
import hbrs.ooka.hotel.HotelRetrievalProxy;
import hbrs.ooka.system.PortSuche;

public class App 
{
    public static void main( String[] args )
    {
        Buchungssystem system = new Buchungssystem();

        PortSuche portSuche = system.getPortSuche();
        Hotelsuche hotelsuche = portSuche.getHotelSuche();
        hotelsuche.openSession();

        System.out.println(hotelsuche.getHotelByName("Berg").get(0).getName());

        system.setPortCaching(new PortCaching());

        System.out.println(hotelsuche.getHotelByName("Berg").get(0).getName());

        System.out.println(hotelsuche.getHotelByName("Berg").get(0).getName());

        hotelsuche.closeSession();
    }
}
