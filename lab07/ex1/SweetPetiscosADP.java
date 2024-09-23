public class SweetPetiscosADP {
    private Adapter registos;
    private Adapter database;

    public SweetPetiscosADP(Adapter registos, Adapter database) {
        this.registos = registos;
        this.database = database;
    }

    public void addEmpregado(Employee employee) {
        if (isEmpregado(employee.getEmpNum())) {
            System.out.println("Empregado já existe");
        } else {
            database.addAdp(employee);
        }
    }

    public void removeEmpregado(int codigo) {

            if (database.isEmpregadoAdp(codigo)) {
                database.deleteAdp(codigo);
                return;
            }
            if (registos.isEmpregadoAdp(codigo)) {
                registos.deleteAdp(codigo);
                return;
            }
            System.out.println("Empregado não existe");
        }


    public boolean isEmpregado(long codigo) {
        return database.isEmpregadoAdp(codigo) || registos.isEmpregadoAdp(codigo);
    }

    public void getAll() {
        database.getAllAdp();
        registos.getAllAdp();
    }


}
