package hbrs.ooka.system;

import hbrs.ooka.cache.Caching;
import hbrs.ooka.hotel.HotelRetrieval;
import hbrs.ooka.hotel.HotelRetrievalProxy;

public class Buchungssystem {

    private PortSuche portSuche;
    private PortCaching portCaching;

    public Buchungssystem() {

        this.portSuche = new PortSuche(this);
        this.portCaching = new PortCaching();

    }

    public PortSuche getPortSuche() {
        return portSuche;
    }

    public PortCaching getPortCaching() {
        return portCaching;
    }

    public void setPortCaching(PortCaching portCaching) {
        this.portCaching = portCaching;
    }
}
