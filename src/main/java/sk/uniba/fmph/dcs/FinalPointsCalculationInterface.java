package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public interface FinalPointsCalculationInterface {
    Points getPoints(List<List<Optional<Tile>>> wall);
}
