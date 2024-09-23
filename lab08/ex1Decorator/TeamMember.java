public class TeamMember extends EmployeeDecorator{
    public TeamMember(EmployeeInterface EmpInt){
        super(EmpInt);
    }

    public void work(){
        super.work();
        colaborate();
    }

    public void colaborate(){
        System.out.printf("O %s Team Member está a colaborar com o Team Leader.\n", this.getName());
    }
    
}
