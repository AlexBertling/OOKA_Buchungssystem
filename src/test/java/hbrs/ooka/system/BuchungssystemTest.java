package hbrs.ooka.system;

import hbrs.ooka.cache.Caching;
import hbrs.ooka.hotel.Hotel;
import hbrs.ooka.hotel.Hotelsuche;
import hbrs.ooka.log.LoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuchungssystemTest {

    private Buchungssystem buchungssystem;

    @BeforeEach
    void setUp() {
        buchungssystem = new Buchungssystem();
        buchungssystem.setLogger(LoggerFactory.createLogger());
    }

    @AfterEach
    void tearDown() {
        buchungssystem.getPortSuche().getHotelSuche().closeSession();
        buchungssystem = null;
    }

    Hotelsuche getHotelSuche(){
        PortSuche portSuche = buchungssystem.getPortSuche();
        return portSuche.getHotelSuche();
    }

    @Test
    void testSession(){
        Hotelsuche hotelsuche = getHotelSuche();
        assertNotNull(hotelsuche);
        hotelsuche.openSession();
    }

    @Test
    void getHotelByName() {
        Hotelsuche hotelsuche = getHotelSuche();
        assertNotNull(hotelsuche);
        hotelsuche.openSession();
        List<Hotel> hotels = hotelsuche.getHotelByName("Berg");
        assertNotNull(hotels);
        assert hotels.size() > 0;
        String name = hotelsuche.getHotelByName("Berg").get(0).getName();
        assertEquals(name, "Berg Hotel");
    }

    @Test
    void getHotelByNameWithCache(){
        Hotelsuche hotelsuche = getHotelSuche();
        assertNotNull(hotelsuche);
        buchungssystem.setPortCaching(new PortCaching());
        PortCaching portCaching = buchungssystem.getPortCaching();
        assertNotNull(portCaching);
        Caching cache = portCaching.getCache();
        assertNotNull(cache);
        hotelsuche.openSession();
        List<Hotel> hotels = hotelsuche.getHotelByName("Berg");
        assertNotNull(hotels);
        assert hotels.size() > 0;
        String name = hotelsuche.getHotelByName("Berg").get(0).getName();
        assertEquals(name, "Berg Hotel");
        List<Object> cachedEntries = cache.getEntry("Berg");
        Hotel hotel = (Hotel) cachedEntries.get(0);
        assertEquals("Berg Hotel", hotel.getName());
    }

    @Test
    void useGUI() throws InterruptedException {
        buchungssystem.start();
        Thread.sleep(5000);
        buchungssystem.stop();
    }

}