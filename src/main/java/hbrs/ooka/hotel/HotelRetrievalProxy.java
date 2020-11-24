package hbrs.ooka.hotel;

import hbrs.ooka.db.DBAccess;
import hbrs.ooka.hotel.Hotel;
import hbrs.ooka.hotel.HotelRetrieval;
import hbrs.ooka.hotel.Hotelsuche;
import hbrs.ooka.system.Buchungssystem;

import java.util.List;
import java.util.logging.Logger;

public class HotelRetrievalProxy implements Hotelsuche {

    private Hotelsuche hotelsuche;
    private Logger logger;

    public HotelRetrievalProxy(Buchungssystem system) {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.info("Hotel Retrieval connected to port.");
        this.hotelsuche = new HotelRetrieval(system);
    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        logger.info("Search Hotel-Db by Query: " + name);
        return this.hotelsuche.getHotelByName(name);
    }

    @Override
    public void openSession() {
        logger.info("Open session to Hotel-Db");
        this.hotelsuche.openSession();
    }

    @Override
    public void closeSession() {
        logger.info("Close session to Hotel-Db");
        this.hotelsuche.closeSession();
    }
}
