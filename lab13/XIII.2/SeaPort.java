import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SeaPort implements Port {
    private List<Ship> ships; 
    private HashMap<Ship,String> relation_RefShip;
    
    public SeaPort() {
        ships = new ArrayList<>();
        relation_RefShip = new HashMap<>();
    }

    public boolean add(String ref, Ship p){
        if (exists(ref)){
            remove(ref);
        }
        ships.add(p);
        relation_RefShip.put(p,ref);
        return true;
    }

	public boolean exists(String ref){
        for (Ship ship : ships){
            if(ship.code().equals(ref)){
                return true;
            }
        }
        return false;
    }

	public Ship remove(String ref){
        for (Ship ship : ships){
            if(ship.code().equals(ref)){
                ships.remove(ship);
                return ship;
            }
        }
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private final Iterator<Ship> shipIterator = ships.iterator();

            @Override
            public boolean hasNext() {
                return shipIterator.hasNext();
            }

            @Override
            public String next() {
                Ship currentShip = shipIterator.next();
                return "Ref: " + relation_RefShip.get(currentShip) + " - " + currentShip.toString();
            }
        };
    }

}
