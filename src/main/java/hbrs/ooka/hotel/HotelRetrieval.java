package hbrs.ooka.hotel;

import hbrs.ooka.db.DBAccess;
import hbrs.ooka.system.Buchungssystem;

import java.util.ArrayList;
import java.util.List;

public class HotelRetrieval implements Hotelsuche {

    private Buchungssystem system;
    private DBAccess acc;

    public HotelRetrieval(Buchungssystem system) {
        this.system = system;
    }

    @Override
    public List<Hotel> getHotelByName(String name) {
        List<Hotel> hotels = new ArrayList<>();

        List<Object> cachedEntry = this.system.getPortCaching().getCache().getEntry(name);
        if(cachedEntry != null) {
            // Cached Result found
            this.system.getLogger().sendLog("Use cached result...");
            for(Object o : cachedEntry){
                Hotel h = (Hotel) o;
                hotels.add(new Hotel(h.getId(),h.getName(),h.getCity()));
            }
        } else {
            // No Cache existing
            this.system.getLogger().sendLog("No cache, access db...");
            List<String> result = acc.getObjects(DBAccess.HOTEL, name);
            int hotelCount = result.size() / 3;
            for(int i=0; i<hotelCount; i++){
                String id = result.get(i*3);
                String n = result.get(i*3+1);
                String city = result.get(i*3+2);
                hotels.add(new Hotel(id, n, city));
            }
            this.system.getPortCaching().getCache().cacheResult(name, hotels);
        }

        return hotels;
    }

    @Override
    public void openSession() {
        this.acc = new DBAccess();
        this.acc.openConnection();
    }

    @Override
    public void closeSession() {
        if(this.acc != null) acc.closeConnection();
    }

}
