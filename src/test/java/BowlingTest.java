import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {

    @Test
    public void gameHas10Frames(){
        Bowling game = new Bowling();
        Assert.assertEquals(10, game.getFrames().length);
    }

    @Test
    public void eachFrameHas2Opportunities(){
        Bowling game = new Bowling();
        for (Frame frame : game.getFrames()) {
            Assert.assertEquals(2, frame.getOportunities().length);
        }
    }
}
