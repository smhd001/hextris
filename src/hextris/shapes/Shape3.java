package hextris.shapes;

import hextris.Hexagon;

import java.util.Arrays;

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
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape3(this.getCenterX(), this.getCenterY());
    }


    public static void main(String[] args) {
        Shape3 shape1 = new Shape3(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

