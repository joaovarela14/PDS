public class Insurance {
    
    public static String name;
    public static int insurance_id;

    public static void regist(Employee e) {
        insurance_id += 1;
        System.out.println("Employee " + e.getName() + " has been registered with insurance ID: " + insurance_id);
    }
}
