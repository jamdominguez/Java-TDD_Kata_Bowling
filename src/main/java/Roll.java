import static javax.swing.text.html.HTML.Tag.STRIKE;

public class Roll {

    private int score;
    private int pinsDropped;
    private int bonus;
    private boolean existBonus;

    public int score() throws Exception {
        this.score = this.pinsDropped + this.bonus;
        return this.score;
    }

    public void roll(int pinsDropped, boolean existBonus) throws Exception {
        if (pinsDropped < 0) throw new Exception("Pins dropped can't be negative");
        if (pinsDropped > Frame.MAX_PINS) throw new Exception("Not is possible drop more than 10 pins in a roll");
        if (existBonus) this.bonus = pinsDropped;
        this.existBonus = existBonus;
        this.pinsDropped = pinsDropped;
        score();
    }

    public int getPinsDropped() {
        return this.pinsDropped;
    }

    public int getBonus() {
        return bonus;
    }
}
