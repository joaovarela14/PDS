import java.util.*;

public class Parking {
    
    private static ArrayList<String> parking = new ArrayList<>();

    public static boolean allow(Employee e){
        if (e.getSalary() > Company.averagesalary()){
            parking.add(e.getName());
            System.out.println(e.getName() + " allowed to parking.");
            return true;
        }
        else{
            System.out.println(e.getName() + " not allowed to parking.");
            return false;
        }

    }
}
