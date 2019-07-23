import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {

    @Test
    public void gameHasANotVariableFramesList() {
        Bowling game = new Bowling();
        Assert.assertEquals(true, game.getFrames() instanceof Frame[]);
    }

    @Test
    public void gameHas10Frames() {
        Bowling game = new Bowling();
        Assert.assertEquals(10, game.getFrames().length);
    }

    @Test
    public void eachFrameHasANotVariableOportunityList() {
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(2, frame.getOpportunities().length);
        }
    }

    @Test
    public void eachFrameHas2Opportunities() {
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(true, frame.getOpportunities() instanceof Opportunity[]);
        }
    }

    @Test
    public void frameScoreCantBeNegative() {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        System.out.println(frame.getScore());
        Assert.assertEquals(true, frame.getScore() >= 0);
    }

    @Test
    public void frameScoreMustBeOportunitiesScoreAdded() throws Exception {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        for (int i = 0; i < 10; i++) {
            frame.getOpportunities()[0].setScore(i);
            frame.getOpportunities()[1].setScore(i + 1);
            Assert.assertEquals(i + i + 1, frame.getScore());
        }
    }

    @Test (expected = Exception.class)
    public void scoreCantBeNegative() throws Exception {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        for (int i = -1; i > -10; i--) {
            frame.getOpportunities()[0].setScore(i);
            frame.getOpportunities()[1].setScore(i - 1);
            Assert.assertEquals(0, frame.getScore());
        }
    }

    @Test
    public void totalScoreIsThePlusOfAllFramesScore() throws Exception {
        Bowling game = new Bowling();
        for (int scoreByOport = 0; scoreByOport <= 10; scoreByOport++) {
            for (Frame frame : game.getFrames()) {
                for (Opportunity opportunity : frame.getOpportunities()) {
                    opportunity.setScore(scoreByOport);
                }
            }
            // 1 point x 2 opportunities x 10 frames = 20 points
            Assert.assertEquals(Bowling.FRAMES_NUMBER * Frame.OPORTUNITIES_NUMBER * scoreByOport, game.getScore());
        }
    }
}
