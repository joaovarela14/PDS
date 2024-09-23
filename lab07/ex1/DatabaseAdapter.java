public class DatabaseAdapter implements Adapter{
    Database database = new Database();
    public DatabaseAdapter(Database database) {
        this.database = database;
    }


    @Override
    public boolean addAdp(Employee employee) {
        return database.addEmployee(employee);
    }


    @Override
    public void deleteAdp(long emp_num) {
        database.deleteEmployee(emp_num);
    }

    @Override
    public boolean isEmpregadoAdp(long emp_num) {
        for (Employee e : database.getAllEmployees()) {
            if (e.getEmpNum() == emp_num) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void getAllAdp() {
        for (Employee e : database.getAllEmployees()) {
            System.out.println(e.toString());
        }
    }


    
}
