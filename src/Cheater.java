import java.util.Random;

public class Cheater extends BaseballTeam{
    Random rand = new Random();
    private Cheat[] cheats = new Cheat[2];
    public Cheater(String name, String color){
        super(name, color);

        cheats[0] =  new Cheat("Corked Bat", 3);
        cheats[1] = new Cheat("Sign Stealing", 2);
    }


    public Cheat CheatWithDetails(){
        int randomNum = rand.nextInt(cheats.length);
        return cheats[randomNum];
    }

}
