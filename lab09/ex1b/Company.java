import java.util.*;
class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();

	public void admitEmployee(double salary, Person person) {
		Employee e = new Employee(salary, person);
		emps.add(e);
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			e.deposit(e.getSalary());
		}
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}