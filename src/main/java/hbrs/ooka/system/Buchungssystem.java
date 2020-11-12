package hbrs.ooka.system;

import hbrs.ooka.cache.Caching;
import hbrs.ooka.db.DBAccess;
import hbrs.ooka.hotel.Hotel;
import hbrs.ooka.hotel.HotelRetrieval;

import java.util.List;

public class Buchungssystem {

    private HotelRetrieval hotelRetrieval;

    private PortHotelsuche portHotelsuche;
    private Caching portCaching;

    public Buchungssystem() {

        this.hotelRetrieval = new HotelRetrieval(this);
        this.portHotelsuche = new PortHotelsuche(this.hotelRetrieval);

    }

    public PortHotelsuche getPortHotelsuche() {
        return portHotelsuche;
    }

    public Caching getPortCaching() {
        if(portCaching == null){
            return new PortCachingDummy();
        }
        return portCaching;
    }

    public void setPortCaching(PortCaching portCaching) {
        this.portCaching = portCaching;
    }
}
