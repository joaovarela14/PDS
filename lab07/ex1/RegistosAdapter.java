public class RegistosAdapter implements Adapter{
    Registos registos = new Registos();

    public RegistosAdapter(Registos registos) {
        this.registos = registos;
    }

    @Override
    public boolean addAdp(Employee employee) {
        Empregado empregado = new Empregado(employee.getName(), " ", (int) employee.getEmpNum(), employee.getSalary());
        registos.insere(empregado);
        return true;
    }

    @Override
    public void deleteAdp(long emp_num) {
        registos.remove((int) emp_num);
    }

    @Override
    public boolean isEmpregadoAdp(long emp_num) {
        return registos.isEmpregado((int) emp_num);
    }

    @Override
    public void getAllAdp() {
        for (Empregado emp : registos.listaDeEmpregados()) {
            System.out.println(emp.toString());
        }
    }


    
}
