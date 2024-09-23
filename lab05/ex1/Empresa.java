import java.util.ArrayList;

public class Empresa {
    String nome , codigo_postal, email;
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Empresa(String nome, String codigo_postal, String email) {
        this.nome = nome;
        this.codigo_postal = codigo_postal;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo_postal() {
        return this.codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }

    public Veiculo maiorDist(){
        if (veiculos.size() == 0) {
            System.out.println("Não existem veiculos");
            return null;
        }

        Veiculo maior = veiculos.get(0);
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getDistanciatotal() > maior.getDistanciatotal()) {
                maior = veiculo;
            }
        }

        return maior;
    }

    @Override
    public String toString(){
        return "Organizacao: " + this.getClass().getSimpleName() + " | Nome: " + nome + " | Codigo Postal: " +  codigo_postal + " | Email: " + email;
    }

}