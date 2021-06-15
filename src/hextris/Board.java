package hextris;

import hextris.shapes.Shape;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;


public class Board {
    private static final int ROW = 21;
    private static final int COLUMN = 15;
    private final Object[][] board = new Object[COLUMN][ROW];
    int point;

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
                hexagon.setFill(Color.LIGHTGREY);
                hexagon.setStroke(Color.DARKGRAY);
                root.getChildren().add(hexagon);
            }
        }
    }

    public static int getROW() {
        return ROW;
    }

    public static int getCOLUMN() {
        return COLUMN;
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

    public boolean isRowFull(int row)
    {
        for (int i = 1; i < COLUMN - 1; i++)
        {
            if (!isFull(i, row))
                return false;
        }
        return true;
    }

    public boolean isGameOver()
    {
        return isFull(6, 1);
    }

    public void deleteRow(int row) throws InterruptedException
    {
        point += 10;
        //delete one row
        for (int i = 1; i < COLUMN - 1; i++)
        {
            ((Group) (((Hexagon) board[i][row]).getParent())).getChildren().remove(board[i][row]);
            board[i][row] = null;
        }
        //move above row down
        for (int i = row; i > 0; i--)
        {
            for (int j = 1; j < COLUMN - 1; j++)
            {
                if (isFull(j, i))
                {
                    ((Hexagon) (board[j][i])).setTranslateY(((Hexagon) board[j][i]).getTranslateY() + Hexagon.getH());
                    board[j][i + 1] = board[j][i];
                } else if (i < 19)
                {
                    board[j][i + 1] = board[j][i];
                }
            }
        }
        TimeUnit.MILLISECONDS.sleep(500);
    }

    public void clearRow() throws InterruptedException
    {
        for (int i = ROW - 2; i > 1; i--)
        {
//            printBoard();
            if (isRowFull(i))
            {
                deleteRow(i);
                i++;
            }
        }
    }

    public void printBoard()
    {
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COLUMN; j++)
            {
                if (isFull(j, i))
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");

            }
            System.out.println();
        }
        System.out.println("************");
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