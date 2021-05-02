package hextris.shapes;

import hextris.Hexagon;

import java.util.Arrays;

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
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape2(this.getCenterX(), this.getCenterY());
    }


    public static void main(String[] args) {
        Shape2 shape1 = new Shape2(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

