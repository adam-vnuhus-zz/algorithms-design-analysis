package BT4;

public class QueenProblem {
    
    final int N = 8;

    /*In mang ket qua */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

   /*kiểm tra nếu một quân hậu có thể được đặt trên [hàng] [col]*/
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Kiem tra hang ben trai */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Kiểm tra đường chéo trên bên trái */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Kiểm tra đường chéo dưới bên trái */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    
    boolean solveNQUtil(int board[][], int col) {
		/* Dieu kien dung neu tat ca quan hau duoc dat dung vi tri*/
        if (col >= N)
            return true;

		
        for (int i = 0; i < N; i++) {
			
            if (isSafe(board, i, col)) {
                
                board[i][col] = 1;

                
                if (solveNQUtil(board, col + 1) == true)
                    return true;

				
                board[i][col] = 0; // BACKTRACK
            }
        }

		
        return false;
    }

    boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    
    public static void main(String args[]) {
        QueenProblem Queen = new QueenProblem();
        Queen.solveNQ();
    }
}
