
import java.util.Arrays;

public class Galo implements JGaloInterface {

  private char[][] board;
  private int numMoves = 0; // in max = 9
  // criado para nao estar constantemente a iterar sobre o board
  private char actualPlayer; // X or O

  // construtor por omissao começa com X
  public Galo() {
    this.board = new char[3][3];
    // incializar a board com ' '
    startBoard();
    this.actualPlayer = 'X';
  }

  public Galo(char firstPlayer) {
    firstPlayer = Character.toUpperCase(firstPlayer);
    // verificar se firstPlayer é válido
    if (firstPlayer != 'X' && firstPlayer != 'O') {
      this.actualPlayer = 'X';
    } else {
      this.actualPlayer = firstPlayer;
    }
    board = new char[3][3];
    // incializar a board com ' '
    startBoard();
  }

  private void startBoard() {
    for (char[] line : board) Arrays.fill(line, ' ');
  }

  @Override
  public char getActualPlayer() {
    return actualPlayer;
  }

  private void switchPlayer() {
    actualPlayer = actualPlayer == 'X' ? 'O' : 'X';
  }

  @Override
  public boolean setJogada(int lin, int col) {
    if (board[lin - 1][col - 1] == ' ') {
      board[lin - 1][col - 1] = actualPlayer;
      switchPlayer();
      numMoves++;
      return true;
    }
    return false;
  }

  public boolean hasWinner() {
    // percorrer as horizontais ou verticais
    for (int i = 0; i < 3; i++) {
      if (
        (
          board[i][0] != ' ' &&
          board[i][0] == board[i][1] &&
          board[i][0] == board[i][2]
        ) ||
        (
          board[0][i] != ' ' &&
          board[0][i] == board[1][i] &&
          board[0][i] == board[2][i]
        )
      ) {
        return true;
      }
    }
    // verificar as diagonais
    // TODO MAKE THIS CLEANER...
    return (
      (
        board[0][0] != ' ' &&
        board[0][0] == board[1][1] &&
        board[0][0] == board[2][2]
      ) ||
      (
        board[0][2] != ' ' &&
        board[0][2] == board[1][1] &&
        board[0][2] == board[2][0]
      )
    );
  }

  @Override
  public boolean isFinished() {
    return numMoves == 9 | hasWinner();
  }

  @Override
  public char checkResult() {
    if (hasWinner()) {
      // no fim da jogada o vencedor coloca como proximo player o seu adversario, logo é preciso mudar de novo

      switchPlayer();
      return getActualPlayer();
    } else return ' ';
  }
}
