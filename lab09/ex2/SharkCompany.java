import java.util.*;

public class SharkCompany {
	public static void main(String[] args) {
		
		Company shark = new Company();
		Company.user = User.OWNER;
        Person[] people = { new Person("Maria Silva"),
                    new Person("Manuel Pereira"),
                    new Person("Aurora Machado"),
                    new Person("Augusto Lima") };
		List<Employee> sharkEmps = shark.employees();
		
		for (Employee e : sharkEmps)
			// "talking to strangers", but this is not a normal case
			System.out.println(e.getBankAccount().balance());
		shark.paySalaries(1);
		for (Employee e : sharkEmps) {
			e.getBankAccount().withdraw(500);
			System.out.println(e.getBankAccount().balance());
		}

		shark.admitEmployee(people[0], 1500);
		System.out.println();
		shark.admitEmployee(people[1], 2500);
		System.out.println();
		shark.admitEmployee(people[2], 1000);
		System.out.println();
		shark.admitEmployee(people[3], 2000);


	}
}