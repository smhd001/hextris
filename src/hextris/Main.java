package hextris;

import hextris.shapes.Shape;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    Shape shape = Shape.newShape();
    boolean pause = false;
    Group root = new Group();
    Board board = new Board(root);

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root);
        root.getChildren().add(shape);

        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(1),
                e ->
                {
                    if (board.isValidMove(shape, 0, 1))
                        shape.moveDown();

                    if (board.isStop(shape, 0, 1))
                    {
                        board.addToBoard(shape);
                        shape = Shape.newShape();
                        root.getChildren().add(shape);
                        try
                        {
                            board.clearRow();
                        } catch (InterruptedException interruptedException)
                        {
                            interruptedException.printStackTrace();
                        }
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
        stage.setScene(scene);
        stage.setTitle("H   E   X   T   R   I   X");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
