package sk.uniba.fmph.dcs;

import sk.uniba.fmph.dcs.FinishRoundResult;
import sk.uniba.fmph.dcs.Tile;

import java.util.List;
import java.util.Optional;

public interface GameFinishedInterface {
    FinishRoundResult gameFinished(List<List<Optional<Tile>>> wall);
}
