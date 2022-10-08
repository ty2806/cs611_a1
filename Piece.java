public class Piece {
    private int value;
    private String name;
    private String symbol; //the symbol printed on the board

    public Piece(int i, String n, String s)
    {
        setValue(i);
        setName(n);
        setSymbol(s);
    }

    public void setValue(int i)
    {
        value = i;
    }

    public int getValue()
    {
        return value;
    }

    public void setName(String s)
    {
        name = s;
    }

    public String getName()
    {
        return name;
    }

    public void setSymbol(String s)
    {
        symbol = s;
    }

    public String getSymbol()
    {
        return symbol;
    }

}
