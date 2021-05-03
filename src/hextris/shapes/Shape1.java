package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.paint.Color;

public class Shape1 extends Shape {
    public Shape1(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x, y + 1),
                        new Hexagon(x, y + 2)
                };
        setColor(Color.YELLOW);
        getChildren().addAll(hexagons);
    }
    @Override
    public Shape clone() {
        return new Shape1(this.getCenterX(), this.getCenterY());
    }
}

