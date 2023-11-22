package sk.uniba.fmph.dcs;

import java.util.Optional;

public class FinalPointsCalculation {
    public static Points getPoints(Optional<Tile>[][] wall){
        Horizontal horizontalLineRule = new Horizontal();
        Vertical verticalLineRule = new Vertical();
        Color fullColorRule = new Color();

        int sum = fullColorRule.calculatePoints(wall) + horizontalLineRule.calculatePoints(wall) + verticalLineRule.calculatePoints(wall);

        return new Points(sum);
    }
}