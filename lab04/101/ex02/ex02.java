

import java.io.File;
import java.util.Scanner;

public class ex02 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    File file = null;
    Menu menu = new Menu();
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
    while (true) {
      System.out.println("Escolha uma opção: (H para ajuda)");
      String input = sc.nextLine();

      if (file != null) System.out.println(input);

      menu.init(input);

      if (input.equals("Q")) {
        break;
      }
    }
    sc.close();
  }
}
