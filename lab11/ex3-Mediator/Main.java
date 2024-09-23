public class Main {
    public static void main(String[] args) {
        MediatorAircraft mediator = new MediatorAircraft();

        Aircraft aircraft1 = new ConcreteAircraft(mediator, "Aircraft A");
        Aircraft aircraft2 = new ConcreteAircraft(mediator, "Aircraft B");
        Aircraft aircraft3 = new ConcreteAircraft(mediator, "Aircraft C");

        mediator.addAircraft(aircraft1);
        mediator.addAircraft(aircraft2);
        mediator.addAircraft(aircraft3);

        aircraft1.requestLanding();
        aircraft2.requestLanding();
        aircraft3.requestLanding();

        aircraft1.setLanding(false);
        
        aircraft3.requestLanding();
        aircraft2.requestLanding();
    }
}