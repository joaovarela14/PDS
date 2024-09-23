public class Bebida extends Produto{
    private String name;
    private int weight;

    public Bebida(String name, int weight) {
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
        return "Bebida '" + name + "' - weight: " + weight;}
    
    
}
