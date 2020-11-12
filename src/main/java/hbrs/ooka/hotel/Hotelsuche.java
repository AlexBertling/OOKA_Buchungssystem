package hbrs.ooka.hotel;

import java.util.List;

public interface Hotelsuche {

    List<Hotel> getHotelByName(String name);

    void openSession();

    void closeSession();
}
