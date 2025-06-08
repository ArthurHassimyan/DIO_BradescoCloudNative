import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sudoku!");

        while (true) {
            printBoard(sudoku.sudokuGame);

            System.out.println("Digite 'sair' para encerrar.");
            System.out.print("Informe a linha (0 a 8): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) break;
            int row = parseInput(input);
            if (row == -1) continue;

            System.out.print("Informe a coluna (0 a 8): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) break;
            int col = parseInput(input);
            if (col == -1) continue;

            System.out.print("Informe o número (1 a 9): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) break;
            int num = parseInput(input);
            if (num == -1) continue;

            if (sudoku.isValidMove(row, col, num)) {
                sudoku.sudokuGame[row][col] = num;
                System.out.println("Número inserido com sucesso!");
            } else {
                System.out.println("Movimento inválido. Tente novamente.");
            }
        }

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }

    // Função para imprimir o tabuleiro no console
    public static void printBoard(int[][] board) {
        System.out.println("\nTabuleiro atual:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("+-------+-------+-------+");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                int val = board[i][j];
                System.out.print((val == 0 ? ". " : val + " "));
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+\n");
    }

    // Função para converter entrada em número e validar
    private static int parseInput(String input) {
        try {
            int val = Integer.parseInt(input);
            if (val < 0 || val > 9) {
                System.out.println("Por favor, digite um número entre 0 e 9.");
                return -1;
            }
            return val;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
            return -1;
        }
    }
}