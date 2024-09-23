

public class AutomovelLigeiroEletrico extends AutomovelLigeiro implements VeiculoEletrico{
    int autonomia;

    public AutomovelLigeiroEletrico(String matricula, String marca, String modelo, int potencia, int capacidade_bagageira, String numero_quadro, int autonomia) {
        super(matricula, marca, modelo, potencia, capacidade_bagageira, numero_quadro);
        this.autonomia = autonomia;
    }

    public int autonomia() {
        return this.autonomia;
    }

    public void carregar(int percentagem) {
        if (percentagem > 100) {
            percentagem = 100;
        }
        else{
            this.autonomia = this.autonomia + percentagem;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " || Autonomia: " + this.autonomia + "km";
    }

}
