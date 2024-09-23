public class VehicleFactory {
    public static Motociclo createMotociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        return new Motociclo(matricula, marca, modelo, potencia, tipo);
    }

    public static AutomovelLigeiro createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia, int capacidade_bagageira, String numero_quadro) {
        return new AutomovelLigeiro(matricula, marca, modelo, potencia, capacidade_bagageira, numero_quadro);
    }

    public static Taxi createTaxi(String matricula, String marca, String modelo, int potencia, int capacidade_bagageira, String numero_quadro, int numero_licenca) {
        return new Taxi(matricula, marca, modelo, potencia, capacidade_bagageira, numero_quadro, numero_licenca);
    }

    public static PesadoPassageirosEletrico createPPEletrico(String matricula, String marca, String modelo, int potencia, int capacidade_passageiros, int peso, String numero_quadro, int autonomia) {
        return new PesadoPassageirosEletrico(matricula, marca, modelo, potencia, capacidade_passageiros, peso, numero_quadro, autonomia);
    }

    public static AutomovelLigeiroEletrico createALEletrico(String matricula, String marca, String modelo, int potencia, int capacidade_bagageira, String numero_quadro, int autonomia) {
        return new AutomovelLigeiroEletrico(matricula, marca, modelo, potencia, capacidade_bagageira, numero_quadro, autonomia);
    }

    public static PesadoMercadorias createPesadoMercadorias(String matricula, String marca, String modelo, int potencia, int carga_maxima, int peso, String numero_quadro) {
        return new PesadoMercadorias(matricula, marca, modelo, potencia, carga_maxima, peso, numero_quadro);
    }

    public static PesadoPassageiros createPesadoPassageiros(String matricula, String marca, String modelo, int potencia, int capacidade_passageiros, int peso, String numero_quadro) {
        return new PesadoPassageiros(matricula, marca, modelo, potencia, capacidade_passageiros, peso, numero_quadro);
    }

}

