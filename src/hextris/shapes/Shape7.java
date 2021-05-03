package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.paint.Color;

public class Shape7 extends Shape {
    public Shape7(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x + 1, y),
                        new Hexagon(x - 1, y)
                };
        setColor(Color.DARKBLUE);
        getChildren().addAll(hexagons);
    }
    @Override
    public Shape clone() {
        return new Shape7(this.getCenterX(), this.getCenterY());
    }
}

