package sk.uniba.fmph.dcs;

import java.util.Optional;

public class Color implements Calculation {
    public int calculatePoints(Optional<Tile>[][] wall) {
        return calculate(wall);
    }

    @Override
    public int calculate(Optional<Tile>[][] wall) {
        int totalPoints = 0;
        for (int colorIndex = 0; colorIndex < 5; colorIndex++) {
            if (isColorComplete(wall, colorIndex)) {
                totalPoints += 10;
            }
        }
        return totalPoints;
    }

    private boolean isColorComplete(Optional<Tile>[][] wall, int colorIndex) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int colI = (colorIndex + i) % 5;
            if (wall[i][colI].isPresent()) {
                count++;
            } else {
                return false;
            }
        }
        return count == 5;
    }
}
