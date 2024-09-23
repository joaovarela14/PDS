import java.util.*;

public class EmployeeDecorator implements EmployeeInterface{
    private final EmployeeInterface EmpInt;


    public EmployeeDecorator(EmployeeInterface EmpInt){
        this.EmpInt = EmpInt;
    }

    public void start(Date date){
        EmpInt.start(date); 
    }

    public void terminate(Date date){
        EmpInt.terminate(date); 
    }

    public void work(){
        EmpInt.work();
    }

    public String getName(){
        return EmpInt.getName();
    }
    
}
