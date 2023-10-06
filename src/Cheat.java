public class Cheat {
    private String cheatType;
    private int bonusRuns;

    public Cheat(String cheatType, int bonusRuns){
        this.cheatType = cheatType;
        this.bonusRuns = bonusRuns;
    }

    public String getCheatType() {
        return cheatType;
    }

    public int getBonusRuns() {
        return bonusRuns;
    }
}
