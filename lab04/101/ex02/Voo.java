

import java.util.ArrayList;

/**
 * Voos
 */
public class Voo {

  // atributos
  private String codigo;
  private Aviao aviao;
  private int[][] planeMap;
  private int reservationOrder = 1;
  private int starTurista = 0;
  private int turista = 0, executiva = 1;

  public Voo(String codigo, Aviao aviao) {
    this.codigo = codigo;
    this.aviao = aviao;
    initPlaneMap();
  }

  private void initPlaneMap() {
    int maxSeats = aviao.getClasses().get(turista).getNSeats();
    int maxLines = aviao.getClasses().get(turista).getNLines();
    if (aviao.getClasses().size() == 2) {
      int executivoLines = aviao.getClasses().get(executiva).getNLines();
      int executivoSeats = aviao.getClasses().get(executiva).getNSeats();
      starTurista = executivoLines;
      maxLines += executivoLines;
      maxSeats = maxSeats < executivoSeats ? executivoSeats : maxSeats;
    }

    planeMap = new int[maxSeats][maxLines];

  }

  public int reserveSeat(TipoClasse tipoClasse, int numberOfSeats) {
    int[] boundaries = getBoundaries(tipoClasse);
    if (boundaries==null) {
      return -1;
    }
    int startLine=boundaries[0],endLine=boundaries[1],endSeat=boundaries[2];
    // register all seats
    boolean firstTime = true;
    int twoLoops = 0;
    while (twoLoops != 2) {
      for (int j = startLine; j < endLine; j++) {
        if (firstTime && planeMap[0][j] != 0) {
          continue;
        }
        for (int i = 0; i < endSeat; i++) {
          if (planeMap[i][j] == 0) {
            planeMap[i][j] = reservationOrder;
            numberOfSeats--;
            if (numberOfSeats == 0) {
              reservationOrder++;
              return reservationOrder-1;
            }
          }
        }
      }
      firstTime = false;
      twoLoops++;

    }
    for (int j = startLine; j < endLine; j++) {
      for (int i = 0; i < endSeat; i++) {
        if (planeMap[i][j] == reservationOrder) {
          planeMap[i][j] = 0;
        }
      }
    }

    return -1;
  }

  // showMap

  public void showMap() {
    int minEndSeat = planeMap.length;
    int minEndLine = planeMap[0].length;
    int minStartLine = planeMap[0].length;
    if (aviao.getClasses().size()==2) {
      int[] boundariesExecutiva = getBoundaries(TipoClasse.EXECUTIVA);
      int startLineE=boundariesExecutiva[0];
      int endLineE=boundariesExecutiva[1];
      int endSeatE=boundariesExecutiva[2];
      
      int[] boundariesTuristica = getBoundaries(TipoClasse.TURISTICA);
      int startLineT=boundariesTuristica[0];
      int endLineT=boundariesTuristica[1];
      int endSeatT=boundariesTuristica[2];

      if (endSeatT<endSeatE) {
        minEndSeat=endSeatT;
        minStartLine=startLineT;
        minEndLine=endLineT;
      }else if (endSeatT>endSeatE) {
        minEndSeat=endSeatE;
        minStartLine=startLineE;
        minEndLine=endLineE;
      }
    }


    // print numbers to identify queues
    System.out.print("  ");
    for (int i = 0; i < planeMap[0].length; i++) {
      System.out.printf("%2d ", i + 1);
    }
    System.out.println();

    for (int i = 0; i < planeMap.length; i++) {
      String c = new String(Character.toChars('A' + i));
      System.out.print(c + " ");// print alphabet to identify lines
      for (int j = 0; j < planeMap[i].length; j++) {
        if(i == minEndSeat && j >= minStartLine && j<minEndLine){
        
          System.out.print("   ");
        }else{
          System.out.printf("%2d ", planeMap[i][j]);

        }
      }
      System.out.println();
    }
  }

  public String getCodigo() {
    return codigo;
  }

  public Aviao getAviao() {
    return aviao;
  }

  private int[] getBoundaries(TipoClasse tipoClasse) {
    if (TipoClasse.EXECUTIVA == tipoClasse && aviao.getClasses().size() != 2) {
      return null;
    }
    int endSeat = aviao.getClasses().get(turista).getNSeats();

    int endLine = planeMap[0].length;
    int startLine = starTurista;
    if (tipoClasse == tipoClasse.EXECUTIVA) {
      endSeat = aviao.getClasses().get(executiva).getNSeats();
      endLine = starTurista;
      startLine = 0;
    }
    int[] pos = {startLine,endLine,endSeat};
    return pos;

  }

  public String getSeats(int sequential_number) {
    String allSeats="";
    for (int i = 0; i < planeMap.length; i++) {
      for (int j = 0; j < planeMap[i].length; j++) {
        if(planeMap[i][j]==sequential_number){
          String c = new String(Character.toChars('A' + i));
          allSeats+=j+c+" | ";
        }

      }
    }
    return allSeats.substring(0, allSeats.length()-3);
  }

  public void removeSeats(int sequential_number){
    for (int i = 0; i < planeMap.length; i++) {
      for (int j = 0; j < planeMap[i].length; j++) {
        if(planeMap[i][j]==sequential_number){
            planeMap[i][j]=0;
        }
      }
    }
  }
}
