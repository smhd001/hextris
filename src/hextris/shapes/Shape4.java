package hextris.shapes;

import hextris.Hexagon;

import java.util.Arrays;

public class Shape4 extends Shape {
    public Shape4(int x, int y)
    {
        hexagons = new Hexagon[]
                {
                        new Hexagon(x, y),
                        new Hexagon(x, y - 1),
                        new Hexagon(x, y + 1),
                        new Hexagon(x + 1, y)
                };
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape4(this.getCenterX(), this.getCenterY());
    }


    public static void main(String[] args) {
        Shape4 shape1 = new Shape4(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

