package hbrs.ooka.system;

import hbrs.ooka.annotation.Start;
import hbrs.ooka.annotation.Stop;
import hbrs.ooka.gui.GUI;

public class Buchungssystem {

    private PortSuche portSuche;
    private PortCaching portCaching;

    private GUI gui;

    public Buchungssystem() {

        System.out.println("Buchungssystem initialized....");
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

    @Start
    public void start(){
        System.out.println("Buchungssystem started...");
        gui = new GUI(this);
        gui.openWindow();

        getPortSuche().getHotelSuche().openSession();

    }

    @Stop
    public void stop(){
        System.out.println("Buchungssystem stopped...");
        gui.closeWindow();
    }
}
