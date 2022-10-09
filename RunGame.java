import java.util.ArrayList;
import java.util.Scanner;

abstract public class RunGame {
    protected GameBoard board;
    protected int gameCount; // count the number of games played
    protected int turnCount; // count turns for each game
    protected ArrayList<Player> players;
    protected int playerNumber;
    protected boolean resetGameSetting; //determine should we reset players and global statistics

    // construct RunGame by specify game count and turn count
    public RunGame(int gameNumber, int turnNumber)
    {
        setGameCount(gameNumber);
        setTurnCount(turnNumber);
        resetPlayers();
        resetGameSetting = true;
    }

    // specify game count to a given number
    public void setGameCount(int count)
    {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        gameCount = count;
    }

    // increment game count by 1
    public void addGameCount()
    {
        gameCount += 1;
    }

    // specify turn count to a given number
    public void setTurnCount(int count)
    {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        turnCount = count;
    }

    // increment turn count by 1
    public void addTurnCount()
    {
        turnCount += 1;
    }

    // empty player list
    public void resetPlayers()
    {
        players = new ArrayList<Player>();
        playerNumber = 0;
    }

    // create a player to and add it to player list
    public void addPlayer(Piece[] pieces, int id, int count)
    {
        Player p = new Player(pieces, id, count);
        players.add(p);
        playerNumber += 1;
    }

    // create a player with team attributes to and add it to player list
    public void addPlayer(Piece[] pieces, int id, int count, int teamId, String teamName)
    {
        Player p = new Player(pieces, id, count, teamId, teamName);
        players.add(p);
        playerNumber += 1;
    }

    // return player list
    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    // create a new board by specify width and height
    public void setupBoard(int w, int h)
    {
        board = new GameBoard(w, h);
    }

    // create a new square board by specify side length
    public void setupBoard(int s)
    {
        board = new GameBoard(s);
    }

    // print all pieces a player has
    public static void printPieces(Player p)
    {
        Piece[] pieces = p.getPiece();

        System.out.print("The pieces Player " + p.getId() + " hold are :");
        for (int i = 1; i < pieces.length+1; i++) {
            System.out.print("[" + i + ": " + pieces[i-1].getName() + "] ");
        }
        System.out.println();
    }

    // ask user if he'd like to play a new game
    public boolean finishGame(Scanner sc)
    {
        System.out.println("Thanks for playing!");
        System.out.println("Would you like to play again?");
        System.out.println("[y/n]");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("y") || line.equals("n")) {
                if (line.equals("y")) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                System.out.println("Please only input y or n to choose");
            }
        }
    }

    // close the application
    public void exitGame()
    {
        System.out.println("Thanks for playing!");
        if (players.size() > 0) {
            for (Player p : players) {
                System.out.println("Player " + p.getId() + " had won " + p.getWinCount() + " times from " + gameCount + " games.");
            }
        }
        System.out.println("Goodbyb.");
        System.exit(0);
    }

    // initiate players at the beginning of a game
    abstract public void setupPlayers();

    // main process to run the game
    abstract public void run(Scanner input);
}
