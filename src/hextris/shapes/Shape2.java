package hextris.shapes;
import hextris.Hexagon;
import javafx.scene.paint.Color;

public class Shape2 extends Shape {
    public Shape2(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x, y + 1),
                        new Hexagon(x + 1, y + 2)
                };
        setColor(Color.ORANGE);
        getChildren().addAll(hexagons);
    }
    @Override
    public Shape clone() {
        return new Shape2(this.getCenterX(), this.getCenterY());
    }
}

