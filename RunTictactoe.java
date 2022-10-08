import java.util.Scanner;

public class RunTictactoe extends RunGame {

    public RunTictactoe(int gameNumber, int turnNumber) 
    {
        super(gameNumber, turnNumber);
    }

    // create 2 players
    public void setupPlayers()
    {   
        addPlayer(new Piece[] {new Piece(1, "X", "X")}, 1, 0);
        addPlayer(new Piece[] {new Piece(-1, "O", "O")}, 2, 0);
    }

    public void run(Scanner input)
    {
        System.out.println("In this tic tac toe game, 2 players take turns to place their marks on board. The first one who places his marks in a horizontal, vertical or diagonal line is the winner.");

        System.out.print("Please specify board size. \n" + 
                         "The minimum board is 3x3 and maximum board is 30x30. \n" +
                         "choose a board size by input an integer from 3 to 30. \n");
        // read board size from terminal
        InputParser parser = new InputParser(input);
        parser.parseInputToInt(3, 30);
        if (parser.getExit() == true) {
            exitGame();
        }    
        int size = parser.getParsedInt();

        setupBoard(size);
        
        // setup when first time starting the game
        if (resetGameSetting) {
            setupPlayers();
            setGameCount(0);
        }
        resetGameSetting = false;

        setTurnCount(0);
        // take turns
        while(true) {
            for (Player p : getPlayers()) {
                board.printBoard();
                System.out.println("Now is player " + p.getId() + "'s turn.");
                printPieces(p);
                System.out.println("Place a piece by input the row number and column number of the board, seperated by the return key.");
                
                Piece piece = p.getPiece()[0];
                // read command for place pieces and determine if anyone win or in a draw
                while (true) {
                    // read row number
                    parser.parseInputToInt(1, size);
                    if (parser.getExit() == true) {
                        exitGame();
                    }    
                    int row = parser.getParsedInt()-1;

                    // read column number
                    parser.parseInputToInt(1, size);
                    if (parser.getExit() == true) {
                        exitGame();
                    }    
                    int column = parser.getParsedInt()-1;
                    
                    // place pieces
                    try {
                        board.placePiece(row, column, new Piece(piece.getValue(), piece.getName(), piece.getSymbol()));
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("This location is already occupies by another piece. Try again.");
                        continue;
                    }

                    addTurnCount();

                    // determine if anyone win
                    boolean isWin = isWin(row, column);
                    if (isWin) {
                        board.printBoard();
                        declareWinner(p);
                    }
                    
                    // determine if the game is in a draw
                    boolean isDraw = isDraw();
                    if (!isWin && isDraw) {
                        board.printBoard();
                        declareDraw();
                    }

                    // determine if player hope to play a new game or exit
                    if (isWin || isDraw) {
                        boolean isEnd = finishGame(input);
                        if (isEnd) {
                            exitGame();
                        }
                        else {
                            return;
                        }
                    }
                    break;
                }
                
            }

        }
    }

    public boolean isDraw()
    {   
        System.out.println("turn count: " + turnCount + " board area: " + board.area + " game count: " + gameCount);
        if (turnCount == board.area) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isWin(int row, int column) 
    {
        Piece piece = board.getPieceByLocation(row, column);
        int rowSum = 0;
        int columnSum = 0;
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < board.height; i ++) {
            if (board.getPieceByLocation(i, column) != null) {
                rowSum += board.getPieceByLocation(i, column).getValue();
            }

            if (board.getPieceByLocation(row, i) != null) {
                columnSum += board.getPieceByLocation(row, i).getValue();
            }

            if (row == column) {
                if (board.getPieceByLocation(i, i) != null) {
                    diagonalSum1 += board.getPieceByLocation(i, i).getValue();
                }
            }

            if (row + column == board.height-1) {
                if (board.getPieceByLocation(i, board.height-1-i) != null) {
                    diagonalSum2 += board.getPieceByLocation(i, board.height-1-i).getValue();
                }
            }
        }

        int total = piece.getValue()*board.height;
        if (rowSum == total || columnSum == total || diagonalSum1 == total || diagonalSum2 == total) {
            return true;
        }
        else {
            return false;
        }
    }

    public void declareWinner(Player p) 
    {
        p.addWinCount();
        addGameCount();
        System.out.println("Player " + p.getId() + " has won!");
    }

    public void declareDraw() 
    {
        addGameCount();
        System.out.println("The game is in a draw!");
    }

}
