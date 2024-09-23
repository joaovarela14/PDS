import java.util.*;

public class Caixa extends Produto{
    private String name;
    private double weight;
    private List<Produto> produtos = new ArrayList<Produto>();
    private double totalWeight = 0;

    public Caixa(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public double getweight() {
        double totalWeight = weight;
        for (Produto produto : produtos) {
            totalWeight += produto.getweight();
        }
        return totalWeight;
    }

    public void draw(){
        System.out.println(impressao.toString() + toString());
        impressao.append("  ");
        for (Produto produto : produtos) {
            produto.draw();
        }
        impressao.delete(impressao.length() - 2, impressao.length());
    }

    @Override
    public String toString() {
        return "* Caixa '" + name + "' - weight: " + getweight();
    }


    
}
