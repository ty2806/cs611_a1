import java.util.Scanner;

public class InputParser {
    private Scanner input;
    private String parsedString;
    private int parsedInt;
    private boolean exitState;

    public InputParser(Scanner sc)
    {
        input = sc;
    }

    public void setParsedString(String s)
    {
        parsedString = s;
    }

    public String getParsedString()
    {
        return parsedString;
    }

    public void setParsedInt(int i)
    {
        parsedInt = i;
    }

    public int getParsedInt()
    {
        return parsedInt;
    }

    public void setExit(boolean flag)
    {
        exitState = flag;
    }

    public boolean getExit()
    {
        return exitState;
    }

    public void setScanner(Scanner sc)
    {
        input = sc;
    }

    public Scanner getScanner()
    {
        return input;
    }

    public void parseInputToInt(int low, int high)
    {
        while (true) {
            String line = input.nextLine();
            if (line.equals("exit")) {
                setExit(true);
                break;
            }
            try {
                int parsed = Integer.parseInt(line);
                if (parsed < low || parsed > high) {
                    System.out.println("Your input is out of boundary. Please choose an integer between " + low + " and " + high);
                    continue;
                }
                else {
                    setParsedInt(parsed);
                    break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Your input is not an integer. Try again.");
                continue;
            }
            
        }
    }
}