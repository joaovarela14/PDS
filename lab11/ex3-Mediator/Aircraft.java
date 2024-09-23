import java.util.*;

public abstract class Aircraft {

    private int id;
    private String name;
    MediatorAircraft mediator;
    private boolean landing;

    public Aircraft (String name, MediatorAircraft mediator){
        this.mediator = mediator;
        this.name = name;
        this.id = id++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void requestLanding();
    public abstract void land();


    public boolean isLanding() {
        return landing;
    }

    protected void setLanding(boolean landing) {
        this.landing = landing;
    }
}
