package sk.uniba.fmph.dcs;

import sk.uniba.fmph.dcs.FinishRoundResult;
import sk.uniba.fmph.dcs.Points;
import sk.uniba.fmph.dcs.Tile;

import java.util.List;

public interface BoardInterface {
    void put(int destinationIdx, List<Tile> tiles);
    FinishRoundResult finishRound();
    void endGame();
    String state();
    Points getPoints();
}
