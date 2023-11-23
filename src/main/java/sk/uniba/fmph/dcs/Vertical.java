package sk.uniba.fmph.dcs;

import java.util.Optional;

public class Vertical implements Calculation {


    public int calculatePoints(Optional<Tile>[][] wall) {
        return calculate(wall);
    }
    @Override
    public int calculate(Optional<Tile>[][] wall) {
        int totalPoints = 0;
        for (int col = 0; col < wall.length; col++) {
            if (isColumnComplete(wall, col)) {
                totalPoints += 7;
            }
        }
        return totalPoints;
    }

    public boolean isColumnComplete(Optional<Tile>[][] wall, int colIndex) {
        for (Optional<Tile>[] row : wall) {
            if (!row[colIndex].isPresent()) {
                return false;
            }
        }
        return true;
    }
}
