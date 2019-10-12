package Sprite_Editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage mainScene) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Sprite_Editor/GUI.fxml"));
            Scene scene = new Scene(root);
            mainScene.setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
        mainScene.setTitle("Task C: Sprite Editor");
        mainScene.show();
    }

}