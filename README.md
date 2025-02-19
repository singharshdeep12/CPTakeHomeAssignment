# Game of Life

## Software Design Document

### Revision History
| Date       | Reviewed By      | Comments                  |
|------------|----------------|---------------------------|
| 16/02/2025 | Arshdeep Singh | Created design document  |

---

## 1. Introduction

### 1.1 Project Name
**Game of Life**

### 1.2 Purpose
The Game of Life is a simple simulation where cells live, die, or multiply based on a set of predefined rules. The game begins with an initial pattern and evolves over multiple generations. 
This project implements a **console-based version**, handling the logic, user input, and dynamic display of the grid.

### 1.3 Scope
This project focuses on implementing the **Game of Life** algorithm as a **console-based application**. It includes:
- Initializing the game grid.
- Running the simulation for a specified number of generations.
- Displaying the evolving patterns.

The design follows a modular approach with separate components for **game logic, user input handling, and display**.

---

## 2. High-Level Architecture

The **Game of Life** project is designed with a structured and modular approach to ensure **clean, maintainable, and extensible code**. The architecture consists of several layers:

### 2.1 Main Layer (main)
- **Application**: Entry point that initializes and starts the game.

### 2.2 Game Logic Layer (game)
- **Game (Interface)**: Defines the structure for any game implementation.
- **GameOfLife**: Implements the Game interface and contains logic to evolve generations based on rules.
- **GameType**: Used to define different game types.

### 2.3 Game Runner Layer (gamerunner)
- **GameRunner (Interface)**: Defines how a game should execute.
- **GameOfLifeRunner**: Implements GameRunner to manage the execution of the Game of Life.

### 2.4 Factory Layer (factory)
- **GameFactory**: Creates instances of different Game implementations.
- **GameRunnerFactory**: Creates instances of GameRunner dynamically.

### 2.5 Utility Layer (util)
- **GameOfLifeUtils**: Generates initial patterns and manages console display.
- **MatrixUtils**: Provides matrix-related operations like deep copying.
- **InputUtils**: Handles user input validation.

### 2.6 Constants Layer (constants)
- **Constants**: Stores grid size, symbols, and other fixed values.

---

## 3. Flow of Execution
1. **Application** starts and initializes the game components.
2. **GameFactory** creates an instance of GameOfLife.
3. **GameRunnerFactory** provides an appropriate GameRunner.
4. **GameOfLifeRunner** executes the game logic, managing user input and simulation steps.
5. The grid updates and prints to the console at each generation.

---

## 4. Class Design & Responsibilities

The project follows a modular structure, with clear responsibilities assigned to each class:

### 4.1 Game (Interface)
- Defines start(), run(), and stop() methods.
- Ensures consistency for any game implementation.

### 4.2 GameOfLife (Implements Game)
- Implements the core **Game of Life** logic.
- Initializes the grid, runs generations, and applies game rules.
- Uses **utility classes** for matrix operations and neighbor calculations.

### 4.3 GameRunner (Interface)
- Abstracts the execution of a game.

### 4.4 GameOfLifeRunner (Executes GameOfLife)
- Calls start(), run(), and stop() on the game.

### 4.5 Utility Classes
#### GameOfLifeUtils
- Generates an initial **Glider** pattern.
- Calculates **live neighbors** for each cell.
- Handles **grid display** using symbols.

#### MatrixUtils
- Provides a **deep copy function** for the 2D grid.

#### InputUtils
- Handles **user input validation** (grid size, generations).

### 4.6 Constants
- Stores game-related fixed values (symbols, sleep delays, neighbor positions).

---

## 5. Key Design Decisions

### 5.1 Modular Design
- Separation of concerns ensures better **maintainability** and **extensibility**.

### 5.2 Factory Pattern for Game & GameRunner
- **GameFactory** and **GameRunnerFactory** allow dynamic creation of game instances, supporting future scalability.

### 5.3 Utility Classes for Reusability
- **Common operations** (matrix handling, input validation, grid display) are placed in dedicated helper classes.

### 5.4 Thread Sleep for Simulation Speed Control
- **Thread.sleep()** is used to control simulation speed and enhance user experience.

### 5.5 Centralized Constants
- All **fixed values** are stored in a separate Constants class for easy modifications.

### 5.6 Prevention of Utility Class Instantiation
- Utility classes have **private constructors** to prevent instantiation.

### 5.7 Simplified Game Interface
- The Game interface enforces a **consistent structure**, making future extensions easier.

---

## 6. Future Enhancements

Currently, the game is implemented as a **console-based application** due to time constraints. However, three possible output options were considered:

### 6.1 Output Options Considered:
1. **Console-based (Current Choice)**: Chosen for simplicity and faster development.
2. **Swing-based UI**: A Java Swing graphical version for an interactive experience.
3. **Web-based UI (React, etc.)**: A modern, browser-based version for broader accessibility.

### 6.2 Possible Future Features:
1. **User-Defined Patterns**
   - Allow users to create custom initial setups via **command-line input, files, or a GUI editor**.

2. **Game Speed Control**
   - Let users **adjust speed dynamically** or **pause and resume the simulation**.

3. **Better Performance**
   - Optimize memory usage by storing **only live cells**, enabling **larger grid support**.

4. **Saving & Resuming Games**
   - Save game states in **JSON/XML** or a **database**.

5. **Logging & Debugging Tools**
   - Add **detailed logs** for tracking each step of the simulation and debugging issues.

---

## Conclusion
This project provides a well-structured and extensible implementation of **Game of Life** in Java. The modular approach ensures that future enhancements, such as a GUI version or additional game rules, can be easily incorporated.

