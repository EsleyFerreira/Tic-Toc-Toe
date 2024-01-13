import java.util.Scanner;

public class Main {

    private static final char[][] board = {
            {' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' '},
    };

    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayBoard();

        while (true) {
            System.out.print("Player " + currentPlayer + ", Enter the row (0-3): ");
            int row = scanner.nextInt();
            System.out.print("Player " + currentPlayer + ", Enter the column (0-3): ");
            int column = scanner.nextInt();

            if (isValidMove(row, column)) {
                makeMove(row, column);
                displayBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (checkDraw()) {
                    System.out.println("The game is a draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void displayBoard() {
        System.out.println("  0 1 2 3");
        for (int i = 0; i < 4; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
                if (j < 3) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 3) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int column) {
        return row >= 0 && row < 4 && column >= 0 && column < 4 && board[row][column] == ' ';
    }

    private static void makeMove(int row, int column) {
        board[row][column] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {

        for (int i = 0; i < 4; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == currentPlayer) || (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == currentPlayer)) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer && board[3][3] == currentPlayer) || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer && board[3][0] == currentPlayer);
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}