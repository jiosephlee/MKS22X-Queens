public class QueenBoard{

    public static void main(String[] args) {
        QueenBoard test = new QueenBoard(10);
        test.addQueen(1,1);
        System.out.println(test);
        test.removeQueen(1,1);
        System.out.println(test);
    }

    private int[][]board;

    public QueenBoard(int size){
        board = new int[size][size];
    }

    private boolean addQueen(int r,int c){
        board[r][c] = -4;
        for (int i = 0; i < board.length;i++){
            board[r][i] = board[r][i] + 1;
            board[i][c] = board[i][c] + 1;
            board[(r+i)%board.length][(c+i)%board.length] = board[(r+i)%board.length][(c+i)%board.length] + 1;
        }
        return true;
    }

    private boolean removeQueen(int r, int c){
        board[r][c] = 3;
        for (int i = 0; i < board.length;i++){
            board[r][i] = board[r][i] - 1;
            board[i][c] = board[i][c] - 1;
            board[(r+i)%board.length][(c+i)%board.length] = board[(r+i)%board.length][(c+i)%board.length] - 1;
        }
        return true;
    }


    public String toString(){
        String output = "";
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == -1){
                    output += 'Q';
                } else if (board[i][j] != 0){
                    output += board[i][j];
                } else{
                    output+= '_';
                }
            }
            output += '\n';
        }
        return output;
    }

    public boolean solve(){
        return true;
    }
    public boolean solveHelp(int[][] board, int row, int column){
        return true;
    }
    public int countSolutions(){
        return 1;
    }
}
