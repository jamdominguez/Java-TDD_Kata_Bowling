public class Roll {

    private int score;
    private int pinsDropped;

    public int getScore() {
        return this.score;
    }

    public void setScore(int pinsDropped, int bonus) throws Exception {
        if (pinsDropped < 0) throw new Exception("Bonus can't be negative");
        this.score = pinsDropped + bonus;
    }

    public void roll(int pinsDropped) throws Exception {
        if (pinsDropped < 0) throw new Exception("Pins dropped can't be negative");
        if (pinsDropped > 10) throw new Exception("Not is possible drop more than 10 pins in a roll");
        else this.pinsDropped = pinsDropped;
    }

    public int getPinsDropped() {
        return this.pinsDropped;
    }

}
