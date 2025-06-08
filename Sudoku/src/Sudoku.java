public class Sudoku {
    public final int[][] sudokuOriginal= {
            {9, 5, 8, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 2, 5, 6, 0, 0, 4},
            {0, 0, 6, 0, 0, 0, 5, 1, 7},
            {6, 0, 0, 3, 7, 8, 0, 0, 0},
            {7, 8, 4, 0, 0, 0, 9, 3, 2},
            {0, 0, 0, 4, 2, 9, 0, 0, 8},
            {4, 9, 2, 0, 0, 0, 1, 0, 0},
            {0, 6, 0, 5, 8, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 7, 6, 3}
    };

    public int[][] sudokuGame;

    public Sudoku(){
        this.sudokuGame = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.sudokuGame[row][col] = sudokuOriginal[row][col];
            }
        }
    }

    public boolean validRow(int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (sudokuGame[row][col] == num) {
                System.out.println("There is already a " + num + " in this row.");
                return false;
            }
        }
        return true;
    }

    public boolean validColumn(int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (sudokuGame[row][col] == num) {
                System.out.println("There is already a " + num + " in this column.");
                return false;
            }
        }
        return true;
    }

    public boolean validBox(int row, int col, int num) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudokuGame[startRow + i][startCol + j] == num) {
                    System.out.println("There is already a " + num + " in this 3x3 box.");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean cellEditable(int row, int col) {
        if (sudokuOriginal[row][col] != 0) {
            System.out.println("Invalid, Automatically Generated Position");
            return false;
        }
        return true;
    }

    public boolean isValidMove(int row, int col, int num) {
        if(num > 0 && num <= 9) {
            if (cellEditable(row, col)) {
                return validRow(row, num) && validColumn(col, num) && validBox(row, col, num);
            }
            return false;
        }
        return false;
    }
}
