public class Livro {
    private String titulo;
    private int ISBN;
    private int ano;
    private String primeiro_autor;
    private State currentstate;

    public Livro(int ISBN, String titulo, String primeiro_autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.primeiro_autor = primeiro_autor;
        this.currentstate = new Inventario();
    }

    public void regista() {
        currentstate.regista(this);
    }

    public void requisita() {
        currentstate.requisita(this);
    }

    public void devolve() {
        currentstate.devolve(this);
    }

    public void cancelaReserva() {
        currentstate.cancelaReserva(this);
    }

    public void reserva() {
        currentstate.reserva(this);
    }

    public void setState(State state) {
        this.currentstate = state;
    }

    public String toString() {

        String livro = String.format("%-1d %-25s %-20s [%s]", ISBN, this.titulo, this.primeiro_autor, this.currentstate.toString());
        return livro;
    }


}
