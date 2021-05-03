package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.paint.Color;

public class Shape5 extends Shape {
    public Shape5(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x, y + 1),
                        new Hexagon(x - 1, y)
                };
        setColor(Color.DEEPPINK);
        getChildren().addAll(hexagons);
    }
    @Override
    public Shape clone() {
        return new Shape5(this.getCenterX(), this.getCenterY());
    }
}

