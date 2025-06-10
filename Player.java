import java.util.Random;
import java.util.Scanner;

public abstract class Player {
    protected String name;
    protected char mark;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }
    
    public char getMark() {
        return mark;
    }

    public abstract int[] makeMOve(Board opponentBoard);
}


class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, char mark, Scanner scanner) {
        super(name, mark);
        this.scanner = scanner;
    }

    /**
     * Prompts the human player to input their target coordinates on the opponent's board.
     * Validates the input to ensure it is within bounds and not already targeted.
     * 
     * @param opponentBoard The board of the opponent where the player will target.
     * @return An array containing the row and column indices of the targeted position.
     */
    @Override
    public int[] makeMOve(Board opponentBoard) {
        int row = -1;
        int col = -1;
        boolean validInput = false;

        while(!validInput){
            try {
                System.out.println(name + ", enter your target (row[1-" + opponentBoard.size() + "] col[1-" + opponentBoard.size() + "]):");
                System.out.print("Row: ");
                row = scanner.nextInt() - 1;
                System.out.print("Column: ");
                col = scanner.nextInt() - 1;
                if (opponentBoard.isValidCoordinate(row, col)) {
                    // Check the current status of the targeted spot on the opponent's board
                    char currentTargetStatus = opponentBoard.getPosition(row, col);
                    // If the spot has already been hit or missed, inform the player
                    if (currentTargetStatus == opponentBoard.getHitChar() || currentTargetStatus == opponentBoard.getMissChar()) {
                        System.out.println("You've already targeted this spot. Please choose another.");
                    } else {
                        validInput = true; // Input is valid and spot is untargeted
                    }
                } else {
                    // Inform player about out-of-bounds input
                    System.out.println("Invalid coordinates. Row and column must be between 1 and " + opponentBoard.size() + ".");
                }
            } catch (java.util.InputMismatchException e) {
                // Handle cases where non-integer input is provided
                System.out.println("Invalid input. Please enter numbers for row and column.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
        return new int[]{row, col};
    }            
}

class CpuPlayer extends Player {
    private Random random;

    public CpuPlayer(String name, char mark) {
        super(name, mark);
        this.random = new Random();
    }

    @Override
    public int[] makeMOve(Board opponentBoard) {
        int row, col;
        do {
            row = random.nextInt(opponentBoard.size());
            col = random.nextInt(opponentBoard.size());
            char currentTargetStatus = opponentBoard.getPosition(row, col);

            if (currentTargetStatus != opponentBoard.getHitChar() && currentTargetStatus != opponentBoard.getMissChar()) {
                // If the spot is valid and not already targeted, break the loop
                break;
            }
        } while (true);
        System.out.println(name + " chooses (" + (row + 1) + ", " + (col + 1) + ")");
        return new int[]{row, col};
    }
}
