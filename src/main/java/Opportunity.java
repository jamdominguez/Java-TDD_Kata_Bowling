public class Opportunity {

    private int score;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) throws Exception {
        if (score < 0) throw new Exception("Score can't be negative");
        this.score = score;
    }
}
