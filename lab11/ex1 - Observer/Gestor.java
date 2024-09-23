public class Gestor implements Observer {
    private String name;

    public Gestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Gestor " + name + " received update: " + message);
    }
}