

public class PesadoPassageirosEletrico extends PesadoPassageiros implements VeiculoEletrico {
    int autonomia;

    public PesadoPassageirosEletrico(String matricula, String marca, String modelo, int potencia, int capacidade_passageiros, int peso, String numero_quadro, int autonomia) {
        super(matricula, marca, modelo, potencia, capacidade_passageiros, peso, numero_quadro);
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
    
    
}
