package hextris.shapes;

import hextris.Hexagon;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;


public abstract class Shape extends Group {
    private int r;
    private double d;
    protected Hexagon[] hexagons;
    private int rotateTime;

    abstract public Shape clone();

    private void TranslateY(double y)
    {
        for (Object h : getChildren().toArray())
        {
            ((Hexagon) h).TranslateY(y);
        }
    }

    private void TranslateX(int x)
    {
        for (Object h : getChildren().toArray())
        {
            ((Hexagon) h).TranslateX(x);
        }
    }


    public void moveRight()
    {
        TranslateX(++r);
        if (getCenterX() % 2 == 0)
            TranslateY(d += 0.5);
        else
            TranslateY(d -= 0.5);
    }

    public void moveLeft()
    {
        TranslateX(--r);
        if (getCenterX() % 2 == 0)
            TranslateY(d += 0.5);
        else
            TranslateY(d -= 0.5);
    }

    public void moveDown()
    {
        TranslateY(++d);
    }

    public void rotateCW()
    {
        Rotate rotate = new Rotate(60, hexagons[0].getBoundsInLocal().getCenterX(), hexagons[0].getBoundsInLocal().getCenterY());
        for (Object o : getChildren().toArray())
            ((Hexagon) o).getTransforms().add(rotate);
        rotateTime++;
    }

    public void rotateCW(int n)
    {
        Rotate rotate = new Rotate(60, hexagons[0].getBoundsInLocal().getCenterX(), hexagons[0].getBoundsInLocal().getCenterY());
        for (int i = 0; i < n; i++)
        {
            for (Object o : getChildren().toArray())
                ((Hexagon) o).getTransforms().add(rotate);
        }
    }

    public int getRotateTime() {
        return rotateTime %= 6;
    }

    public int[] getPoints() {
        Object[] p = getChildren().toArray();
        int[] a = new int[2 * p.length];
        for (int i = 0; i < a.length; i += 2)
        {
            a[i] = ((Hexagon) p[i / 2]).getX();
            a[i + 1] = ((Hexagon) p[i / 2]).getY();
        }
        return a;
    }

    public int getCenterX()
    {
        return hexagons[0].getX();
    }

    public int getCenterY()
    {
        return hexagons[0].getY();
    }

    public static Shape newShape()
    {
        System.out.println();
        return new Shape2(1, 3);
    }

}