

public class ex1 {
    public static void main(String[] args) {
        Empresa emp = new Empresa("Stand", "1111-111", "alugo@carros.com");
        AutomovelLigeiro carro = new AutomovelLigeiro("12DA23", "Nissan", "GTR", 450, 20, "123123123");
        Motociclo mota = new Motociclo("23TA23", "Kawasaki", "Ninja", 100, "Sport");
        AutomovelLigeiro taxi = new Taxi("986G23", "Mercedes", "AMG", 234, 35, "384573", 123);
        PesadoMercadorias camiao = new PesadoMercadorias("65HS43", "seat", "altea XL", 90, 50, 5000, "1623gas62");
        PesadoPassageiros autobus = new PesadoPassageiros("23TA23", "Kawaki", "Nia", 100, 50, 5000, "fawwfa2r2r");

        System.out.println("-------Classe Taxi------------");
        System.out.println(taxi);
        
        System.out.println();
        System.out.println("----------Dados Empresa-------------\n");

        emp.addVeiculo(carro);
        emp.addVeiculo(mota);
        emp.addVeiculo(camiao);
        emp.addVeiculo(autobus);
        System.out.println(emp);
        System.out.println(camiao);
        

        mota.trajeto(2000);
        mota.trajeto(7000);
        carro.trajeto(8000);
        carro.trajeto(500);

        System.out.println();

        System.out.println(mota.distanciaTotal());
        System.out.println(mota.ultimoTrajeto());
        System.out.println(carro.distanciaTotal());
        System.out.println(carro.ultimoTrajeto());


        //cria um carro eletrico
        AutomovelLigeiroEletrico carroEletrico = new AutomovelLigeiroEletrico("12DA23", "Nissan", "GTR", 450, 20, "123123123", 100);
        AutomovelLigeiroEletrico carroEletrico1 = new AutomovelLigeiroEletrico("04CJ07", "Audi", "a6", 80, 50, "56168734", 25);
        //cria um camiao eletrico
        PesadoPassageirosEletrico camiaoEletrico = new PesadoPassageirosEletrico("12DA23", "Nissan", "GTR", 450, 20, 5000, "123123123", 100);

        carroEletrico1.carregar(50);
        System.out.println(carroEletrico1);


        System.out.println(emp.maiorDist() + "\nDistância igual a " + emp.maiorDist().distanciaTotal() + "km");

    }
}
