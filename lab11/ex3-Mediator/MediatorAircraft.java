
import java.util.*;

public class MediatorAircraft {

    private List<Aircraft> aircrafts;

    public MediatorAircraft() {
        this.aircrafts = new ArrayList<Aircraft>();
    }


    
    public void addAircraft(Aircraft a){
        this.aircrafts.add(a);
    }

    public MediatorAircraft getMediator(){
        return this;
    }

    public void SendRequest(Aircraft aircraft){

        for (Aircraft a : aircrafts) {
            if (a != aircraft && a.isLanding()) {
                System.out.println("Landing request denied for " + aircraft.getName() + ". " + a.getName() + " is currently landing.");
                return;
            }
        }
        System.out.println("Landing request approved for " + aircraft.getName() + ".");
        aircraft.land();
        
    }
}
