import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RollTest {

    Roll roll;

    @Before
    public void before() {
        roll = new Roll();
    }

    @Test(expected = Exception.class)
    public void pinsMaxDroppedAre10() throws Exception {
        roll.roll(11, false);
        Assert.assertEquals("", roll.getPinsDropped());
    }

    @Test(expected = Exception.class)
    public void pinsDroppedCantBeNegative() throws Exception {
        roll.roll(-11, false);
        Assert.assertEquals("", roll.getPinsDropped());
    }

    @Test
    public void rollScoreIsPinsDroppedPlusBonus() throws Exception {
        roll.roll(5, true); //bonus generate de double of pins dropped
        Assert.assertEquals(10, roll.score());
    }

    @Test
    public void scoreIfNoBonus() throws Exception {
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            roll.roll(i, false);
            Assert.assertEquals(roll.getPinsDropped(), roll.score());
        }
    }

    @Test
    public void scoreIfBonus() throws Exception {
        for (int i = 0; i < Frame.MAX_PINS; i++) {
            roll.roll(i, true); //bonus generate de double of pins dropped
            Assert.assertEquals(roll.getPinsDropped() * 2, roll.score());
        }
    }
}