import java.util.*;

public class EmployeeCard {
    
    public static String name;
    public static int number;
    private static ArrayList<Integer> employees_cards = new ArrayList<Integer>();

    public static void createCard(Employee e){
        number += 1;
        employees_cards.add(number);
        System.out.println("Employee " + e.getName() + " has the card with number " + number);

    }
}
