
class Employee {

	private double salary;
	private Person person;
	

	public Employee(double salary, Person person) {
		this.salary = salary;
		this.person = person;
	}

	public double getSalary() {
		return this.salary;
	}


	public Person getPerson() {
		return this.person;
	}

	public double totalBalance(){
		return person.getBankAccount().balance();
	}

	public void deposit(double guito){
		person.getBankAccount().deposit(guito);;
	}


	
}