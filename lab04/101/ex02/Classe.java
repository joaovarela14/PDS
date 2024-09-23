
public class Classe {

  private TipoClasse tipo;
  private int nLines;
  private int nSeats;
  private int numberOfSeats;

  public Classe(TipoClasse tipo, String lugaresPorFila) {
    if (!lugaresPorFila.contains("x")) {
      this.tipo = TipoClasse.NONE;
    } else {
      this.tipo = tipo;
      String[] ArrayLugaresPorFila = lugaresPorFila.split("x");
      nLines = Integer.parseInt(ArrayLugaresPorFila[0]);
      nSeats = Integer.parseInt(ArrayLugaresPorFila[1]);
      numberOfSeats = nLines * nSeats;
    }
  }

  public TipoClasse getTipo() {
    return tipo;
  }

  public int getNLines() {
    return nLines;
  }

  public int getNSeats() {
    return nSeats;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }
}
