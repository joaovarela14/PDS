import java.util.*;
import java.io.*;


public class MainVoos {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String[] user_input;
        File file = null;
        
        if (args.length == 1) {
          file = new File(args[0]);
          try {
            sc = new Scanner(file);
          } catch (Exception e) {
            System.out.println("Error in file: " + args[0]);
            sc.close();
            return;
          }
        }
    
        do {
            System.out.println("\nEscolha uma opção: (H para ajuda)");
            user_input = sc.nextLine().split(" ");
    
            switch (user_input[0].toUpperCase()) {
                case "H":
                    System.out.println("I <filename> - Inserir um novo voo a partir de um ficheiro");
                    System.out.println("M - Exibe mapa de reservas");
                    System.out.println("F - Acrescentar novo voo");
                    System.out.println("R - Acrescentar reserva a um voo");
                    System.out.println("C - Cancelar reserva de um voo");
                    System.out.println("Q - Sair do programa");    
                    break;
    
                case "I":
                    if (user_input.length <= 1) {
                        System.out.println("Indique o nome do ficheiro");
                    } else {
                        Manager_voo.read_file(user_input[1]);
                    }
                    break;
    
                case "M":
                    if (user_input.length <= 1) {
                        System.out.println("Indique o Código do Voo");
                    } else {
                        Manager_voo.PrintPlane(user_input[1]);
                    }
                    break;

                case "F":
                    System.out.println("F flight_code num_seats_executive num_seats_turistic");
                    if (user_input.length < 3) {
                        System.out.println("Indique o número de lugares na classe executiva e turística");
                    } 
                    else {
                        Manager_voo.addFlight(user_input);
                    }

                    break;
                
                case "R":
                    if (user_input.length < 4) {
                        System.out.println("Indique o código do voo, a classe e o número de lugares");
                        System.out.println("R flight_code class(T/E) number_of_seats");
                    } 
                    else {
                        Manager_voo.adicionar_reserva(user_input[1], user_input[2], user_input[3]);
                    }   
                    break;

                case "C":
                    if (user_input.length < 2){
                        System.out.println("Indique o código do voo e o número de lugares");
                        System.out.println("C flight_code:sequential_reservation_number");
                    }
                    else {
                        Manager_voo.removeReserva(user_input[1]);
                    }
                    break;
                
                case "Q":
                    System.out.println("A sair do programa...");
                    break;
                
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (!user_input[0].toUpperCase().equals("Q"));

        sc.close();
    }
}    