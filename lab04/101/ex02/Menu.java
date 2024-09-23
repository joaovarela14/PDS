

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu
 */
public class Menu {

  private ArrayList<Voo> voos;
  private int turista = 0, executiva = 1;

  public Menu() {
    voos = new ArrayList<Voo>();
  }

  public void init(String input) {
    String[] allTokens = input.split(" ");
    String flag = allTokens[0];
    switch (flag) {
      case "H":
        showAllOptions();
        break;
      case "I":
        if (allTokens.length != 2) {
          System.out.println(
            "ERROR! you have provided too many/less arguments"
          );
          break;
        }
        readFile(allTokens[1]);
        break;
      case "M":
        if (allTokens.length != 2) {
          System.out.println(
            "ERROR! you have provided too many/less arguments"
          );
          break;
        }
        showMapByCode(allTokens[1]);
        break;
      case "F":
        if (allTokens.length == 3) {
          String flight_code = allTokens[1];
          String num_seats_tourist = allTokens[2];
          addVoo(flight_code, num_seats_tourist);
        } else if (allTokens.length == 4) {
          String flight_code = allTokens[1];
          String num_seats_executive = allTokens[2];
          String num_seats_tourist = allTokens[3];
          addVoo(flight_code, num_seats_tourist, num_seats_executive);
        } else {
          System.out.println("ERROR! you have provided too many arguments");
        }
        break;
      case "R":
        if (allTokens.length < 4) {
          System.out.println("ERROR! you have provided too many arguments");
          break;
        }
        String flight_code = allTokens[1];
        String tipoclass = allTokens[2];
        String number_seats = allTokens[3];
        registerSeats(flight_code, tipoclass, number_seats);
        break;
      case "C":
        if (allTokens.length < 2) {
          System.out.println("ERROR! you have provided insufficient arguments");
          break;
        }
        String[] cancelCode = allTokens[1].split(":");
        if (cancelCode.length < 2) {
          System.out.println("ERROR! you have provided insufficient arguments");
          break;
        }
        flight_code = cancelCode[0];
        int sequential_reservation_number = Integer.parseInt(cancelCode[1]);
        cancelSeats(flight_code, sequential_reservation_number);
        break;
      default:
        break;
    }
  }

  private void cancelSeats(
    String flight_code,
    int sequential_reservation_number
  ) {
    for (Voo voo : voos) {
      if (voo.getCodigo().compareTo(flight_code) == 0) {
        voo.removeSeats(sequential_reservation_number);
      }
    }
  }

  private void registerSeats(
    String flight_code,
    String tipoclass,
    String number_seats
  ) {
    TipoClasse tipoClasse = TipoClasse.getTipoByChar(tipoclass.charAt(0));
    int numberOfSeats = Integer.parseInt(number_seats);
    for (Voo voo : voos) {
      if (voo.getCodigo().compareTo(flight_code) == 0) {
        int sequential_number = voo.reserveSeat(tipoClasse, numberOfSeats);
        if (sequential_number == -1) {
          System.out.println(
            "Não foi possível obter lugares para a reserva: " +
            tipoclass +
            " " +
            number_seats
          );
        } else {
          System.out.println(
            flight_code +
            ":" +
            sequential_number +
            " = " +
            voo.getSeats(sequential_number)
          );
        }
      }
    }
  }

  private void addVoo(
    String flight_code,
    String num_seats_tourist,
    String num_seats_executive
  ) {
    for (Voo voo : voos) {
      if (voo.getCodigo().compareTo(flight_code) == 0) {
        System.out.println("ERROR! flight already exists");
        return;
      }
    }

    Aviao aviao = new Aviao(num_seats_executive, num_seats_tourist);
    for (Classe classe : aviao.getClasses()) {
      if (classe.getTipo() == TipoClasse.NONE) {
        System.out.println("ERROR!");
        return;
      }
    }
    Voo voo = new Voo(flight_code, aviao);
    voos.add(voo);
  }

