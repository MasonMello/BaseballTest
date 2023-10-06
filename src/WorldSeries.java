import java.util.Random;

class WorldSeries {

    public static final int MILLIDELAY = 1000;
    public static void simulateGame(BaseballTeam team1, BaseballTeam team2, int gameNumber) {
        // Simulate a single game
        System.out.println("Game " + gameNumber);
        pause(MILLIDELAY);
        Random rand = new Random();
        int team1wins = 0;
        int team2wins = 0;
        //


       do{
           team1wins += rand.nextInt(11);
           team2wins += rand.nextInt(11);
           team1wins += getCheatRuns(team1);
           team2wins += getCheatRuns(team2);
       }while(team1wins == team2wins);

       BaseballTeam winnerName;
       if (team1wins > team2wins){
           winnerName = team1;
           team1.winGame();
       }else {
           winnerName = team2;
           team2.winGame();
       }


        System.out.println("Game " +gameNumber + " Result: The " + winnerName.getColor() + winnerName.getName() + ConsoleColors.RESET + " Won!");

        System.out.println("Series Score: " + team1.getColor() + team1.getName() + ConsoleColors.RESET + " " + team1.getGamesWon() + " - " + team2.getColor() + team2.getName() + ConsoleColors.RESET + " " + team2.getGamesWon() + "\n");
        pause(MILLIDELAY);
    }

    private static int getCheatRuns(BaseballTeam team){
        if(team instanceof Cheater){
            Cheat sampleCheat = ((Cheater) team).CheatWithDetails();
            System.out.println(team.getColor() + team.getName() + ConsoleColors.RED + " cheated with "  + sampleCheat.getCheatType()  + " earning " + sampleCheat.getBonusRuns() + " runs" + ConsoleColors.RESET);
            return sampleCheat.getBonusRuns();
        }else{
            return 0;
        }
    }

    public static void simulateSeries(BaseballTeam team1, BaseballTeam team2) {
        System.out.println("World Series Simulation:");
        System.out.println(team1.getColor() + team1.getName() + ConsoleColors.RESET +  " vs. " + team2.getColor() + team2.getName() + ConsoleColors.RESET + "\n");
        int gameNum = 1;
        while (team1.getGamesWon() < 4 && team2.getGamesWon() < 4) {
            simulateGame(team1, team2, gameNum);
            gameNum ++;
        }

        if (team1.getGamesWon() >= 4) {
            System.out.println("The " + team1.getColor() + team1.getName() + ConsoleColors.RESET + " are the World Series Champions!");
        } else {
            System.out.println("The " + team2.getColor() + team2.getName() + ConsoleColors.RESET +" are the World Series Champions!");
        }
    }

    public static void main(String[] args) {
        // Create a World Series instance with two teams
        BaseballTeam pirates = new Cheater("Pirates", "\033[0;33m");
        BaseballTeam yankees = new BaseballTeam("Yankees", "\033[0;34m");

        // Simulate the World Series
        simulateSeries(pirates, yankees);
    }

    /**
     * helper method to clean up code a bit and pull the try/catch sleep out
     */
    public static void pause(int millis){
        //need a try catch because the sleep method can throw an exception.
        //java will not compile if you do not handle a method that declares it may throw and exception.
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
