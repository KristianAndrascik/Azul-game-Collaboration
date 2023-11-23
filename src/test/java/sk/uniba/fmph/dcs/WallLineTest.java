package sk.uniba.fmph.dcs;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallLineTest {/*
  private WallLine wallLine;

  @Before
  public void setUp() {
    LinkedList<Tile> tileTypes1 = new LinkedList<Tile>();
    tileTypes1.add(Tile.RED);
    tileTypes1.add(Tile.BLUE);
    tileTypes1.add(Tile.BLACK);
    tileTypes1.add(Tile.GREEN);
    tileTypes1.add(Tile.YELLOW);

    LinkedList<Tile> tileTypes2 = new LinkedList<Tile>(tileTypes1.subList(1,5));
    tileTypes2.add(Tile.RED);

    System.out.println();
    LinkedList<Tile> tileTypes3 = new LinkedList<Tile>(tileTypes2.subList(1,5));
    tileTypes3.add(Tile.BLUE);

    WallLine wallLineUp2 = new WallLine(tileTypes3,null,null);
    WallLine wallLineUp1 = new WallLine(tileTypes2,null,null);
    wallLine =  new WallLine(tileTypes1,null,null);

    wallLine.setLineUp(wallLineUp1);
    wallLineUp1.setLineDown(wallLine);
    wallLineUp1.setLineUp(wallLineUp2);
    wallLineUp2.setLineDown(wallLineUp1);

    wallLineUp1.putTile(Tile.YELLOW);
  }

  @Test
  public void testCanPutTiles(){
    assertTrue("WallLine.canPutTile should return true if tile is in WallLine tile types " +
                        "and this tileType isn't already occupied by tile.",wallLine.canPutTile(Tile.BLACK));
    assertFalse("WallLine.canPutTile should return false if tile isn't in WallLine tile types.",
            wallLine.canPutTile(Tile.STARTING_PLAYER));
    wallLine.putTile(Tile.RED);
    assertFalse("WallLine.canPutTile should return false if tile is already occupied by tile",
            wallLine.canPutTile(Tile.RED));
  }

  @Test
  public void testGetTiles(){
    LinkedList<Optional<Tile>> empty = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      empty.add(Optional.empty());
    }
    assertEquals("WallLine.getTiles should return list of optional.empty if no tiles are occupied."
            ,empty,wallLine.getTiles());

    wallLine.putTile(Tile.BLUE);
    ArrayList<Optional<Tile>> blueTile = new ArrayList<>(empty);
    blueTile.set(1,Optional.ofNullable(Tile.BLUE));
    assertEquals("WallLine.getTiles should return list of optional.empty and Blue tile on correct place " +
                    "according to tileTypes if only Blue tile is occupied."
            ,blueTile,wallLine.getTiles());

    wallLine.putTile(Tile.RED);
    wallLine.putTile(Tile.GREEN);
    wallLine.putTile(Tile.BLACK);
    wallLine.putTile(Tile.YELLOW);
    ArrayList<Optional<Tile>> full = new ArrayList<>();
    full.add(Optional.of(Tile.RED));
    full.add(Optional.of(Tile.BLUE));
    full.add(Optional.of(Tile.BLACK));
    full.add(Optional.of(Tile.GREEN));
    full.add(Optional.of(Tile.YELLOW));
    assertEquals("WallLine.getTiles should return full list of tiles on correct places " +
                    "according to tileTypes if every tile is occupied."
            ,full,wallLine.getTiles());
  }
  @Test
  public void testPutTile(){
    Points control = new Points(0);
    assertEquals("WallLine.putTile should return zero points for invalid tile type."
            ,wallLine.putTile(Tile.STARTING_PLAYER),control);

    control = new Points(1);
    assertEquals("WallLine.putTile should return one point if it first tile in wall(without adjacent tiles)."
            ,wallLine.putTile(Tile.RED),control);

    control = new Points(0);
    assertEquals("WallLine.putTile should return zero points if tile is already occupied."
            ,wallLine.putTile(Tile.RED),control);

    control = new Points(3);
    wallLine.putTile(Tile.BLUE);
    assertEquals("WallLine.putTile should return one point for it self and point per each adjacent tiles." +
                    "More specifically one point for tiles linked vertically or horizontally to the placed tile" +
                    "In these case there is two tiles linked horizontally and zero vertically, so 3 points in total."
            ,wallLine.putTile(Tile.BLACK),control);

    control = new Points(1);
    assertEquals("WallLine.putTile should return one point for it self and point per each adjacent tiles." +
                    "More specifically one point for tiles linked vertically or horizontally to the placed tile" +
                    "In these case there is no tiles linked horizontally or vertically, so 1 point in total."
            ,wallLine.putTile(Tile.YELLOW),control);

    control = new Points(6);
    assertEquals("WallLine.putTile should return one point for it self and point per each adjacent tiles." +
                    "More specifically one point for tiles linked vertically or horizontally to the placed tile" +
                    "In these case there are 4 tiles linked horizontally and one vertically, so 6 point in total."
            ,wallLine.putTile(Tile.GREEN),control);
  }
  @Test
  public void testState(){
    assertEquals("WallLine should be empty when created.", "", wallLine.state());
    wallLine.putTile(Tile.BLACK);
    wallLine.putTile(Tile.RED);
    assertEquals("WallLine should contain tiles we put on it in correct order," +
            " according to tileTypes.", "RL", wallLine.state());
  }*/
}
