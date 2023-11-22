package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalPointsCalcTest {

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

        int points = FinalPointsCalculation.getPoints(wall).getValue();

        // Assert that the points are as expected (2 points from HorizontalLineRule)
        assertEquals(2, points);
    }

    @Test
    public void testGetPointsWithCompleteVerticalLine() {
        // Set up a wall with a complete vertical line
        wall[0][0] = Optional.of(tiles[2]);
        wall[1][0] = Optional.of(tiles[0]);
        wall[2][0] = Optional.of(tiles[1]);
        wall[3][0] = Optional.of(tiles[3]);
        wall[4][0] = Optional.of(tiles[4]);

        int points = FinalPointsCalculation.getPoints(wall).getValue();

        // Assert that the points are as expected (7 points from VerticalLineRule)
        assertEquals(7, points);
    }

    @Test
    public void testGetPointsWithCompleteFullColorRule() {
        // Set up a wall with all tiles filled
        wall[0][0] = Optional.of(tiles[0]);
        wall[1][1] = Optional.of(tiles[0]);
        wall[2][2] = Optional.of(tiles[0]);
        wall[3][3] = Optional.of(tiles[0]);
        wall[4][4] = Optional.of(tiles[0]);


        int points = FinalPointsCalculation.getPoints(wall).getValue();

        // Assert that the points are as expected (10 points from FullColorRule)
        assertEquals(10, points);
    }

    @Test
    public void testGetPointsWithEmptyWall() {
        // Set up an empty wall
        int points = FinalPointsCalculation.getPoints(wall).getValue();

        // Assert that the points are 0 for an empty wall
        assertEquals(0, points);
    }
}