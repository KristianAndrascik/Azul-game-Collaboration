package sk.uniba.fmph.dcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalPointsCalcTest {

    private List<Tile> tiles;
    private List<List<Optional<Tile>>> wall;

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
        wall.get(0).set(1, Optional.of(tiles.get(0)));
        wall.get(0).set(4, Optional.of(tiles.get(4)));
        for (int i = 0; i < tiles.size(); i++) {
            wall.get(1).set(i, Optional.of(tiles.get((i + 1) % tiles.size())));
        }
        wall.get(2).set(0, Optional.of(tiles.get(0)));
        wall.get(3).set(1, Optional.of(tiles.get(1)));

        int points = FinalPointsCalculation.getPoints(wall).getValue();

        // Assert that the points are as expected (2 points from HorizontalLineRule)
        assertEquals(2, points);
    }

    @Test
    public void testGetPointsWithCompleteVerticalLine() {
        // Set up a wall with a complete vertical line
        wall.get(0).set(0, Optional.of(tiles.get(2)));
        wall.get(1).set(0, Optional.of(tiles.get(0)));
        wall.get(2).set(0, Optional.of(tiles.get(1)));
        wall.get(3).set(0, Optional.of(tiles.get(3)));
        wall.get(4).set(0, Optional.of(tiles.get(4)));

        int points = FinalPointsCalculation.getPoints(wall).getValue();

        // Assert that the points are as expected (7 points from VerticalLineRule)
        assertEquals(7, points);
    }

    @Test
    public void testGetPointsWithCompleteFullColorRule() {
        // Set up a wall with all tiles filled
        wall.get(0).set(0, Optional.of(tiles.get(0)));
        wall.get(1).set(1, Optional.of(tiles.get(0)));
        wall.get(2).set(2, Optional.of(tiles.get(0)));
        wall.get(3).set(3, Optional.of(tiles.get(0)));
        wall.get(4).set(4, Optional.of(tiles.get(0)));

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