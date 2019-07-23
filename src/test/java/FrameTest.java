import org.junit.Assert;
import org.junit.Test;

public class FrameTest {

    @Test
    public void frameScoreCantBeNegative() throws Exception {
        Bowling game = new Bowling();
        Frame frame = game.getFrames()[0];
        Assert.assertEquals(true, frame.score() >= 0);
    }

    @Test
    public void frameScoreMustBeRollScoreAddedBonus() throws Exception {
        Frame frame = new Frame();
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            frame.getRolls()[0].roll(i, false);
            frame.getRolls()[1].roll(i + 1, false);
            Assert.assertEquals(i + i + 1, frame.score());
        }
    }

    @Test
    public void strikeWhenTheFirstRollInTheFrameDropMaxPins() throws Exception {
        Frame frame = new Frame();
        frame.getRolls()[0].roll(Frame.MAX_PINS, false);
        Assert.assertEquals(true, frame.isStrike());
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            frame.getRolls()[0].roll(i, false);
            Assert.assertEquals(false, frame.isStrike());
        }
    }

    @Test
    public void spareWhenInTheFrameDrop10Pins() throws Exception {
        Frame frame = new Frame();
        frame.getRolls()[0].roll(Frame.MAX_PINS, false);
        frame.getRolls()[1].roll(0, false);
        Assert.assertEquals(false, frame.isSPare()); //not is spare, is a strike

        for (int i = 0; i < Frame.MAX_PINS; i++) {
            frame.getRolls()[0].roll(i, false);
            frame.getRolls()[1].roll(Frame.MAX_PINS - i, false);
            Assert.assertEquals(true, frame.isSPare());
        }
    }

    @Test
    public void pinsMaxToDropAre10() {
        Assert.assertEquals(10, Frame.MAX_PINS);
    }
}
