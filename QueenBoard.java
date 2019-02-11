public class QueenBoard{

    public static void main(String[] args) {
        QueenBoard test = new QueenBoard(10);
        test.addQueen(1,3);
        System.out.println(test.debug());
        test.addQueen(5,4);
        System.out.println(test.debug());
        test.removeQueen(1,3);
        System.out.println(test.debug());
        //System.out.println(test.solve());
        //System.out.println(test.debug());
    }

    private int[][]board;

    public QueenBoard(int size){
        board = new int[size][size];
    }

    private boolean addQueen(int r,int c){
        if(board[r][c] != 0){
            return false;
        }
        board[r][c] = -4;
        for (int i = 0; i < board.length;i++){
            board[r][i] = board[r][i] + 1;
            board[i][c] = board[i][c] + 1;
            if (r+i < board.length && c+i < board.length){
                board[(r+i)%board.length][(c+i)%board.length] = board[(r+i)%board.length][(c+i)%board.length] + 1;
            }
        }
        return true;
    }

    private boolean removeQueen(int r, int c){
        if(board[r][c] == -1){
            board[r][c] = 3;
            for (int i = 0; i < board.length;i++){
                board[r][i] = board[r][i] - 1;
                board[i][c] = board[i][c] - 1;
                if (r+i < board.length && c+i < board.length){
                    board[(r+i)%board.length][(c+i)%board.length] = board[(r+i)%board.length][(c+i)%board.length] - 1;
                }
            }
            return true;
        }
        return false;
    }


    public String toString(){
        String output = "";
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == -1){
                    output += 'Q';
                } else{
                    output+= '_';
                }
            }
            output += '\n';
        }
        return output;
    }

    public String debug(){
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
        return solveHelp(0,0);
    }
    public boolean solveHelp(int row, int col){
        if (row < board.length){
            if (col < board.length){
                if (addQueen(row,col)){
                    return solveHelp(row + 1, 0);
                }
                return solveHelp(row, col + 1);
            }
            return false;
        }
        return true;
    }
    public int countSolutions(){
        return 1;
    }
}
