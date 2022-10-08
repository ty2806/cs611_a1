import java.util.Scanner;

class Main {
    
    public static void main(String[] args) {
        // create game running objects
        RunTictactoe runner1 = new RunTictactoe(0, 0);
        RunOrderAndChaos runner2 = new RunOrderAndChaos(0, 0);

        Scanner userInput = new Scanner(System.in);
        while (true)
        {
            System.out.print("Welcome to console Board Games!\n " +
                                "In this program, you can always exit the game by typing \"exit\" \n" +
                                "Currently there are 2 games available. \n" +
                                "[1] Tic Tac Toe \n" +
                                "[2] Order and Chaos \n" +
                                "Please enter corresponding integer to choose game. \n");
            
            // read user's choice of game
            InputParser parser = new InputParser(userInput);
            parser.parseInputToInt(1, 2);
            
            if (parser.getExit() == true) {
                break;
            }

            int gameType = parser.getParsedInt();

            if (gameType == 1) {
                // play tic tac toe
                runner1.run(userInput);
            }
            else {
                // play order and chaos
                runner2.run(userInput);
            }
        }
    }
}