package hextris;

import hextris.shapes.Shape;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    Shape shape = Shape.newShape();
    boolean pause = false;
    Group root = new Group();
    Board board = new Board(root);
    Label label = new Label(Integer.toString(board.point));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root);
        root.getChildren().add(shape);
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(1),
                e ->
                {
                    if (board.isValidMove(shape, 0, 1) && !board.isGameOver())
                        shape.moveDown();

                    if (board.isStop(shape, 0, 1) && !board.isGameOver())
                    {
                        board.addToBoard(shape);
                        shape = Shape.newShape();
                        root.getChildren().add(shape);
                        try
                        {
                            board.clearRow();
                            label.setText(Integer.toString(board.point));
                        } catch (InterruptedException interruptedException)
                        {
                            interruptedException.printStackTrace();
                        }
                    }
                    if (board.isGameOver())
                    {
                        Label label3 = new Label("you are game over");
                        label3.setLayoutX(Hexagon.getA() * Board.getCOLUMN() - 30);
                        label3.setLayoutY(Hexagon.getA() * Board.getCOLUMN());
                        label3.setScaleX(2);
                        label3.setScaleY(2);
                        root.getChildren().add(label3);
                    }
                }));
        System.out.println("ppppp");
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.P)
            {
                if (pause)
                {
                    tl.play();
                    pause = false;
                } else
                {
                    tl.pause();
                    pause = true;
                }
            }
            if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W)
            {
                if (board.isValidRotate(shape))
                    shape.rotateCW();
            }
            if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S)
            {
                if (board.isValidMove(shape, 0, 1))
                    shape.moveDown();
            }
            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D)
            {
                if (board.isValidMove(shape, 1, 0))
                    shape.moveRight();
            }
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A)
            {
                if (board.isValidMove(shape, -1, 0))
                    shape.moveLeft();
            }
            if (e.getCode() == KeyCode.SPACE)
            {
                while (board.isValidMove(shape, 0, 1))
                {
                    shape.moveDown();
                }
            }
            if (e.getCode() == KeyCode.R)
            {
                board = new Board(root);
                shape = Shape.newShape();
                root.getChildren().add(shape);
            }
            if (e.getCode() == KeyCode.Q)
            {
                stage.close();
            }
        });
        label.setScaleX(2);
        label.setScaleY(2);
        label.setLayoutX(2 * Hexagon.getA() * Board.getCOLUMN() - 70);
        label.setLayoutY(Hexagon.getA() * Board.getCOLUMN() - 190);
        Label label2 = new Label("score");
        label2.setLayoutX(2 * Hexagon.getA() * Board.getCOLUMN() - 80);
        label2.setLayoutY(Hexagon.getA() * Board.getCOLUMN() - 230);
        label2.setScaleX(2);
        label2.setScaleY(2);
        root.getChildren().addAll(label, label2);
        stage.setScene(scene);
        stage.setWidth(2 * Hexagon.getA() * Board.getCOLUMN() + 40);
        stage.setTitle("H   E   X   T   R   I   X");
        stage.show();
    }
}
