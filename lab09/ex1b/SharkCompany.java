import java.util.*;

public class SharkCompany {
	public static void main(String[] args) {
		
			Person[] persons = {
				new Person("Maria Silva"),
				new Person("Manuel Pereira"),
				new Person("Aurora Machado"),
				new Person("Augusto Lima")
		};

		Company shark = new Company();
		Company.user = User.OWNER;

		shark.admitEmployee(1000, persons[0]);
		shark.admitEmployee(290, persons[1]);
		shark.admitEmployee(2300, persons[2]);
		shark.admitEmployee(999, persons[3]);


		List<Employee> sharkEmps = shark.employees();

		
		for (Employee e : sharkEmps)
			// "talking to strangers", but this is not a normal case
			System.out.println(e.getSalary());
		
		for (Employee e : sharkEmps)
			System.out.println(e.totalBalance());

		shark.paySalaries(1);
		
		for (Employee e : sharkEmps)
			System.out.println(e.totalBalance());

}
	}
