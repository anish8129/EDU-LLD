# BattleShip Game - README

## Overview
Design and implement a battleship game to be played between two players until one emerges as the winner. The game is played on an NxN grid battlefield, divided equally between both players. Each player places square-shaped ships on their half of the battlefield, and they take turns firing missiles at random coordinates on the opponent's side.

---

## Requirements

### Game Setup
- The battlefield is a square grid of size NxN, where N is provided as input.
- The battlefield is divided equally between Player A (left half) and Player B (right half).
- Each player places their ships on their respective halves of the battlefield.

### Ships
- Ships are square-shaped, and their size and location are provided as input.
- The location of a ship is specified by its center coordinates (X, Y).
- Ships must not overlap but can touch each other's boundaries.
- Both players must have an equal number of ships.

### Gameplay
- Players take turns firing missiles at random coordinates on the opponent's battlefield.
    - If a missile hits an opponent's ship, the ship is destroyed.
    - If a missile misses, the turn passes to the other player.
- No two missiles can target the same coordinates during the game.
- The game ends when all ships of one player are destroyed, declaring the other player the winner.

---

## APIs to Implement

### Mandatory APIs

#### `initGame(N)`
- Initializes the game with an NxN battlefield.
- The left half (N/2 x N) is assigned to Player A, and the right half is assigned to Player B.

#### `addShip(id, size, xA, yA, xB, yB)`
- Adds a ship of the given size to both players' fleets.
    - `id`: Unique identifier for the ship.
    - `size`: Size of the ship (square side length).
    - `xA, yA`: Center coordinates for Player A's ship.
    - `xB, yB`: Center coordinates for Player B's ship.

#### `startGame()`
- Begins the game with Player A taking the first turn.
- Outputs each turn's result to the console, including missile coordinates, hit/miss status, and remaining ships.

### Optional API

#### `viewBattleField()`
- Displays the current state of the battlefield as an NxN grid.
- Player A's ships are marked as `A-SH1`, `A-SH2`, etc.
- Player B's ships are marked as `B-SH1`, `B-SH2`, etc.
- Shows all grids occupied by each ship, not just the center coordinates.

---

## Guidelines
- Use in-memory data structures to store game data.
- Print output to the console.
- Design the application to allow easy implementation of alternative firing strategies.
- Maintain clear separation between data and service layers.

---

## Expectations
- Code must cover all mandatory functionalities.
- Code should be executable, clean, and well-refactored.
- Handle exceptions gracefully and display appropriate error messages for invalid inputs.
- Follow object-oriented principles and ensure scalability.

---

## Evaluation Criteria
- **Functionality**: Code must work as expected.
- **Code Quality**: Readability, testability, and separation of concerns.
- **Abstraction**: Proper use of abstraction and encapsulation.
- **Object-Oriented Design**: Effective use of OOP concepts.
- **Language Proficiency**: Mastery of the programming language.
- **Scalability**: Design should accommodate future enhancements.
- **Test Coverage**: Bonus points for comprehensive test coverage.

---

## Sample Execution

```plaintext
>> initGame(6)
>> addShip("SH1", size=2, 1, 5, 4, 4)
>> viewBattleField()

| A-SH1 | A-SH1 |     |     |     |     |
| A-SH1 | A-SH1 |     |     |     |     |
|       |       |     | B-SH1 | B-SH1 |     |
|       |       |     | B-SH1 | B-SH1 |     |
|       |       |     |     |     |     |
|       |       |     |     |     |     |

>> startGame()
PlayerA's turn: Missile fired at (3, 0) : "Miss" : Ships Remaining - PlayerA:1, PlayerB:1
PlayerB's turn: Missile fired at (1, 1) : "Miss" : Ships Remaining - PlayerA:1, PlayerB:1
PlayerA's turn: Missile fired at (5, 3) : "Hit" B-SH1 destroyed : Ships Remaining - PlayerA:1, PlayerB:0
Game Over. PlayerA wins.
```