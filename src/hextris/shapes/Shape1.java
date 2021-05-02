package hextris.shapes;

import hextris.Hexagon;

import java.util.Arrays;

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
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape1(this.getCenterX(), this.getCenterY());
    }


    public static void main(String[] args) {
        Shape1 shape1 = new Shape1(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

