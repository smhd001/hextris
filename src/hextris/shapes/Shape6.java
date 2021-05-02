package hextris.shapes;

import hextris.Hexagon;

import java.util.Arrays;

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
        getChildren().addAll(hexagons);
    }

    @Override
    public Shape clone() {
        return new Shape6(this.getCenterX(), this.getCenterY());
    }


    public static void main(String[] args) {
        Shape6 shape1 = new Shape6(7, 1);
        System.out.println(Arrays.toString(shape1.getPoints()));
    }

}

