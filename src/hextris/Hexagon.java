package hextris;

import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {
    private double x, y;
    private static final int a = 20;
    static private double h = a * Math.sqrt(3);

    private Hexagon(double x, double y) {
        super(x + a / 2.0, y + h / 2,
                x + a, y,
                x + a / 2.0, y - h / 2,
                x - a / 2.0, y - h / 2,
                x - a, y,
                x - a / 2.0, y + h / 2
        );

    }

    public Hexagon(int x, int y) {
        this(a + 3.0 / 2 * a * x,
                h / 2.0 + y * h + (x % 2 == 0 ? h / 2 : 0));
        this.x = x;
        this.y = y;
    }


    public static int getA() {
        return a;
    }

    public static double getH() {
        return h;
    }

    public int getX()
    {
        double b = this.getBoundsInParent().getCenterX();
        this.x = Math.round((float) ((b - a) * 2.0 / (3 * a)));
        return (int) this.x;
    }

    public int getY()
    {
        double b = this.getBoundsInParent().getCenterY();
        return Math.round((float) ((b - h / 2.0 - (x % 2 == 0 ? h / 2 : 0)) / h));
    }

    public void TranslateX(int x)
    {
        this.setTranslateX(3.0 / 2 * a * x);
        this.setTranslateY(-h / 2 + getTranslateY());
        this.x = getX();
        this.y = getY();
    }

    public void TranslateY(double y)
    {
        this.setTranslateY(h * y);
        this.y = getY();
    }
}
