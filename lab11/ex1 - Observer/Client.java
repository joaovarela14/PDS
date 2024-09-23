
public class Client implements Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String message) {
        System.out.println("Cliente " + name + " received update: " + message);
    }

    public void bid(Product p, double value) {
        p.bid(value);
    }

}
