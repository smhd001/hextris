package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.paint.Color;

public class Shape6 extends Shape {
    public Shape6(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x - 1, y + 1),
                        new Hexagon(x + 1, y + 1)
                };
        setColor(Color.RED);
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape6(this.getCenterX(), this.getCenterY());
    }
}