  private void addVoo(String flight_code, String num_seats_tourist) {
    for (Voo voo : voos) {
      if (voo.getCodigo().compareTo(flight_code) == 0) {
        System.out.println("ERROR! flight already exists");
        return;
      }
    }
    Aviao aviao = new Aviao(num_seats_tourist);
    for (Classe classe : aviao.getClasses()) {
      if (classe.getTipo() == TipoClasse.NONE) {
        System.out.println("ERROR!");
        return;
      }
    }
    Voo voo = new Voo(flight_code, aviao);
    voos.add(voo);
  }

  private void showMapByCode(String code) {
    for (Voo voo : voos) {
      if (voo.getCodigo().compareTo(code) == 0) {
        voo.showMap();
        return;
      }
    }
    System.out.println("ERROR! flight doenst exists");
  }

  private void readFile(String pathFile) {
    try {
      File file = new File(pathFile);
      Scanner scFile = new Scanner(file);
      int indexOfVoo = initVoo(scFile.nextLine());
      if (indexOfVoo == -1) {
        System.out.println("ERROR! unable to create plane");
        scFile.close();
        return;
      }

      Voo voo = voos.get(indexOfVoo);
      ArrayList<Classe> aviaoClasses = voo.getAviao().getClasses();

      System.out.printf(
        "Código de voo %s. Lugares disponíveis:\n",
        voo.getCodigo()
      );
      int numberOfSeatsTuristica = aviaoClasses.get(turista).getNumberOfSeats();

      if (aviaoClasses.size() == 2) {
        int numberOfSeatsExecutiva = aviaoClasses
          .get(executiva)
          .getNumberOfSeats();
        System.out.printf(
          "%d lugares em classe Executiva; %d lugares em classe Turística.\n",
          numberOfSeatsExecutiva,
          numberOfSeatsTuristica
        );
      } else {
        System.out.printf(
          "%d lugares em classe Turística.\n",
          numberOfSeatsTuristica
        );
        System.out.println("Classe executiva não disponível neste voo.");
      }

      while (scFile.hasNextLine()) {
        String[] line = scFile.nextLine().split(" ");
        TipoClasse tipoClasse = TipoClasse.getTipoByChar(line[0].charAt(0));
        int numberOfSeats = Integer.parseInt(line[1]);
        if (voo.reserveSeat(tipoClasse, numberOfSeats) == -1) {
          System.out.println(
            "Não foi possível obter lugares para a reserva: " +
            line[0] +
            " " +
            line[1]
          );
        }
      }
      scFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
  }

  private int initVoo(String info) {
    // info = ">codigo NlugaresTuristico" or
    // ">codigo NlugaresExecutivo NlugaresTuristico"

    if (info.charAt(0) != '>') {
      return -1;
    }
    String[] arrayInfo = info.split(" ");

    String codigo = arrayInfo[0].substring(1);
    Aviao aviao;

    if (arrayInfo.length == 2) {
      aviao = new Aviao(arrayInfo[1]);
    } else if (arrayInfo.length == 3) {
      aviao = new Aviao(arrayInfo[1], arrayInfo[2]);
    } else {
      return -1;
    }

    for (Classe classe : aviao.getClasses()) {
      if (classe.getTipo() == TipoClasse.NONE) {
        System.out.println("ERROR!");
        return -1;
      }
    }
    Voo voo = new Voo(codigo, aviao);
    for (Voo v : voos) {
      if (voo.getCodigo().compareTo(v.getCodigo()) == 0) {
        return -1;
      }
    }
    voos.add(voo);
    return voos.indexOf(voo);
  }

  private void showAllOptions() {
    System.out.println(
      "I filename-read a file\nM flight_code-show the airplane map\nF flight_code num_seats_executive num_seats_tourist-add a flight\nR flight_code class number_seats-register a recervation\nC reservation_code-cancel a reservation\nQ-quit"
    );
  }

  public ArrayList<Voo> getVoos() {
    return voos;
  }
}
// ANDRE
// new aviao pode falhar
// parse to int
// testar
// ver o codigo
