public class Frame {

    public static final int OPORTUNITIES_NUMBER = 2;
    private final Oportunity[] oportunities;

    public Frame(){
        this.oportunities = new Oportunity[OPORTUNITIES_NUMBER];
        for (int i = 0; i < OPORTUNITIES_NUMBER; i++) oportunities[i] = new Oportunity();
    }

    public Oportunity[] getOportunities() {
        return this.oportunities;
    }

    public int getFrameScore() {
        return this.oportunities[0].getScore() + this.oportunities[1].getScore();
    }
}
