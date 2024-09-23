public class Taxi extends AutomovelLigeiro {
    int numero_licenca;

    public Taxi(String matricula, String marca, String modelo, int potencia, int capacidade_bagageira, String numero_quadro, int numero_licenca) {
        super(matricula, marca, modelo, potencia, capacidade_bagageira, numero_quadro);
        this.numero_licenca = numero_licenca;
    }

    public int getNumero_licenca() {
        return this.numero_licenca;
    }

    public void setNumero_licenca(int numero_licenca) {
        this.numero_licenca = numero_licenca;
    }

    @Override
    public String toString(){
        return super.toString() + " || Número de licença: " + numero_licenca;
    }

}
