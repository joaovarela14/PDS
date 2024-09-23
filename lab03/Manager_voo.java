import java.util.*;
import java.io.*;

public class Manager_voo {
    static File file;

    static int executive_rows = 0;
    static int executive_columns = 0;
    static int turistic_rows = 0;
    static int turistic_columns = 0;

    static int lugares_executive = 0;
    static int lugares_turistic = 0;
    static String class_type;
    static int n_seats;

    static ArrayList<Voo> voos = new ArrayList<Voo>();

    public static boolean file_exists(File file) {
        return file.exists();
    }

    public static void read_file(String filename) throws IOException{
        if (!file_exists(new File(filename))) {
            System.out.println("Ficheiro + " + filename + " não existe");
            return;
        }

        file = new File(filename);
        Scanner sc = new Scanner(file);

        String[] first_line = sc.nextLine().split(" ");

        Plane plane;

        String flight_code = first_line[0].substring(1);

        //veririca se voo ja se encontra na lista
        for (Voo voo : voos) {
            if (voo.getCodigo().equals(flight_code)) {
                System.out.println("Voo já existe");
                sc.close();
                return;
            }
        }


        if (first_line.length == 2) {

            
            turistic_rows = Integer.parseInt(first_line[1].split("x")[0]);

            turistic_columns = Integer.parseInt(first_line[1].split("x")[1]);

            System.out.println("Código de voo " + flight_code + ". Lugares disponíveis: " + 
            turistic_rows * turistic_columns + " em classe Turística.");
            System.out.println("Classe Executiva não disponível neste voo.");
            
            plane = new Plane(turistic_rows, turistic_columns);
            Voo voo = new Voo(flight_code, plane);
            voos.add(voo);
            voo.contains_executive = false;

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                class_type = line[0];
                n_seats = Integer.parseInt(line[1]);
                if (line[0].equals("E")) {
                    voo.addReserva(voo.getAviao().getSeats_Executive(), Integer.parseInt(line[1]), "Executive");
                }
                else{
                    voo.addReserva(voo.getAviao().getSeats_Turistic(), Integer.parseInt(line[1]), "Turistic");
                }
            }
        }
        else{
            turistic_rows = Integer.parseInt(first_line[2].split("x")[0]);

            turistic_columns = Integer.parseInt(first_line[2].split("x")[1]);

            executive_rows = Integer.parseInt(first_line[1].split("x")[0]);

            executive_columns = Integer.parseInt(first_line[1].split("x")[1]);


            System.out.println("Código de voo " + flight_code + ". Lugares disponíveis: " + 
            executive_rows * executive_columns + " em classe Executiva; " + turistic_rows * turistic_columns + " em classe Turística.");
    

            plane = new Plane(turistic_rows, turistic_columns, executive_rows, executive_columns);
            Voo voo = new Voo(flight_code, plane);
            voos.add(voo);
            voo.contains_executive = true;

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                class_type = line[0];
                n_seats = Integer.parseInt(line[1]);
                if (line[0].equals("E")) {
                    voo.addReserva(voo.getAviao().getSeats_Executive(), Integer.parseInt(line[1]), "Executive");
                }
                else{
                    voo.addReserva(voo.getAviao().getSeats_Turistic(), Integer.parseInt(line[1]), "Turistic");
                }
                
            }
        }

        sc.close();


    }

    public static void PrintPlane(String flight_code) {

        System.out.println("Código de voo " + flight_code );

        for (Voo voo : voos) {
            if (voo.getCodigo().equals(flight_code)) {
                //System.out.println("entrei aqui");

                if (voo.ContainsExecutive()) {
                    int[][] turistica = voo.getAviao().getSeats_Turistic();
                    int[][] executiva = voo.getAviao().getSeats_Executive();
                    
                    int numFilasE = executiva.length;
                    int numFilasT = turistica.length;
                    int numFilas = numFilasE + numFilasT;
                    int numBancosFilaMaximo = Math.max(executiva[0].length, turistica[0].length);
                    
                    // Imprime os números das filas
                    for (int i = 1; i <= numFilas; i++) {
                        System.out.print("\t" + i);
                    }
                    System.out.println();
                    
                    // Imprime os assentos
                    for (int banco = 0; banco < numBancosFilaMaximo; banco++) {
                        System.out.print((char)(banco + 65)); // Converte o índice do banco em letra (A, B, C...)
                        for (int fila = 0; fila < numFilas; fila++) {
                            if (fila < numFilasE) { // Se estiver na área executiva
                                if (banco < executiva[fila].length) {
                                    System.out.print("\t" + executiva[fila][banco]);
                                } else {
                                    System.out.print("\t");
                                }
                            } else { // Se estiver na área turística
                                int filaTuristica = fila - numFilasE; // Ajusta o índice da fila para a matriz turística
                                if (banco < turistica[filaTuristica].length) {
                                    System.out.print("\t" + turistica[filaTuristica][banco]);
                                } else {
                                    System.out.print("\t");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                }

                else {
                    int[][] turistica = voo.getAviao().getSeats_Turistic();
                    int numFilasT = turistica.length;
                    int numBancosFilaMaximo = turistica[0].length;

                    // Imprime os números das filas
                    for (int i = 1; i <= numFilasT; i++) {
                        System.out.print("\t" + i);
                    }
                    System.out.println();

                    // Imprime os assentos
                    for (int banco = 0; banco < numBancosFilaMaximo; banco++) {
                        System.out.print((char)(banco + 65)); // Converte o índice do banco em letra (A, B, C...)
                        for (int fila = 0; fila < numFilasT; fila++) {
                            if (banco < turistica[fila].length) {
                                System.out.print("\t" + turistica[fila][banco]);
                            } else {
                                System.out.print("\t");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();


                }
                
            }
        }
    }

    public static void addFlight(String[] new_flight) {
        String flight_code = new_flight[1];

        if (new_flight.length == 3){ // Se o voo não tiver classe executiva
            for ( Voo voo : Manager_voo.voos) {
                if (voo.getCodigo().equals(flight_code)) {
                    System.out.println("Voo já existe");
                    break;
                }
                break;
            }
            int turistic_rows = Integer.parseInt(new_flight[2].split("x")[0]);
            int turistic_columns = Integer.parseInt(new_flight[2].split("x")[1]);
            Plane plane = new Plane(turistic_rows, turistic_columns);
            Voo voo = new Voo(flight_code, plane);
            voos.add(voo);
            
        } 
        else if (new_flight.length == 4) { // Se o voo tiver classe executiva
            for ( Voo voo : Manager_voo.voos) {
                if (voo.getCodigo().equals(flight_code)) {
                    System.out.println("Voo já existe");
                    break;
                }
                break;
            }
            int executive_rows = Integer.parseInt(new_flight[2].split("x")[0]);
            int executive_columns = Integer.parseInt(new_flight[2].split("x")[1]);
            int turistic_rows = Integer.parseInt(new_flight[3].split("x")[0]);
            int turistic_columns = Integer.parseInt(new_flight[3].split("x")[1]);
            Plane plane = new Plane(turistic_rows, turistic_columns, executive_rows, executive_columns);
            Voo voo = new Voo(flight_code, plane);
            voos.add(voo);
        }
        else { // Se o utilizador não inserir o número de lugares ou classes a mais
            System.out.println("Opção inválida, tente novamente.");
        }
    }


    public static void adicionar_reserva(String flight_code, String class_type, String numero_lugares){
        for (Voo voo : Manager_voo.voos) {
            if (voo.getCodigo().equals(flight_code)) {
                boolean new_booking;
                class_type = class_type.equals("T") ? "Turistic" : "Executive";
                int number_of_seats = Integer.parseInt(numero_lugares);

                if (class_type.equals("Turistic")) {
                    new_booking = voo.addReserva(voo.getAviao().getSeats_Turistic(), number_of_seats, "Turistic");
                } else {
                    new_booking = voo.addReserva(voo.getAviao().getSeats_Executive(), number_of_seats, "Executive");
                }
                
                if (new_booking) {
                    System.out.print(flight_code + ":" + voo.getReservas() + " = ");
                    voo.printLugaresReservados();
                    
                } else {
                    System.out.println("Não foi possível efetuar a reserva");
                }
            }
        }

    }

    public static void removeReserva(String remove) {
        String flight_code = remove.split(":")[0];
        int sequential_reservation_number = Integer.parseInt(remove.split(":")[1]);

        for (Voo voo : voos) {
            if (voo.getCodigo().equals(flight_code)) {
                voo.removeReserva(sequential_reservation_number);
            }
        }

    }

}
