package hbrs.ooka.system;

public class Buchungssystem {

    private static Buchungssystem instance;

    private PortSuche portSuche;
    private PortCaching portCaching;

    public Buchungssystem() {

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
    public static void start(){
        instance = new Buchungssystem();
    }

    @Stop
    public static void stop(){
        instance.getPortSuche().getHotelSuche().closeSession();
        instance = null;
    }
}
