package hbrs.ooka.hotel;

import hbrs.ooka.log.Logger;
import hbrs.ooka.log.LoggerFactory;
import hbrs.ooka.system.Buchungssystem;

import java.util.List;

public class HotelRetrievalProxy implements Hotelsuche {

    private Hotelsuche hotelsuche;
    private Logger logger;

    public HotelRetrievalProxy(Buchungssystem system) {
        logger = LoggerFactory.createLogger();
        logger.sendLog("Hotel Retrieval connected to port.");
        this.hotelsuche = new HotelRetrieval(system);
    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        logger.sendLog("Search Hotel-Db by Query: " + name);
        return this.hotelsuche.getHotelByName(name);
    }

    @Override
    public void openSession() {
        logger.sendLog("Open session to Hotel-Db");
        this.hotelsuche.openSession();
    }

    @Override
    public void closeSession() {
        logger.sendLog("Close session to Hotel-Db");
        this.hotelsuche.closeSession();
    }
}
