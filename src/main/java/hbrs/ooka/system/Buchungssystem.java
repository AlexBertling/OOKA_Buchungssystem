package hbrs.ooka.system;

import hbrs.ooka.annotation.Inject;
import hbrs.ooka.annotation.Start;
import hbrs.ooka.annotation.Stop;
import hbrs.ooka.gui.GUI;
import hbrs.ooka.log.Logger;

public class Buchungssystem {

    private PortSuche portSuche;
    private PortCaching portCaching;

    private GUI gui;

    @Inject
    private Logger logger;

    public Buchungssystem() {

        //System.out.println("Buchungssystem initialized....");
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

    public Logger getLogger() {
        return logger;
    }

    @Inject
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Start
    public void start(){
        logger.sendLog("Buchungssystem started...");
        gui = new GUI(this);
        gui.openWindow();

        getPortSuche().getHotelSuche().openSession();

    }

    @Stop
    public void stop(){
        logger.sendLog("Buchungssystem stopped...");
        gui.closeWindow();
    }
}
