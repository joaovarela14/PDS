import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("------Alinea a)------");

        Employee e1 = new Employee("Joao", 1, 1000);
        Employee e2 = new Employee("Carolina", 2, 2000);
        
        Empregado e3 = new Empregado("Joao", "Varela", 32, 10000);
        Empregado e4 = new Empregado("Carolina", "Prata", 45, 2000);

        Database bd = new Database();
        Registos registos = new Registos();


        bd.addEmployee(e1);
        bd.addEmployee(e2);

        registos.insere(e4);

        bd.deleteEmployee(2);
        

        // remover um empregado do registo se
        if(registos.isEmpregado(3)) {
            System.out.println("Empregado 3 existe nos registos");

        } else {
            System.out.println("Empregado 3 não existe nos registos, adicionando...");
            registos.insere(e3);
        }

        // listar todos os empregados
        List<Empregado> empregados = registos.listaDeEmpregados();

        for (Empregado empregado : empregados) {
            System.out.println("Registos: " + empregado.nome() + " - Código: " + empregado.codigo() + " - Salário:" + empregado.salario() + "$");
        }

        Employee[] empregados2 = bd.getAllEmployees();

        for (int i = 0; i < empregados2.length; i++) {
            System.out.println("BD: " + empregados2[i].getName() + " - Código: " + empregados2[i].getEmpNum() + " - Salário: " + empregados2[i].getSalary() + "$");
        }

        System.out.println("\n------Alinea b)------");

        Adapter bdAdapter = new DatabaseAdapter(bd);
        Adapter registAdapter = new RegistosAdapter(registos);

        SweetPetiscosADP spdatabase = new SweetPetiscosADP(bdAdapter, registAdapter);


        spdatabase.addEmpregado(new Employee("Joaozinho", 10, 1000));
        spdatabase.addEmpregado(new Employee("Carolina", 11, 2000));
        spdatabase.addEmpregado(new Employee("António", 12, 1000));

        System.out.println("\nLista de empregados: ");

        if (spdatabase.isEmpregado(10)) {
            System.out.println("Empregado 10 existe");
        } else {
            System.out.println("Empregado 10 não existe");
        }

        if (spdatabase.isEmpregado(999999)) {
            System.out.println("Empregado 99999 existe");
        } else {
            System.out.println("Empregado 99999 não existe");
        }

        
        spdatabase.removeEmpregado(10);
        System.out.println("--Removendo empregado 10--");

        if (spdatabase.isEmpregado(10)) {
            System.out.println("Empregado 10 existe");
        } else {
            System.out.println("Empregado 10 não existe");
        }

        System.err.println("\nLista de empregados (Após remoção): ");

        spdatabase.getAll();


    }    
}