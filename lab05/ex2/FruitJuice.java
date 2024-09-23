public class FruitJuice extends Food{
    Temperature temperature;
    State state;
    String flavor;

    public FruitJuice(){
        super(Temperature.COLD, State.Liquid);
        this.flavor = "Orange";
    }

    @Override
    public String toString(){
        return this.getClass().getName() + ": " + this.flavor +", Temperature " + super.getTemperature() + ", State " + super.getState();
    }
}