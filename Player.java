public class Player {
    private Piece[] pieces; //game pieces a player is legel to use
    private int playerId; 
    private int teamId;
    private String teamName;
    private int winCount; // the number of games this player has won

    public Player(Piece[] pieces, int id, int count, int team, String name)
    {
        setPiece(pieces);
        setId(id);
        setTeam(team, name);
        setWinCount(count);
    }

    public Player(Piece[] pieces, int id, int count)
    {
        setPiece(pieces);
        setId(id);
        setTeam(0, "no team");
        setWinCount(count);
    }

    public void setPiece(Piece[] p)
    {
        pieces = p;
    }

    public Piece[] getPiece()
    {
        return pieces;
    }

    public void setId(int id)
    {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        playerId = id;
    }

    public int getId()
    {
        return playerId;
    }

    public void setTeam(int team, String name)
    {   
        if (team < 0) {
            throw new IllegalArgumentException();
        }
        teamId = team;
        teamName = name;
    }

    public int getTeamId()
    {
        return teamId;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setWinCount(int count)
    {   
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        winCount = count;
    }

    public int getWinCount()
    {
        return winCount;
    }

    public void addWinCount()
    {
        winCount += 1;
    }
}
