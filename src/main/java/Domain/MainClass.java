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
        //Загрузить все из базы при запуске программы
        User.setUsers(new UserService().getAll());
        Job.setListOfJobs(new JobService().getAll());

        //
        System.out.println("***************************************************");
        User.getUsers().forEach(x->System.out.println(x.toString()));
        System.out.println("***************************************************");
        System.out.println(User.getUsersMap().values());
        //

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/Views/entrance.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("JavaFX and Maven");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
