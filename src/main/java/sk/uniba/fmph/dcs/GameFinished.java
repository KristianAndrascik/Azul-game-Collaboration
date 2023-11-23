package sk.uniba.fmph.dcs;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public class GameFinished {

    public static FinishRoundResult gameFinished(List<List<Optional<Tile>>> wall){
        Horizontal horizontal = new Horizontal();
        if(horizontal.calculatePoints(wall) >= 2){
            return FinishRoundResult.GAME_FINISHED;
        }
        return FinishRoundResult.NORMAL;
    }
}
