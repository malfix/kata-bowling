import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BowlingTest {
    @Test
    public void noRolls(){
       BowlingGame bowling = new BowlingGame();
       assertEquals(0, bowling.score());
    }

    @Test
    public void oneRoll(){
        BowlingGame bowling = new BowlingGame();
        bowling.roll(1);
        assertEquals(1, bowling.score());
    }


}
