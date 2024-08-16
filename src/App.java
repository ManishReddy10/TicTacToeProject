
import java.util.Scanner;

public class App {
    private static String[][] TTTboard;
    public static void main(String[] args) throws Exception {
        String Player1 = "X";
        String Player2 = "O";
        
        TTTboard = new String[3][3];
        int counter = 1;

        Scanner input = new Scanner(System.in);

        // Make the board playable
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TTTboard[row][col] = "" + counter;
                counter++;
            }
        }

        System.out.println("Let's play tic tac toe!");

        System.out.println("[0] For pvp [1] for pve");
        int pvpOrPveInt = input.nextInt();

        boolean didPlayer1ActuallyWin = false;
        boolean didPlayer2ActuallyWin = false;
        if (pvpOrPveInt == 0) {
            
            while (!didPlayer1ActuallyWin && !didPlayer2ActuallyWin) {
                // ask for input
                System.out.println("Player 1 (x) pick a square.");
                PrintBoard();
                String choice = input.nextInt() + "";

                UpdateBoard(choice, Player1);
                PrintBoard();

                didPlayer1ActuallyWin = DidPlayerWin(Player1);
                if(didPlayer1ActuallyWin) {
                    System.out.println("Player 1 wins!");
                    break;
                }

                System.out.println("Player 2 (O) pick a square");
                choice = input.nextInt() + "";
                UpdateBoard(choice, Player2);
                PrintBoard();

                didPlayer2ActuallyWin = DidPlayerWin(Player2);
                if(didPlayer2ActuallyWin) {
                    System.out.println("Player 2 wins!");
                    break;
                }
            }
        } else {
                while (!didPlayer1ActuallyWin && !didPlayer2ActuallyWin) {
                // ask for input
                System.out.println("Player 1 (x) pick a square.");
                PrintBoard();
                String choice = input.nextInt() + "";

                UpdateBoard(choice, Player1);
                PrintBoard();

                didPlayer1ActuallyWin = DidPlayerWin(Player1);
                if(didPlayer1ActuallyWin) {
                    System.out.println("Player 1 wins!");
                    break;
                }

                System.out.println("Player 2 (O) pick a square");
                choice = input.nextInt() + "";
                UpdateBoard(choice, Player2);
                PrintBoard();

                didPlayer2ActuallyWin = DidPlayerWin(Player2);
                if(didPlayer2ActuallyWin) {
                    System.out.println("Player 2 wins!");
                    break;
                }
            }

        }

        
        
    }

    public static void PrintBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(TTTboard[row][col] );
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("--------");
            }
        }
    }

    public static void UpdateBoard(String choice, String User) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (choice.equals(TTTboard[row][col]) ) {
                    TTTboard[row][col] = User;
                }
            }
        }
    }

    public static boolean DidPlayerWin(String player) {
        // check rows
        for (int r = 0; r < TTTboard.length; r++) {
            if (TTTboard[r][0].equals(player) && TTTboard[r][1].equals(player) && TTTboard[r][2].equals(player)) {
                return true;
            }
        }

        // check columns
        for (int c = 0; c < TTTboard[0].length; c++) {
            if (TTTboard[0][c].equals(player) && TTTboard[1][c].equals(player) && TTTboard[2][c].equals(player)) {
                return true;
            }
        }

        // check diagonals
        if (TTTboard[0][0].equals(player) && TTTboard[1][1].equals(player) && TTTboard[2][2].equals(player)) {
            return true;
        }
        if (TTTboard[0][2].equals(player) && TTTboard[1][1].equals(player) && TTTboard[2][0].equals(player)) {
            return true;
        }

        return false;
    }
}
