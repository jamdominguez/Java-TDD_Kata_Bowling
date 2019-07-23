import org.junit.Assert;
import org.junit.Test;

public class RollTest {

    @Test (expected = Exception.class)
    public void pinsMaxDroppedAre10() throws Exception {
        Roll roll = new Roll();
        roll.roll(11);
        Assert.assertEquals("", roll.getPinsDropped());
    }

    @Test (expected = Exception.class)
    public void pinsDroppedCantBeNegative() throws Exception {
        Roll roll = new Roll();
        roll.roll(-11);
        Assert.assertEquals("", roll.getPinsDropped());
    }

    @Test
    public void rollScoreIsPinsDroppedPlusBonus() throws Exception {
        Roll roll = new Roll();
        roll.setScore(5,6);
        Assert.assertEquals(11, roll.getScore());
    }

    @Test
    public void scoreIfNoBonus() throws Exception {
        Roll roll = new Roll();
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            roll.roll(i);
            roll.setScore(roll.getPinsDropped(), 0);
            Assert.assertEquals(roll.getPinsDropped(), roll.getScore());
        }
    }
}
