

public class PesadoPassageiros extends Veiculo{
    private int capacidade_passageiros , peso;
    private String numero_quadro;


    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, int capacidade_passageiros, int peso, String numero_quadro) {
        super(matricula, marca, modelo, potencia);
        this.capacidade_passageiros = capacidade_passageiros;
        this.peso = peso;
        this.numero_quadro = numero_quadro;
    }

    public int getCapacidade_passageiros() {
        return this.capacidade_passageiros;
    }

    public void setCapacidade_passageiros(int capacidade_passageiros) {
        this.capacidade_passageiros = capacidade_passageiros;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNumero_quadro() {
        return this.numero_quadro;
    }

    public void setNumero_quadro(String numero_quadro) {
        this.numero_quadro = numero_quadro;
    }

    @Override
    public String toString(){
        return super.toString() + " || Capacidade máxima de passageiros: " + capacidade_passageiros + " || Peso: " + peso + " || Número do quadro: " + numero_quadro;
    }
    
}
