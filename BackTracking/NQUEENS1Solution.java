package BackTracking;

public class NQUEENS1Solution {
    static int count = 0;
    public static void printBoard(char board[][]) {
        System.out.println("-------chess board-------");
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static boolean nQueensSafe(char board[][],int row) {
        //base case
        if(row == board.length) {
            count++; 
            return true;
        }
        //column loop
        for(int j=0;j<board.length;j++) {
            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';
            if(nQueensSafe(board, row+1)) { //chnge for 1 solution
                return true; //function call 
            }
            board[row][j] ='X';//backtracking
            }
        }
        return false;
    }
    public static boolean isSafe(char board[][],int row,int col) {
        //vertically up safe
        for(int i=row-1;i>=0;i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //diagnol left up
        for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonal right up
        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        int n = 3;
        char board[][] = new char[n][n];
        //initialise
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = 'X';
            }
        }
        System.out.println("------------safe conditon------------"); 
        if(nQueensSafe(board, 0)) { //change for 1 solution
            System.out.println("solution is possible");
            printBoard(board);
        }
        else {
            System.out.println("solution not possible");
        } //safe condition
        System.out.println(" total number of ways : " + count);//total number of ways
    }
}

