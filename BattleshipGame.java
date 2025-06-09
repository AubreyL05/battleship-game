public class BattleshipGame {
    // Define board and ship constants
    private static final int boardLength = 5;
    private static final int numOfShips = 4;

    private static final char water = '~';
    private static final char ship = 'S';
    private static final char hit = 'X';
    private static final char miss = 'O';

    public static void main(String[] args) {
        // Create a new Board instance
        Board myBoard = new Board(boardLength, water, ship, hit, miss, numOfShips);

        // Print the board, showing your ships ('true' to show ships)
        System.out.println("Your Battleship Board:");
        myBoard.printBoard(true);
    }
}