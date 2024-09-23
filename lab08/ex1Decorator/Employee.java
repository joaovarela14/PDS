import java.util.*;

public class Employee implements EmployeeInterface{
    private String name;

    public Employee(String n){
        this.name = n;
    }

    public void start(Date date) {
        System.out.printf("%s começou a trabalhar na empresa no dia %s.\n",name, date.toString());
    }

    public void terminate(Date date) {
        System.out.printf("%s deixou de trabalhar na empresa no dia %s.\n",name, date.toString());
    }

    public void work() {
        System.out.printf("%s está a trabalhar na empresa.\n",name);
    }
    
    public String getName() {
        return name;
    }
}
