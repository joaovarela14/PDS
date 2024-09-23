public class Main { 
    public static void main(String[] args) { 
 
        Empresa r = new Empresa("Rental", "1234-567", "a@ua.pt"); 
        r.addVeiculo(VehicleFactory.createMotociclo("00-AB-12", "Honda", "CBR 600", 100, "desportivo")); 
        r.addVeiculo(VehicleFactory.createAutomovelLigeiro("12DA23", "Nissan", "GTR", 450, 20, "123123123"));
        r.addVeiculo(VehicleFactory.createTaxi("986G23", "Mercedes", "AMG", 234, 35, "384573", 123)); 
        r.addVeiculo(VehicleFactory.createPPEletrico("12DA23", "Nissan", "GTR", 450, 20, 5000, "123123123", 100));
        r.addVeiculo(VehicleFactory.createALEletrico("12DA23", "Nissan", "GTR", 450, 20, "123123123", 100));
        r.addVeiculo(VehicleFactory.createPesadoMercadorias("65HS43", "seat", "altea XL", 90, 50, 5000, "1623gas62")); 
        r.addVeiculo(VehicleFactory.createPesadoPassageiros("23TA23", "Kawaki", "Nia", 100, 50, 5000, "fawwfa2r2r"));
 
        for(Veiculo v : r.getVeiculos()){ 
            System.out.println(v); 
        } 
    } 
} 