class Solution {
    private  boolean isSafe(char[][] board, int row, int col, char digit) {
        
        //// Check row and column
        for (int i = 0; i < 9; i++) {
            if ((board[row][i] == digit && i != col) || (board[i][col] == digit && i != row)) {
                return false;
            }
        }

        // Check 3x3 sub-box
        int subgridRow = (row / 3) * 3;
        int subgridCol = (col / 3) * 3;
        for (int i = subgridRow; i < subgridRow + 3; i++) {
            for (int j = subgridCol; j < subgridCol + 3; j++) {
                if (board[i][j] == digit && i != row && j != col) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit != '.' && !isSafe(board, i, j, digit)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return isSudoku(board);
    }
}