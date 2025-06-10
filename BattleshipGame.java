import java.util.Scanner;

public class BattleshipGame {
    // Define board and ship constants
    private static final int boardLength = 5;
    private static final int numOfShips = 4;
    private static final char water = '~';
    private static final char ship = 'S';
    private static final char hit = 'X';
    private static final char miss = 'O';

    // Declare game components
    private Board playerBoard;
    private Board cpuBoard;
    private HumanPlayer humanPlayer;
    private CpuPlayer cpuPlayer;
    private Scanner scanner;

    public BattleshipGame(){
        scanner = new Scanner(System.in);
        // Initialize the player & cpu board with the specified parameters
        playerBoard = new Board(boardLength, water, ship, hit, miss, numOfShips);
        cpuBoard = new Board(boardLength, water, ship, hit, miss, numOfShips);

        // Initialize players
        humanPlayer = new HumanPlayer("You", hit, scanner);
        cpuPlayer = new CpuPlayer("CPU", hit);
    }

    public void startGame() {
        System.out.println("Welcome to Battleship!");
        System.out.println("Your board:");
        playerBoard.printBoard(true);
        System.out.println("CPU's board:");
        cpuBoard.printBoard(false);

        boolean gameOver = false;
        while (!gameOver) {
            // Human player's turn
            int[] humanMove = humanPlayer.makeMOve(cpuBoard);
            int humanRow = humanMove[0];
            int humanCol = humanMove[1];

            // Validate the move
            if (cpuBoard.hasShip(humanRow, humanCol)) {
                cpuBoard.setPosition(humanRow, humanCol, hit);
                System.out.println("Hit!");
            } else {
                cpuBoard.setPosition(humanRow, humanCol, miss);
                System.out.println("Miss!");
            }
            cpuBoard.printBoard(false);

            // Check if CPU is defeated
            if (cpuBoard.areAllShipsSunk()) {
                System.out.println("You win!");
                gameOver = true;
                break;
            }

            // CPU player's turn
            int[] cpuMove = cpuPlayer.makeMOve(playerBoard);
            int cpuRow = cpuMove[0];
            int cpuCol = cpuMove[1];

            if (playerBoard.hasShip(cpuRow, cpuCol)) {
                playerBoard.setPosition(cpuRow, cpuCol, hit);
                System.out.println("CPU hit your ship!");
            } else {
                playerBoard.setPosition(cpuRow, cpuCol, miss);
                System.out.println("CPU missed.");
            }
            playerBoard.printBoard(true);

            // Check if player is defeated
            if (playerBoard.areAllShipsSunk()) {
                System.out.println("CPU wins!");
                gameOver = true;
            }
        }

        scanner.close();
    }

    public static void main(String[] args){
        // Create a new BattleshipGame instance
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}