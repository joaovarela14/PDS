import java.util.*;

class Company {

public static User user;
private static List<Employee> emps = new ArrayList<>();

	public void admitPerson(String name, double salary) {
		Employee e = new Employee(name, salary);
		emps.add(e);
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public static double averagesalary(){
		double salarySum = 0;

        for (Employee employee : emps){
            salarySum += employee.getSalary();
        }
        return (double) salarySum/emps.size();
	}

	public void admitEmployee(Person person, double salary){
		Employee e = new Employee(person.getName(), salary);
		emps.add(e);

		SocialSecurity.regist(e);
		Insurance.regist(e);
		EmployeeCard.createCard(e);
		Parking.allow(e);

	}
}