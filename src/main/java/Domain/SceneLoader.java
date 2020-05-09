package Domain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//Класс для создания и прогрузки новых окон
public class SceneLoader {
    private String loadPage;
    private Stage stage = new Stage();
    public SceneLoader(String loadPage) {
        this.loadPage = loadPage;
    }
    public SceneLoader(String title, String page){
        stage.setTitle(title);
        loadPage=page;
    }
    public void loadPage(){
        closeStage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(this.loadPage));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage newStage = new Stage();//
        newStage.setScene(new Scene(root));//
        newStage.show();//
    }
    public void closeStage(){
        stage.close();
    }
}
