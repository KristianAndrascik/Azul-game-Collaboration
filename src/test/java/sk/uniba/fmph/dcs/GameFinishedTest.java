package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameFinishedTest {
    private java.util.List<Tile> tiles;
    private java.util.List<java.util.List<Optional<Tile>>> wall;

    @BeforeEach
    public void setUp() {
        initializeTiles();
        initializeWall();

    }

    private void initializeTiles() {
        tiles = new ArrayList<>();
        for (Tile tile : Tile.values()) {
            if (tile != Tile.STARTING_PLAYER) {
                tiles.add(tile);
            }
        }
    }


    private void initializeWall() {
        wall = new ArrayList<>();
        for (int j = 0; j < tiles.size(); j++) {
            List<Optional<Tile>> row = new ArrayList<>();
            for (int k = 0; k < tiles.size(); k++) {
                row.add(Optional.empty());
            }
            wall.add(row);
        }

    }

    @Test
    public void testGetPointsWithCompleteHorizontalLine() {
        // Set up a wall with a complete horizontal line
        // Set up a wall with a complete horizontal line
        wall.get(0).set(1, Optional.of(tiles.get(0)));
        wall.get(0).set(4, Optional.of(tiles.get(4)));
        for (int i = 0; i < tiles.size(); i++) {
            wall.get(1).set(i, Optional.of(tiles.get((i + 1) % tiles.size())));
        }
        wall.get(2).set(0, Optional.of(tiles.get(0)));
        wall.get(3).set(1, Optional.of(tiles.get(1)));

        FinishRoundResult result = GameFinished.gameFinished(wall);

        assertEquals(FinishRoundResult.GAME_FINISHED, result);
    }
    @Test
    public void testGameFinishedEmptyWall() {
        FinishRoundResult result = GameFinished.gameFinished(wall);

        assertEquals(FinishRoundResult.NORMAL, result);
    }
}
