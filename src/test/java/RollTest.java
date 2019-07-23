import org.junit.Assert;
import org.junit.Test;

public class RollTest {

    @Test(expected = Exception.class)
    public void pinsMaxDroppedAre10() throws Exception {
        Roll roll = new Roll();
        roll.roll(11, false);
        Assert.assertEquals("", roll.getPinsDropped());
    }

    @Test(expected = Exception.class)
    public void pinsDroppedCantBeNegative() throws Exception {
        Roll roll = new Roll();
        roll.roll(-11, false);
        Assert.assertEquals("", roll.getPinsDropped());
    }

    @Test
    public void rollScoreIsPinsDroppedPlusBonus() throws Exception {
        Roll roll = new Roll();
        roll.roll(5, true); //bonus generate de double of pins dropped
        Assert.assertEquals(10, roll.score());
    }

    @Test
    public void scoreIfNoBonus() throws Exception {
        Roll roll = new Roll();
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            roll.roll(i, false);
            Assert.assertEquals(roll.getPinsDropped(), roll.score());
        }
    }

    @Test
    public void scoreIfBonus() throws Exception {
        Roll roll = new Roll();
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            roll.roll(i , true); //bonus generate de double of pins dropped
            Assert.assertEquals(roll.getPinsDropped() * 2, roll.score());
        }
    }
}