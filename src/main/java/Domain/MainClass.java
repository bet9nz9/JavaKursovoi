package Domain;

import Entity.Job;
import Entity.User;
import Service.JobService;
import Service.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        SceneLoader sceneLoader = new SceneLoader("JavaFX and Maven","/Views/entrance.fxml");
        sceneLoader.loadPage();
    }
}
