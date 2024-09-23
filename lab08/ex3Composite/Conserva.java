
public class Conserva extends Produto{
    private String name;
    private int weight;

    public Conserva(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getweight() {
        return weight;
    }

    public void draw(){
        System.out.println(impressao.toString() + toString());
    }

    @Override
    public String toString() {
        return "Conserva '" + name + "' - weight: " + weight;
    }
}
