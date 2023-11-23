package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class Horizontal implements Calculation {
    public int calculatePoints(List<List<Optional<Tile>>> wall) {
        return calculate(wall);
    }

    @Override
    public int calculate(List<List<Optional<Tile>>> wall) {
        int totalPoints = 0;
        for (int row = 0; row < wall.size(); row++) {
            if (isRowComplete(wall, row)) {
                totalPoints += 2;
            }
        }
        return totalPoints;
    }

    public boolean isRowComplete(List<List<Optional<Tile>>> wall, int rowIndex) {
        for (Optional<Tile> tile : wall.get(rowIndex)) {
            if (!tile.isPresent()) {
                return false;
            }
        }
        return true;
    }
}
