public class QueenBoard{

    public static void main(String[] args) {
        QueenBoard test = new QueenBoard(10);
        test.addQueen(1,3);
        System.out.println(test.debug());
        test.addQueen(5,4);
        System.out.println(test.debug());
        test.removeQueen(1,3);
        System.out.println(test.debug());
        test.removeQueen(5,4);
        test.addQueen(8,3);
        System.out.println(test.debug());
        test.addQueen(6,9);
        System.out.println(test.debug());
        QueenBoard testtwo = new QueenBoard(3);
        System.out.println(testtwo.debug());
        System.out.println(testtwo.solve());
        System.out.println(testtwo.debug());
    }

    private int[][]board;

    public QueenBoard(int size){
        board = new int[size][size];
    }

    private boolean addQueen(int r,int c){
        if(board[r][c] != 0){
            return false;
        }
        board[r][c] = -7;
        for (int i = 0; i < board.length;i++){
            board[r][i] = board[r][i] + 1;
            board[i][c] = board[i][c] + 1;
            if (c+i < board.length && r+i < board.length){
                board[(r+i)%board.length][(c+i)%board.length] = board[(r+i)%board.length][(c+i)%board.length] + 1;
            }
            if (c-i > -1 && r+i < board.length){
                board[(r+i)%board.length][(c-i)%board.length] = board[(r+i)%board.length][(c-i)%board.length] + 1;
            }
            if (c+i < board.length && r-i > -1){
                board[(r-i)%board.length][(c+i)%board.length] = board[(r-i)%board.length][(c+i)%board.length] + 1;
            }
            if (c-i > -1 && r-i > -1){
                board[(r-i)%board.length][(c-i)%board.length] = board[(r-i)%board.length][(c-i)%board.length] + 1;
            }
        }
        return true;
    }

    private boolean removeQueen(int r, int c){
        if(board[r][c] == -1){
            board[r][c] = 6;
            for (int i = 0; i < board.length;i++){
                board[r][i] = board[r][i] - 1;
                board[i][c] = board[i][c] - 1;
                if (c+i < board.length && r+i < board.length){
                    board[(r+i)%board.length][(c+i)%board.length] = board[(r+i)%board.length][(c+i)%board.length] - 1;
                }
                if (c-i > -1 && r+i < board.length){
                    board[(r+i)%board.length][(c-i)%board.length] = board[(r+i)%board.length][(c-i)%board.length] - 1;
                }
                if (c+i < board.length && r-i > -1){
                    board[(r-i)%board.length][(c+i)%board.length] = board[(r-i)%board.length][(c+i)%board.length] - 1;
                }
                if (c-i > -1 && r-i > -1){
                    board[(r-i)%board.length][(c-i)%board.length] = board[(r-i)%board.length][(c-i)%board.length] - 1;
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
        return solveHelp(0,0,false);
    }
    public boolean solveHelp(int row, int col, boolean remove){
        System.out.println(debug());
        if (remove){
            removeQueen(row, col-1);
        }
        if (row < board.length){
            if (col < board.length){
                if (addQueen(row,col)){
                    return solveHelp(row + 1, 0, false) || solveHelp(row, col + 1, true);
                }
                return solveHelp(row, col + 1, false);
            }
            return false;
        }
        return true;
    }
    public int countSolutions(){
        return 1;
    }
}
