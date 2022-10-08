
public class GameBoard {
    protected Piece[][] board;
    protected int width;
    protected int height;
    protected int area;
    protected int pieceNumber;

    // Construct board by width w and height h
    public GameBoard(int w, int h)
    {
        setBoard(w, h);
        calculateArea();
    }

    // Construct square board by side size s
    public GameBoard(int s)
    {
        setBoard(s, s);
        calculateArea();
    }

    // Set size of the board by width w and height h
    public void setBoard(int w, int h)
    {   
        if (w <= 0 || h <= 0) {
            throw new IllegalArgumentException();
        }
        board = new Piece[w][h];
        width = w;
        height = h;
        calculateArea();
    }

    // Clear all game pieces placed on the board and reset the board to original state
    public void resetBoard()
    {
        board = new Piece[width][height];
    }

    public void calculateArea()
    {
        area = height * width;
    }

    // place a game piece on the board
    public void placePiece(int w, int h, Piece p)
    {
        if (w < 0 || w >= width || h < 0 || h >= height || board[w][h] != null) {
            throw new IllegalArgumentException();
        }
        board[w][h] = p;
    }

    // get board info
    public Piece[][] getBoard()
    {
        return board;
    }

    // get piece from board
    public Piece getPieceByLocation(int w, int h)
    {   
        if (w < 0 || w >= width || h < 0 || h >= height) {
            throw new IllegalArgumentException();
        }
        return board[w][h];
    }

    // Print current board to console
    public void printBoard()
    {
        for(int j = 0; j < height*2+1; j ++) {
            for(int i = 0; i < width; i ++) {
                if(j % 2 != 0) {
                    String cell = " ";
                    if (getPieceByLocation((j-1)/2, i) != null) {
                        cell = getPieceByLocation((j-1)/2, i).getSymbol();
                    }
                    System.out.print("| " + cell + " ");
                }
                else {
                    System.out.print("+---");
                }
            }
            if(j % 2 != 0) {
                System.out.print("|");
            }
            else {
                System.out.print("+");
            }
            System.out.println();
        }
    }
}
