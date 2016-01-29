import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> rolls = new ArrayList<Integer>();
    public BowlingGame() {
    }


    public int score() {
        if (rolls.isEmpty()) return 0;
        int total = 0;
        for (Integer roll : rolls)
            total+= roll;
        return total;
    }

    public void roll(int pin) {
        rolls.add(pin);
    }
}
