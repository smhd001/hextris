package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.paint.Color;

import java.util.Arrays;

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


    public static void main(String[] args) {
        Shape7 shape1 = new Shape7(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

