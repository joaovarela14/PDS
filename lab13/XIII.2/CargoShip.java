public class CargoShip  extends CommonPropertiesShip {

    double carga;

    public CargoShip(String code, String name, double carga){
        super(code, name);
        this.carga = carga;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName()+" [code: " +code() + " ,name: "
        + name() + " ,cargo: " + this.carga + "]";
    }
}
