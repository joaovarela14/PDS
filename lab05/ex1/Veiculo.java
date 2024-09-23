

public class Veiculo implements KmPercorridosInterface {
    private String matricula, marca, modelo;
    private int potencia;
    private int ultimotrajeto;
    private int distanciatotal = 0;

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getUltimotrajeto() {
        return this.ultimotrajeto;
    }

    public void setUltimotrajeto(int ultimotrajeto) {
        this.ultimotrajeto = ultimotrajeto;
    }

    public int getDistanciatotal() {
        return this.distanciatotal;
    }

    public void setDistanciatotal(int distanciatotal) {
        this.distanciatotal = distanciatotal;
    }

    public void trajeto(int quilometros) {
        this.ultimotrajeto = quilometros;
        this.distanciatotal += quilometros;
    }

    public int ultimoTrajeto() {
        System.out.println("Ultimo trajeto: " + this.ultimotrajeto+"km");
        return this.ultimotrajeto;
       
    }

    public int distanciaTotal() {
        System.out.println("Distancia total: " + this.distanciatotal+"km");
        return this.distanciatotal;
    }

    @Override
    public String toString(){
        return "\nTipo: " + this.getClass().getSimpleName() + " || Matricula: " + matricula + " || Marca: " + marca + " || Modelo: " + modelo + " || Potencia: " + potencia; 
    }
}



    

