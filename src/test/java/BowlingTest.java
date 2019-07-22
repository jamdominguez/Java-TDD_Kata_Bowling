import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {

    @Test
    public void gameHas10Frames(){
        Bowling game = new Bowling();
        Assert.assertEquals(10, game.getFrames().length);
    }
}
