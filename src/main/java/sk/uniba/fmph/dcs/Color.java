package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class Color implements Calculation {
    public int calculatePoints(List<List<Optional<Tile>>> wall) {
        return calculate(wall);
    }

    @Override
    public int calculate(List<List<Optional<Tile>>> wall) {
        int totalPoints = 0;
        for (int colorIndex = 0; colorIndex < 5; colorIndex++) {
            if (isColorComplete(wall, colorIndex)) {
                totalPoints += 10;
            }
        }
        return totalPoints;
    }

    private boolean isColorComplete(List<List<Optional<Tile>>> wall, int colorIndex) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int colI = (colorIndex + i) % 5;
            if (wall.get(i).get(colI).isPresent()) {
                count++;
            } else {
                return false;
            }
        }
        return count == 5;
    }
}
