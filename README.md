# ⚓ Battleship Game

---
## Project Overview

This is a classic **Battleship game** built in **Java**, designed for a console environment. Play against a CPU opponent, put your tactical skills to the test, and see fundamental game logic and **Object-Oriented Programming (OOP)** principles in action.

---
## Features

* **Human vs. CPU Gameplay**: Challenge a computer opponent.
* **5x5 Game Board**: A standard grid for focused tactical play.
* **Random Ship Placement**: Ships are randomly positioned on both player and CPU boards at the start of each game, ensuring a fresh experience every time.
* **Hit/Miss Tracking**: Clearly see your hits (`X`) and misses (`O`) on the opponent's board.
* **Win/Loss Condition**: The game ends when all of one player's ships are sunk.
* **Clear Console Output**: Enjoy a user-friendly display of game boards and turn information.

---
## How to Play
1.  **Start the Game**: Run the `BattleshipGame` class.
2.  **Your Board**: You'll first see your own 5x5 board with your ships (`S`) clearly marked.
3.  **CPU's Board (Your Target)**: Below that, you'll see the CPU's board, your target area. All ships on the CPU's board are hidden (`~` for water).
4.  **Take Your Turn**: When it's your turn, you'll be prompted to enter row and column coordinates (e.g., "**1 3**" for Row 1, Column 3).
    * If you **hit** a ship, the spot will be marked `X`.
    * If you **miss**, the spot will be marked `O`.
5.  **CPU's Turn**: The CPU will then make a random move, and the result will be shown.
6.  **Victory/Defeat**: The game continues in turns until all ships on either your board or the CPU's board are sunk.

---
## How to Run the Code

This project is a console-based Java application.

### Prerequisites

* **Java Development Kit (JDK) 11** or newer installed.
* A terminal or command prompt (e.g., WSL, Git Bash, macOS Terminal, Windows Command Prompt/PowerShell).

### Steps

1.  **Save the Files**: Ensure you have the following three `.java` files saved in the same directory:
    * `Board.java`
    * `Player.java`
    * `BattleshipGame.java`

2.  **Navigate to the Directory**: Open your terminal or command prompt and navigate to the directory where you saved these files.
    ```bash
    cd path/to/your/battleship-project
    ```
    *(If using WSL, ensure you're operating within your WSL Linux filesystem, e.g., `/home/youruser/battleship-project`)*

3.  **Compile the Code**: Use the Java compiler (`javac`) to compile all source files:
    ```bash
    javac Board.java Player.java BattleshipGame.java
    ```

4.  **Run the Game**: Execute the main `BattleshipGame` class:
    ```bash
    java BattleshipGame
    ```

---
## Technologies Used

* **Java**: The core programming language.
* **Standard Java Library**: Utilized `java.util.Scanner` for input, `java.util.Random` for random number generation, and `java.util.Arrays` for array manipulation.

---
## Object-Oriented Principles Demonstrated

This project is structured to showcase key **OOP concepts**:

* **Encapsulation**:
    * The `Board` class encapsulates all board-related data (the grid, size, character representations) and behaviors (placing ships, checking positions, printing). Internal implementation details like the grid are kept private.
    * `Player` subclasses encapsulate their specific move-making logic.
* **Abstraction**:
    * The `Player` class is an abstract class, defining a common interface (`makeMove`) for all types of players without specifying the exact implementation.
* **Inheritance**:
    * `HumanPlayer` and `CpuPlayer` extend the `Player` abstract class, inheriting common properties and behaviors, and providing their unique implementations of the `makeMove` method.
* **Polymorphism**:
    * The `BattleshipGame` class interacts with `Player` objects polymorphically (e.g., `currentPlayer.makeMove()`). The same method call behaves differently depending on whether `currentPlayer` is a `HumanPlayer` or a `CpuPlayer`.

---
## Future Enhancements (Ideas for further development)

* **Graphical User Interface (GUI)**: Implement a GUI using JavaFX or Swing for a more interactive visual experience.
* **Different Ship Sizes**: Allow for ships of varying lengths (e.g., destroyer, cruiser, battleship).
* **More Complex AI**: Develop a more sophisticated CPU opponent that can strategize (e.g., target adjacent squares after a hit).
* **Player Input Validation**: Add more robust input validation (e.g., checking for specific command keywords).
* **Multiple Rounds**: Allow players to play multiple rounds.
* **Two-Player Mode**: Implement a mode for two human players.