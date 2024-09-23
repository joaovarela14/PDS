
public class TicTacToe implements JGaloInterface {

    boolean PLAYER_X = true; 

    char[][] board = new char[3][3];

    int number_of_plays = 0;

    public void set_player(char letter){
        if (letter == 'X' || letter == 'x'){
            PLAYER_X = true;
        } else if (letter == 'O' || letter == 'o'){
            PLAYER_X = false;
        }
        else{
            System.err.println("Invalid player. Please use X or O");
            System.exit(1);
        }
    }

    public char getActualPlayer(){
        return (PLAYER_X ? 'X' : 'O');
    }

    public boolean setJogada(int lin, int col){
        lin--;
        col--;
        if (board[lin][col] == 0){
            board[lin][col] = getActualPlayer();
            PLAYER_X = !PLAYER_X;
            number_of_plays++;
            return true;
        }
        return false;

    }

    public boolean isFinished(){
        return (checkResult() != 0 || number_of_plays == 9);
    }

    public char checkResult(){

        for (int i = 0; i < 3; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0
            || board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0){
                return board[i][i];
            }
            
        }
        //diagonais
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0){
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0){
            return board[0][2];
        }
        
        if (number_of_plays == 9){
            return ' ';
        }
        return 0;
    }
    
}
