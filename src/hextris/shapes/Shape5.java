package hextris.shapes;

import hextris.Hexagon;

import java.util.Arrays;

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
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape5(this.getCenterX(), this.getCenterY());
    }


    public static void main(String[] args) {
        Shape5 shape1 = new Shape5(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

