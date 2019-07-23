public class Frame {

    public static final int OPORTUNITIES_NUMBER = 2;
    public static final int MAX_PINS = 10;
    private final Roll[] rolls;

    public Frame(){
        this.rolls = new Roll[OPORTUNITIES_NUMBER];
        for (int i = 0; i < OPORTUNITIES_NUMBER; i++) rolls[i] = new Roll();
    }

    public Roll[] getRolls() {
        return this.rolls;
    }

    public int score() throws Exception {
        int score = 0;
        for (Roll roll : this.rolls) score += roll.score();
        return score;
    }

    public boolean isStrike() { //the 2 next rolls has double points
        return this.rolls[0].getPinsDropped() == MAX_PINS;
    }

    public boolean isSPare() { //the next roll has double points
        return this.rolls[0].getPinsDropped() != MAX_PINS && this.rolls[0].getPinsDropped() + this.rolls[1].getPinsDropped() == MAX_PINS ;
    }
}
