# CS611-<01>
## <Tic Tac Toe and other variants>
---------------------------------------------------------------------------
<Ye Tian>
<ty2806@bu.edu>
<U18899591>

## Files
---------------------------------------------------------------------------
GameBoard.java: The board class of the game. It contains a 2d array of Piece class and have methods for set and get board size, place to and get piece from a board location, and print the board.

InputParser.java: Analyse user's input from console and filter invalid input.

Main.java: Main method is responsible to start the application and ask user to choose games.

Piece.jave: This class represent a game token. It records this token's name, value and the shape it is printed on screen.

Player.java: This class represent a player. It records what pieces a player is legal to use and player's basic infos like id and team name. It also keeps statistics of a player like how many games he won.

RunGame.java: This is an abstract class. It contains a game's statistics like the number of games played, how many players a game have, and other common method useful during game running.

RunTictactoe.java and RunOrderAndChaos.java: These 2 classes inherit RunGame class. They run tic tack toe and Order and Chaos respectively by using run method. They also implement methods for determine who wins and declare winner.

## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>
2. <Bonus Done>
3. <Notes to grader>

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "cs611_a1" after unzipping the files
2. Run the following instructions:
javac *.java
java Main

## Input/Output Example
---------------------------------------------------------------------------
Welcome to console Board Games!
 In this program, you can always exit the game by typing "exit"
Currently there are 2 games available.
[1] Tic Tac Toe
[2] Order and Chaos
Please enter corresponding integer to choose game.
1
In this tic tac toe game, 2 players take turns to place their marks on board. The first one who places his marks in a horizontal, vertical or diagonal line is the winner.
Please specify board size.
The minimum board is 3x3 and maximum board is 30x30.
choose a board size by input an integer from 3 to 30.
3
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Now is player 1's turn.
The pieces Player 1 hold are :[1: X]
Place a piece by input the row number and column number of the board, seperated by the return key.
1
1
turn count: 1 board area: 9 game count: 0
+---+---+---+
| X |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Now is player 2's turn.
The pieces Player 2 hold are :[1: O]
Place a piece by input the row number and column number of the board, seperated by the return key.
1
2
turn count: 2 board area: 9 game count: 0
+---+---+---+
| X | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   |   |
+---+---+---+
Now is player 1's turn.
The pieces Player 1 hold are :[1: X]
Place a piece by input the row number and column number of the board, seperated by the return key.
3
3
turn count: 3 board area: 9 game count: 0
+---+---+---+
| X | O |   |
+---+---+---+
|   |   |   |
+---+---+---+
|   |   | X |
+---+---+---+
Now is player 2's turn.
The pieces Player 2 hold are :[1: O]
Place a piece by input the row number and column number of the board, seperated by the return key.
2
2
turn count: 4 board area: 9 game count: 0
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   |   | X |
+---+---+---+
Now is player 1's turn.
The pieces Player 1 hold are :[1: X]
Place a piece by input the row number and column number of the board, seperated by the return key.
3
2
turn count: 5 board area: 9 game count: 0
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
|   | X | X |
+---+---+---+
Now is player 2's turn.
The pieces Player 2 hold are :[1: O]
Place a piece by input the row number and column number of the board, seperated by the return key.
3
1
turn count: 6 board area: 9 game count: 0
+---+---+---+
| X | O |   |
+---+---+---+
|   | O |   |
+---+---+---+
| O | X | X |
+---+---+---+
Now is player 1's turn.
The pieces Player 1 hold are :[1: X]
Place a piece by input the row number and column number of the board, seperated by the return key.
1
3
turn count: 7 board area: 9 game count: 0
+---+---+---+
| X | O | X |
+---+---+---+
|   | O |   |
+---+---+---+
| O | X | X |
+---+---+---+
Now is player 2's turn.
The pieces Player 2 hold are :[1: O]
Place a piece by input the row number and column number of the board, seperated by the return key.
2
1
turn count: 8 board area: 9 game count: 0
+---+---+---+
| X | O | X |
+---+---+---+
| O | O |   |
+---+---+---+
| O | X | X |
+---+---+---+
Now is player 1's turn.
The pieces Player 1 hold are :[1: X]
Place a piece by input the row number and column number of the board, seperated by the return key.
2
3
+---+---+---+
| X | O | X |
+---+---+---+
| O | O | X |
+---+---+---+
| O | X | X |
+---+---+---+
Player 1 has won!
turn count: 9 board area: 9 game count: 1
Thanks for playing!
Would you like to play again?
[y/n]
n
Thanks for playing!
Player 1 had won 1 times from 1 games.
Player 2 had won 0 times from 1 games.
Goodbyb.
