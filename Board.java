import java.util.Arrays;
import java.util.Random;

public class Board {
    // Define board properties
    private char[][] grid;
    private int size;
    private char water;
    private char ship;
    private char hit;
    private char miss;

    // Constructor to initialize the board with specified parameters
    // and place ships randomly
    public Board(int size, char waterChar, char shipChar, char hitChar, char missChar, int numShips) {
        this.size = size;
        this.water = waterChar;
        this.ship = shipChar;
        this.hit = hitChar;
        this.miss = missChar;
        this.grid = new char[size][size];

        for (char[] row : this.grid) {
            Arrays.fill(row, this.water);
        }

        placeShips(numShips);
    }
    
    public char getPosition(int row, int col) {
        return grid[row][col];
    }

    public void setPosition(int row, int col, char mark) {
        grid[row][col] = mark;
    }

    public boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean hasShip(int row, int col) {
        return grid[row][col] == ship;
    }

    public void printBoard(boolean showShips) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < size; col++) {
                char position = grid[row][col];
                if (!showShips && position == ship) {
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void placeShips(int numShips) {
        Random random = new Random();
        int shipsPlaced = 0;

        while (shipsPlaced < numShips) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            if (grid[row][col] == water) {
                grid[row][col] = ship;
                shipsPlaced++;
            }
        }
    }

    // Check if all ships on the board are sunk
    public boolean areAllShipsSunk() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == ship) {
                    return false;
                }
            }
        }
        return true;
    }

    // New getter methods for Board properties, used by Player classes
    public int size() { return size; }
    public char getHitChar() { return hit; }
    public char getMissChar() { return miss; }
}
