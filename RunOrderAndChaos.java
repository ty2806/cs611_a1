import java.util.Scanner;

public class RunOrderAndChaos extends RunGame{
    
    public RunOrderAndChaos(int gameNumber, int turnNumber) 
    {
        super(gameNumber, turnNumber);
    }

    // create 2 players
    public void setupPlayers()
    {   
        addPlayer(new Piece[] {new Piece(1, "X", "X"), new Piece(-1, "O", "O")}, 1, 0, 1, "Order");
        addPlayer(new Piece[] {new Piece(1, "X", "X"), new Piece(-1, "O", "O")}, 2, 0, 1, "Chaos");
    }

    public void run(Scanner input)
    {
        System.out.println("In Order and Chaos game, Player 1 is the Order and player 2 is the Chaos. All players have 2 marks: O and X. The Order can win the game by place at least 5 same marks in a horizontal, vertical or diagonal line. The Chaos can win if the board is full and the Order still cannot win.");

        setupBoard(6);
        
        // setup when first time starting the game
        if (resetGameSetting) {
            setupPlayers();
            setGameCount(0);
        }
        resetGameSetting = false;

        setTurnCount(0);
        // take turns
        while(true) {
            InputParser parser = new InputParser(input);

            for (Player p : getPlayers()) {
                board.printBoard();
                System.out.println("Now is " + p.getTeamName() + "'s turn.");
                printPieces(p);
                System.out.println("Place a piece by input the row number and column number of the board and the piece id as shown abova, seperated by the return key.");
                
                // read command for place pieces and determine if anyone win or in a draw
                while (true) {
                    // read row number
                    parser.parseInputToInt(1, 6);
                    if (parser.getExit() == true) {
                        exitGame();
                    }    
                    int row = parser.getParsedInt()-1;

                    // read column number
                    parser.parseInputToInt(1, 6);
                    if (parser.getExit() == true) {
                        exitGame();
                    }    
                    int column = parser.getParsedInt()-1;

                    // read piece choice
                    parser.parseInputToInt(1, 2);
                    if (parser.getExit() == true) {
                        exitGame();
                    }    
                    int pieceId = parser.getParsedInt();

                    Piece piece = p.getPiece()[pieceId-1];
                    try {
                        board.placePiece(row, column, new Piece(piece.getValue(), piece.getName(), piece.getSymbol()));
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("This location is already occupies by another piece. Try again.");
                        continue;
                    }

                    addTurnCount();

                    // determine if Order win
                    boolean isWin = isWin(row, column);
                    if (isWin) {
                        board.printBoard();
                        declareOrderWin();
                    }
                    
                    // determine if Chaos win
                    boolean isDraw = isDraw();
                    if (!isWin && isDraw) {
                        board.printBoard();
                        declareChaosWin();
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
        
        for (int i = -4; i < 5; i ++) {
            if (row+i >= 0 && row+i < board.width) {
                if (board.getPieceByLocation(row+i, column) != null && board.getPieceByLocation(row+i, column).getValue() == piece.getValue()) {
                    rowSum += 1;
                }
                else {
                    rowSum = 0;
                }
            }

            if (column+i >= 0 && column+i < board.height) {
                if (board.getPieceByLocation(row, column+i) != null && board.getPieceByLocation(row, column+i).getValue() == piece.getValue()) {
                    columnSum += 1;
                }
                else {
                    columnSum = 0;
                }
            }

            if (row+i >= 0 && row+i < board.width && column+i >= 0 && column+i < board.height) {
                if (board.getPieceByLocation(row+i, column+i) != null && board.getPieceByLocation(row+i, column+i).getValue() == piece.getValue()) {
                    diagonalSum1 += 1;
                }
                else {
                    diagonalSum1 = 0;
                }
            }

            if (row+i >= 0 && row+i < board.width && column-i >= 0 && column-i < board.height) {
                if (board.getPieceByLocation(row+i, column-i) != null && board.getPieceByLocation(row+i, column-i).getValue() == piece.getValue()) {
                    diagonalSum2 += 1;
                }
                else {
                    diagonalSum2 = 0;
                }
            }

            if (rowSum == 5 || columnSum == 5 || diagonalSum1 == 5 || diagonalSum2 == 5) {
                return true;
            }
        }
        return false;
    }

    public void declareOrderWin() 
    {   
        addGameCount();
        for (Player p: players) {
            if (p.getTeamName().equals("Order")) {
                p.addWinCount();
                System.out.println("Player " + p.getId() + " has won!");
            }
        }
    }

    public void declareChaosWin() 
    {
        addGameCount();
        for (Player p: players) {
            if (p.getTeamName().equals("Chaos")) {
                p.addWinCount();
                System.out.println("Player " + p.getId() + " has won!");
            }
        }
    }
}
