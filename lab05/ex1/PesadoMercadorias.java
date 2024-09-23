
public class PesadoMercadorias extends Veiculo {
    private int carga_maxima , peso;
    private String numero_quadro;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, int carga_maxima, int peso, String numero_quadro) {
        super(matricula, marca, modelo, potencia);
        this.carga_maxima = carga_maxima;
        this.peso = peso;
        this.numero_quadro = numero_quadro;
    }

    public int getCarga_maxima() {
        return this.carga_maxima;
    }

    public void setCarga_maxima(int carga_maxima) {
        this.carga_maxima = carga_maxima;
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
        return super.toString() + " || Carga máxima: " + carga_maxima + " || Peso: " + peso + " || Número do quadro: " + numero_quadro;
    }


    
}
