package sk.uniba.fmph.dcs;

import java.util.Optional;

public interface Calculation {
    public int calculate(Optional<Tile>[][] wall);
}
