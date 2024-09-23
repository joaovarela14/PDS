import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeInterface emp1 = new Employee("João");
        Manager man1 = new Manager(emp1);
        TeamLeader lea1 = new TeamLeader(man1);
        TeamMember mem1 = new TeamMember(lea1);

        mem1.start(new Date());
        mem1.work();
        mem1.terminate(new Date());
        System.out.println();
        EmployeeInterface emp2 = new Employee("Carol");
        Manager man2 = new Manager(emp2);
        TeamLeader lea2 = new TeamLeader(man2);
        
        lea2.start(new Date());
        lea2.work();
        lea2.terminate(new Date());

        System.out.println();

        EmployeeInterface emp3 =  new Employee("Patrão");

        emp3.start(new Date());
        emp3.work();
    }
}
