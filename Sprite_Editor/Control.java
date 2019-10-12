package Sprite_Editor;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.SnapshotParameters;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Control {

    @FXML
    private Canvas Canvas;
    @FXML
    private ColorPicker colorPicker;

    private int width = 8;

    @FXML
    private void grid8x8() {
        width = 64;
    }

    @FXML
    private void grid16x16() {
        width = 32;
    }

    @FXML
    private void grid32x32() {
        width = 16;
    }

    @FXML
    private void grid64x64() {
        width = 8;
    }

    @FXML
    private void paintOnCanvas(MouseEvent mouseEvent){
        GraphicsContext graphicsContext = Canvas.getGraphicsContext2D();
        Color Color = colorPicker.getValue();
        double mouseX = ( (int) mouseEvent.getX() / width) * width;
        double mouseY = ( (int) mouseEvent.getY() / width) * width;
        graphicsContext.setFill(Color);
        graphicsContext.fillRect(mouseX, mouseY, width, width);
    }

    @FXML
    private void cleanOutCanvas() {
        GraphicsContext graphicsContext = Canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, Canvas.getHeight(), Canvas.getWidth());
    }

    @FXML
    private void saveSprite() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extensionFilter);
        Stage stage = new Stage();
        File file = fileChooser.showSaveDialog(stage);
        if (file == null) {
            return;
        }
        WritableImage image = Canvas.snapshot(new SnapshotParameters(), null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void loadSprite() {
        GraphicsContext graphicsContext = Canvas.getGraphicsContext2D();
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null );
            graphicsContext.drawImage(image, 0, 0, Canvas.getHeight(), Canvas.getWidth());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}