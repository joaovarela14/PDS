import java.util.ArrayList;

public class SocialSecurity {
    
    public static String name;
    public static int ssn;
    private static ArrayList<String> socialsecurity_list = new ArrayList<String>();
    
    public static void regist(Employee e) {
        socialsecurity_list.add(e.getName());
        ssn += 1;
        System.out.println("Employee " + e.getName() + " has been registered with SSN: " + ssn);
    }
}
