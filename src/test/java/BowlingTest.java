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
            frame.getRolls()[0].roll(i, false);
            frame.getRolls()[1].roll(i - 1, false);
            Assert.assertEquals(0, frame.score());
        }
    }

    @Test
    public void totalScoreIsThePlusOfAllFramesScore() throws Exception {
        Bowling game = new Bowling();
        for (int pins = 0; pins <= Frame.MAX_PINS; pins++) {
            for (Frame frame : game.getFrames()) {
                for (Roll roll : frame.getRolls()) {
                    roll.roll(pins, false);
                }
            }
            // 1 point x 2 opportunities x 10 frames = 20 points
            Assert.assertEquals(Bowling.FRAMES_NUMBER * Frame.OPORTUNITIES_NUMBER * pins, game.score());
        }
    }

    @Test
    public void spareGenerateBonusToTheNextFrameRoll() throws Exception {
        Bowling game = new Bowling();
        Frame[] frames = game.getFrames();
        frames[0].getRolls()[0].roll(5, false);
        frames[0].getRolls()[1].roll(5, false);
        //Check spare in frame 0
        Assert.assertEquals(true, frames[0].isSPare());

        //The game is who know if bonus exist
        frames[1].getRolls()[0].roll(4, true);
        frames[1].getRolls()[1].roll(3, false);
        //The second frame: first roll 4 + 4 (by bonus), second roll 3 = 11 points
        Assert.assertEquals(11, frames[1].score());
    }
}
