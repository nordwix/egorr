import java.util.Scanner;

public class Game {
    public static void playGame() {
        int size = Settings.boardSize;
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';

        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        String currentName = Settings.player1;
        int totalMoves = 0;
        boolean gameOver = false;

        while (!gameOver && totalMoves < size * size) {
            printBoard(board);
            System.out.println(currentName + " (" + currentPlayer + ") - введіть рядок і стовпець (від 1):");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != ' ') {
                System.out.println("Невірний хід. Спробуйте ще раз.");
                continue;
            }

            board[row][col] = currentPlayer;
            totalMoves++;

            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Переміг: " + currentName);
                Statistics.saveGameResult(currentName, size);
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                currentName = (currentPlayer == 'X') ? Settings.player1 : Settings.player2;
            }
        }

        if (!gameOver) {
            printBoard(board);
            System.out.println("Нічия!");
            Statistics.saveGameResult("Нічия", size);
        }
    }

    private static void printBoard(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    private static boolean checkWin(char[][] board, char symbol) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            boolean rowWin = true, colWin = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbol) rowWin = false;
                if (board[j][i] != symbol) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        boolean mainDiag = true, antiDiag = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) mainDiag = false;
            if (board[i][size - i - 1] != symbol) antiDiag = false;
        }
        return mainDiag || antiDiag;
    }
}

