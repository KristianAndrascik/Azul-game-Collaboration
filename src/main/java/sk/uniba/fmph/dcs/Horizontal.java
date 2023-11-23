package sk.uniba.fmph.dcs;

import java.util.Optional;

public class Horizontal implements Calculation {
    public int calculatePoints(Optional<Tile>[][] wall) {
        return calculate(wall);
    }

    @Override
    public int calculate(Optional<Tile>[][] wall) {
        int totalPoints = 0;
        for (int row = 0; row < wall.length; row++) {
            if (isRowComplete(wall, row)) {
                totalPoints += 2;
            }
        }
        return totalPoints;
    }

    public boolean isRowComplete(Optional<Tile>[][] wall, int rowIndex) {
        for (Optional<Tile> tile : wall[rowIndex]) {
            if (!tile.isPresent()) {
                return false;
            }
        }
        return true;
    }
}
