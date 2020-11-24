package hbrs.ooka.system;

import hbrs.ooka.hotel.HotelRetrievalProxy;
import hbrs.ooka.hotel.Hotelsuche;

public class PortSuche {

    private Buchungssystem buchungssystem;
    private Hotelsuche hotelsuche;

    public PortSuche(Buchungssystem buchungssystem) {
        this.buchungssystem = buchungssystem;
    }

    public Hotelsuche getHotelSuche() {
        if(hotelsuche == null) {
            hotelsuche = new HotelRetrievalProxy(this.buchungssystem);
        }
        return hotelsuche;
    }

}
