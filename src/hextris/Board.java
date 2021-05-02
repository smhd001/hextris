package hextris;

import hextris.shapes.Shape;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Board {
    private final int ROW = 21;
    private final int COLUMN = 15;
    private final Object[][] board = new Object[COLUMN][ROW];

    public Board(Group root)
    {
        //right side of board
        for (int i = 0; i < ROW; i++)
        {
            Hexagon hexagon = new Hexagon(0, i);
            hexagon.setFill(Color.DEEPSKYBLUE);
            board[0][i] = hexagon;
            root.getChildren().add(hexagon);
        }
        //left side of board
        for (int i = 0; i < ROW; i++)
        {
            Hexagon hexagon = new Hexagon(COLUMN - 1, i);
            hexagon.setFill(Color.DEEPSKYBLUE);
            board[COLUMN - 1][i] = hexagon;
            root.getChildren().add(hexagon);
        }
        //down side of board
        for (int i = 0; i < COLUMN; i++)
        {
            Hexagon hexagon = new Hexagon(i, ROW - 1);
            hexagon.setFill(Color.DEEPSKYBLUE);
            board[i][ROW - 1] = hexagon;
            root.getChildren().add(hexagon);
        }
        for (int i = 1; i < COLUMN - 1; i++)
        {
            for (int j = 0; j < ROW - 1; j++)
            {
                Hexagon hexagon = new Hexagon(i, j);
                hexagon.setFill(Color.LIGHTGREEN);
                hexagon.setStroke(Color.DEEPPINK);
                root.getChildren().add(hexagon);
            }
        }
    }

    public void setBoard(Object o, int x, int y)
    {
        board[x][y] = o;
    }

    public boolean isFull(int x, int y)
    {
        return board[x][y] != null;
    }

    public boolean isValidMove(Shape s, int x, int y)
    {
        int[] p = s.getPoints();
        for (int i = 0; i < p.length; i += 2)
        {
            if (isFull(p[i] + x, p[i + 1] + y))
            {
                return false;
            }
        }
        return true;
    }

    public boolean isStop(Shape s, int x, int y)
    {
        int[] p = s.getPoints();
        if (!isValidMove(s, x, y))
        {
            for (int i = 0; i < p.length; i += 2)
            {
                if (p[i] == 0 || p[i] == 14)
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isValidRotate(Shape s)
    {
        Shape shape = s.clone();
        shape.rotateCW(s.getRotateTime());
        shape.rotateCW();
        int[] p = shape.getPoints();
        for (int i = 0; i < p.length; i += 2)
        {
            if (isFull(p[i], p[i + 1]))
                return false;
        }
        return true;
    }

    public void addToBoard(Shape s)
    {
        Object[] objects = s.getChildren().toArray();
        for (Object o : objects)
        {
            board[((Hexagon) o).getX()][((Hexagon) o).getY()] = o;
        }
    }

}