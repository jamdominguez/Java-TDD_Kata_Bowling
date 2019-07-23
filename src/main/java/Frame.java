public class Frame {

    public static final int OPORTUNITIES_NUMBER = 2;
    private final Opportunity[] opportunities;

    public Frame(){
        this.opportunities = new Opportunity[OPORTUNITIES_NUMBER];
        for (int i = 0; i < OPORTUNITIES_NUMBER; i++) opportunities[i] = new Opportunity();
    }

    public Opportunity[] getOpportunities() {
        return this.opportunities;
    }

    public int getScore() {
        int score = 0;
        for (Opportunity opportunity : this.opportunities) score += opportunity.getScore();
        return score;
    }
}
