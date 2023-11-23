package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public interface Calculation {
int calculate(List<List<Optional<Tile>>> wall);
}
