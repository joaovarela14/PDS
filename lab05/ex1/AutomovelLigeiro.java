
public class AutomovelLigeiro extends Veiculo{
    private int capacidade_bagageira;
    private String numero_quadro;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, int capacidade_bagageira, String numero_quadro) {
        super(matricula, marca, modelo, potencia);
        this.capacidade_bagageira = capacidade_bagageira;
        this.numero_quadro = numero_quadro;
    }


    public int getCapacidade_bagageira() {
        return this.capacidade_bagageira;
    }

    public void setCapacidade_bagageira(int capacidade_bagageira) {
        this.capacidade_bagageira = capacidade_bagageira;
    }

    public String getNumero_quadro() {
        return this.numero_quadro;
    }

    public void setNumero_quadro(String numero_quadro) {
        this.numero_quadro = numero_quadro;
    }

    @Override
    public String toString(){
        return super.toString() + " || Capacidade da bagageira: " + capacidade_bagageira + " || Número do quadro: " + numero_quadro;
    }


}


    

