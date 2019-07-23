import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

    Bowling game;

    @Before
    public void before() {
        game = new Bowling();
    }

    @Test
    public void gameHasANotVariableFramesList() {
        Assert.assertEquals(true, game.getFrames() instanceof Frame[]);
    }

    @Test
    public void gameHas10Frames() {
        Assert.assertEquals(10, game.getFrames().length);
    }

    @Test
    public void eachFrameHasANotVariableRollList() {
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(2, frame.getRolls().length);
        }
    }

    @Test
    public void eachFrameHas2Rolls() {
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(true, frame.getRolls() instanceof Roll[]);
        }
    }

    @Test(expected = Exception.class)
    public void scoreCantBeNegative() throws Exception {
        Frame frame = game.getFrames()[0];
        for (int i = -1; i > -10; i--) {
            frame.getRolls()[0].roll(i, false);
            frame.getRolls()[1].roll(i - 1, false);
            Assert.assertEquals(0, frame.score());
        }
    }

    @Test
    public void totalScoreIsThePlusOfAllFramesScore() throws Exception {
        for (int pins = 0; pins <= Frame.MAX_PINS; pins++) {
            for (Frame frame : game.getFrames()) {
                for (Roll roll : frame.getRolls()) {
                    roll.roll(pins, false);
                }
            }
            // 1 point x 2 opportunities x 10 frames = 20 points
            Assert.assertEquals(Bowling.FRAMES_NUMBER * Frame.OPORTUNITIES_NUMBER * pins, game.scoreWithBonus());
        }
    }

    @Test
    public void spareGenerateBonusToTheNextFrameRoll() throws Exception {
        Frame[] frames = game.getFrames();
        frames[0].getRolls()[0].roll(5, false);
        frames[0].getRolls()[1].roll(5, false);
        //Check spare in frame 0
        Assert.assertEquals(true, frames[0].isSPare());

        //The game is who know if bonus exist
        frames[1].getRolls()[0].roll(4, true);
        frames[1].getRolls()[1].roll(3, false);
        //The second frame: first roll 4 + 4 (by bonus), second roll 3 = 11 points
        Assert.assertEquals(11, game.scoreWithBonus(1));
    }

    @Test
    public void strikeGenerateBonusToTheTwoNextFrameRoll() throws Exception {
        Frame[] frames = game.getFrames();
        frames[0].getRolls()[0].roll(10, false);
        frames[0].getRolls()[1].roll(0, false);
        //Check spare in frame 0
        Assert.assertEquals(true, frames[0].isStrike());

        //The game is who know if bonus exist
        frames[1].getRolls()[0].roll(4, true);
        frames[1].getRolls()[1].roll(3, true);
        //The second frame: first roll 4 + 4 (by bonus), second roll 3 + 3 (by bonus) = 14 points
        Assert.assertEquals(14, game.scoreWithBonus(1));
    }

    @Test
    public void bonusInLastFrameLetAExtraRoll() throws Exception {
        Frame[] frames = game.getFrames();
        //Strike
        frames[9].getRolls()[0].roll(10, false);
        frames[9].getRolls()[1].roll(0, false);
        game.getExtraRoll().roll(7, true);
        //The last frame will be frame scoreWithBonus plus extraroll;
        Assert.assertEquals(24, game.scoreWithBonus(9));
    }

    @Test
    public void checkGameToString() throws Exception {
        int i = 0;
        //Frame 0, 1, 2, 3, 4 combining spare and strike
        game.getFrames()[0].getRolls()[0].roll(10, false);
        game.getFrames()[0].getRolls()[1].roll(0, false);
        game.getFrames()[1].getRolls()[0].roll(2, game.getFrames()[0].isSpareOrStrike());
        game.getFrames()[1].getRolls()[1].roll(7, game.getFrames()[0].isStrike());
        game.getFrames()[2].getRolls()[0].roll(5, game.getFrames()[1].isSpareOrStrike());
        game.getFrames()[2].getRolls()[1].roll(4, game.getFrames()[1].isStrike());
        game.getFrames()[3].getRolls()[0].roll(9, game.getFrames()[2].isSpareOrStrike());
        game.getFrames()[3].getRolls()[1].roll(1, game.getFrames()[2].isStrike());
        game.getFrames()[4].getRolls()[0].roll(5, game.getFrames()[3].isSpareOrStrike());
        game.getFrames()[4].getRolls()[1].roll(2, game.getFrames()[3].isStrike());

        //Frame 9
        game.getFrames()[9].getRolls()[0].roll(7, game.getFrames()[8].isSpareOrStrike());
        game.getFrames()[9].getRolls()[1].roll(3, game.getFrames()[8].isStrike());
        game.getExtraRoll().roll(8, game.getFrames()[9].isSpareOrStrike());
        String gameResult = game.toString();
        System.out.println(gameResult);
        Assert.assertEquals(true, gameResult instanceof String);

    }

    @Test
    public void spareBonusIfInPreviousFrameHas10() throws Exception {
        int i = 0;
        game.getFrames()[0].getRolls()[0].roll(5, false);
        game.getFrames()[0].getRolls()[1].roll(5, false);
        game.getFrames()[1].getRolls()[0].roll(3, game.getFrames()[0].isSpareOrStrike());
        game.getFrames()[1].getRolls()[1].roll(5, game.getFrames()[0].isStrike());

        //5 + 5 + 3*2 + 5 (spare) = 21
        Assert.assertEquals(21, game.scoreWithBonus());
    }

    @Test
    public void strikeBonusIfInPreviousFrameHas10() throws Exception {
        game.getFrames()[0].getRolls()[0].roll(10, false);
        game.getFrames()[0].getRolls()[1].roll(0, false);
        game.getFrames()[1].getRolls()[0].roll(3, game.getFrames()[0].isSpareOrStrike());
        game.getFrames()[1].getRolls()[1].roll(5, game.getFrames()[0].isStrike());

        //10 + 3*2 + 5*2 (strike) = 26
        Assert.assertEquals(26, game.scoreWithBonus());
    }
}