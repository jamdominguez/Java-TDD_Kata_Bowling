public class Frame {

    public static final int OPORTUNITIES_NUMBER = 2;
    public static final int MAX_PINS = 10;
    private final Roll[] rolls;

    public Frame() {
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
        return this.rolls[0].getPinsDropped() != MAX_PINS && this.rolls[0].getPinsDropped() + this.rolls[1].getPinsDropped() == MAX_PINS;
    }

    public boolean isSpareOrStrike() {
        return isSPare() || isStrike();
    }

    public void roll(int rollIndex, int pinsDropped, boolean hasBonus) throws Exception {
        if (rollIndex == 1 && rolls[0].getPinsDropped() == 10 && pinsDropped != 0) throw new Exception("Was a Strike, you can not roll again!");
        rolls[rollIndex].roll(pinsDropped, hasBonus);
        if (rolls[0].getPinsDropped() + rolls[1].getPinsDropped() > MAX_PINS) throw new Exception("Not is possible drop more than " + Frame.MAX_PINS + " pins");
    }
}