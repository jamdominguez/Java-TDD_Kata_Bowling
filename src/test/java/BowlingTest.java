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
    public void eachFrameHasANotVariableRollList() {
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(2, frame.getRolls().length);
        }
    }

    @Test
    public void eachFrameHas2Rolls() {
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(true, frame.getRolls() instanceof Roll[]);
        }
    }

    @Test (expected = Exception.class)
    public void scoreCantBeNegative() throws Exception {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        for (int i = -1; i > -10; i--) {
            frame.getRolls()[0].setScore(i, 0);
            frame.getRolls()[1].setScore(i - 1, 0);
            Assert.assertEquals(0, frame.getScore());
        }
    }

    @Test
    public void totalScoreIsThePlusOfAllFramesScore() throws Exception {
        Bowling game = new Bowling();
        for (int scoreByOport = 0; scoreByOport <= 10; scoreByOport++) {
            for (Frame frame : game.getFrames()) {
                for (Roll roll : frame.getRolls()) {
                    roll.setScore(scoreByOport, 0);
                }
            }
            // 1 point x 2 opportunities x 10 frames = 20 points
            Assert.assertEquals(Bowling.FRAMES_NUMBER * Frame.OPORTUNITIES_NUMBER * scoreByOport, game.getScore());
        }
    }



}
