package hbrs.ooka.system;

import hbrs.ooka.cache.Caching;
import hbrs.ooka.hotel.HotelRetrieval;
import hbrs.ooka.hotel.HotelRetrievalProxy;

public class Buchungssystem {

    private PortSuche portSuche;
    private Caching portCaching;

    public Buchungssystem() {

        this.portSuche = new PortSuche(this);

    }

    public PortSuche getPortSuche() {
        return portSuche;
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
