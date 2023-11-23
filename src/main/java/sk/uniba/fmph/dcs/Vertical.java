package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class Vertical implements Calculation {


    public int calculatePoints(List<List<Optional<Tile>>> wall) {
        return calculate(wall);
    }
    @Override
    public int calculate(List<List<Optional<Tile>>> wall) {
        int totalPoints = 0;
        for (int col = 0; col < wall.size(); col++) {
            if (isColumnComplete(wall, col)) {
                totalPoints += 7;
            }
        }
        return totalPoints;
    }

    public boolean isColumnComplete(List<List<Optional<Tile>>> wall, int colIndex) {
        for (List<Optional<Tile>> row : wall) {
            if (!row.get(colIndex).isPresent()) {
                return false;
            }
        }
        return true;
    }
}
