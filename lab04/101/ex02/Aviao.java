

import java.util.ArrayList;

/**
 * Aviao
 */
public class Aviao {

  private ArrayList<Classe> classes = new ArrayList<Classe>();

  public Aviao(String lugaresPorFila) {
    Classe buff = new Classe(TipoClasse.TURISTICA, lugaresPorFila);
    classes.add(buff);
  }

  public Aviao(String executivaLugaresPorFila, String turistaLugaresPorFila) {
    Classe buff = new Classe(TipoClasse.TURISTICA, turistaLugaresPorFila);
    Classe buff2 = new Classe(TipoClasse.EXECUTIVA, executivaLugaresPorFila);
    classes.add(buff);
    classes.add(buff2);
  }

  public ArrayList<Classe> getClasses() {
    return classes;
  }
}
