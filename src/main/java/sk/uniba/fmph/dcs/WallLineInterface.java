package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public interface WallLineInterface {
    boolean canPutTile(Tile tile);
    List<Optional<Tile>> getTiles();
    Points putTile(Tile tile);
    String state();
}
