package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.paint.Color;

public class Shape3 extends Shape {
    public Shape3(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x + 1, y + 1),
                        new Hexagon(x + 1, y + 2)
                };
        setColor(Color.GREEN);
        getChildren().addAll(hexagons);
    }
    @Override
    public Shape clone() {
        return new Shape3(this.getCenterX(), this.getCenterY());
    }
}

