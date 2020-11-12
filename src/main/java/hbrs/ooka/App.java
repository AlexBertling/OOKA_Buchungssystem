package hbrs.ooka;

import hbrs.ooka.system.Buchungssystem;
import hbrs.ooka.system.PortCaching;
import hbrs.ooka.system.PortHotelsuche;

public class App 
{
    public static void main( String[] args )
    {
        Buchungssystem system = new Buchungssystem();

        PortHotelsuche portHotelsuche = system.getPortHotelsuche();
        portHotelsuche.openSession();

        System.out.println(portHotelsuche.getHotelByName("Berg").get(0).getName());

        system.setPortCaching(new PortCaching());

        System.out.println(portHotelsuche.getHotelByName("Berg").get(0).getName());

        System.out.println(portHotelsuche.getHotelByName("Berg").get(0).getName());

        portHotelsuche.closeSession();
    }
}
