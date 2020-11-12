package hbrs.ooka.system;

import hbrs.ooka.db.DBAccess;
import hbrs.ooka.hotel.Hotel;
import hbrs.ooka.hotel.HotelRetrieval;
import hbrs.ooka.hotel.Hotelsuche;

import java.util.List;
import java.util.logging.Logger;

public class PortHotelsuche implements Hotelsuche {

    private HotelRetrieval hotelRetrieval;
    private Logger logger;

    public PortHotelsuche(HotelRetrieval hotelRetrieval) {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.info("Hotel Retrieval connected to port.");
        this.hotelRetrieval = hotelRetrieval;
    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        logger.info("Search Hotel-Db by Query: " + name);
        return this.hotelRetrieval.getHotelByName(name);
    }

    @Override
    public void openSession() {
        logger.info("Open session to Hotel-Db");
        this.hotelRetrieval.openSession();
    }

    @Override
    public void closeSession() {
        logger.info("Close session to Hotel-Db");
        this.hotelRetrieval.closeSession();
    }
}
