public class PassengerShip extends CommonPropertiesShip {

    int max_passageiros;
    public PassengerShip(String code, String name, int max_passageiros){
        super(code, name);
        this.max_passageiros = max_passageiros;
    }
     
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" [code: " +code() + " ,name: " + name() + " ,passengers: " + this.max_passageiros  + "]";
    }
}
