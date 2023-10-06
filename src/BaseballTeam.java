import java.util.Random;

class BaseballTeam {
    private String name;
    private String color;
    private int gamesWon;
    private int gamesLost;

    public BaseballTeam(String name,String color) {
        this.name = name;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.color = color;
    }



    public String getName() {
        return name;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void winGame() {
        gamesWon++;
    }

    public void loseGame() {
        gamesLost++;
    }

    public String getColor() {
        return color;
    }

}