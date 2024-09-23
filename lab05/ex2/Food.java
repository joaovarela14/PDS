public class Food implements Portion{
    Temperature temperature;
    State state;

    public Food(Temperature temperature, State state){
        this.temperature = temperature;
        this.state = state;
    }

    public Temperature getTemperature(){
        return this.temperature;
    }

    public State getState(){
        return this.state;
    }

    public String toString(){ //fazer to string geral
        return this.getClass().getName() + ": Temperature " + this.temperature + ", State " + this.state;
    }
    
}
