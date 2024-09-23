public class ConcreteAircraft extends Aircraft{
    public ConcreteAircraft(MediatorAircraft mediator, String name){
        super(name, mediator);
    }

    @Override
    public void requestLanding() {
        System.out.println(this.getName() + " is requesting landing.");
        mediator.SendRequest(this);
    }

    @Override
    public void land() {
        System.out.println(this.getName() + " is landing.");
        this.setLanding(true);
    }

    
}
