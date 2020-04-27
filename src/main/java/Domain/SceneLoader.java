package Domain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    private String loadPage;

    public SceneLoader(String loadPage) {
        this.loadPage = loadPage;
    }
    public void loadPage(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(this.loadPage));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
