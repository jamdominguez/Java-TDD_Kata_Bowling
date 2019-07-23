import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {

    @Test
    public void gameHasANotVariableFramesList() {
        Bowling game = new Bowling();
        Assert.assertEquals(true, game.getFrames() instanceof Frame[] );
    }

    @Test
    public void gameHas10Frames(){
        Bowling game = new Bowling();
        Assert.assertEquals(10, game.getFrames().length);
    }

    @Test
    public void eachFrameHasANotVariableOportunityList(){
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(2, frame.getOportunities().length);
        }
    }

    @Test
    public void eachFrameHas2Opportunities(){
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(true, frame.getOportunities() instanceof Oportunity[]);
        }
    }

    @Test
    public void frameScoreCantBeNegative() {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        Assert.assertEquals(true, frame.getFrameScore() > 0);
    }

    @Test
    public void frameScoreMustBeOportunitiesScoreAdded() {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        frame.getOportunities()[0].setScore(1);
        frame.getOportunities()[1].setScore(1);
        Assert.assertEquals(2, frame.getFrameScore());
    }
}
