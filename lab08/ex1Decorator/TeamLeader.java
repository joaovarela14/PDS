public class TeamLeader extends EmployeeDecorator{
    public TeamLeader(EmployeeInterface EmpInt){
        super(EmpInt);
    }

    public void work(){
        super.work();
        plan();
    }

    public void plan(){
        System.out.printf("O %s Team Leader está a planear o trabalho.\n", this.getName());
    }
    
}
