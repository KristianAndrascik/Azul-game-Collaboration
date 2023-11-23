package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameFinishedTest {
    private Tile[] tiles;
    private Optional<Tile>[][] wall;

    @BeforeEach
    public void setUp() {
        initializeTiles();
        initializeWall();

    }

    private void initializeTiles() {
        tiles = new Tile[Tile.values().length - 1];
        int i = 0;
        for (Tile tile : Tile.values()) {
            if (tile != Tile.STARTING_PLAYER) {
                tiles[i] = tile;
                i++;
            }
        }
    }

    private void initializeWall() {
        wall = new Optional[tiles.length][tiles.length];
        for(int j = 0; j < tiles.length; j++){
            for(int k = 0; k < tiles.length; k++){
                wall[j][k] = Optional.empty();
            }
        }
    }

    @Test
    public void testGetPointsWithCompleteHorizontalLine() {
        // Set up a wall with a complete horizontal line
        wall[0][1] = Optional.of(tiles[0]);
        wall[0][4] = Optional.of(tiles[4]);
        for (int i = 0; i < tiles.length; i++) {
            wall[1][i] = Optional.of(tiles[(i + 1) % tiles.length]);
        }
        wall[2][0] = Optional.of(tiles[0]);
        wall[3][1] = Optional.of(tiles[1]);

        FinishRoundResult result = GameFinished.gameFinished(wall);

        assertEquals(FinishRoundResult.GAME_FINISHED, result);
    }
    @Test
    public void testGameFinishedEmptyWall() {
        FinishRoundResult result = GameFinished.gameFinished(wall);

        assertEquals(FinishRoundResult.NORMAL, result);
    }
}
