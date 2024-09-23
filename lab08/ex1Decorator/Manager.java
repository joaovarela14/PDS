public class Manager extends EmployeeDecorator{
    public Manager(EmployeeInterface EmpInt){
        super(EmpInt);
    }

    public void work(){
        super.work();
        manage();
    }

    public void manage(){
        System.out.printf("O %s Manager está a gerir o Team Leader.\n", this.getName());
    }
}
