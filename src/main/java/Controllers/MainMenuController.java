package Controllers;

import java.net.URL;
import java.util.ResourceBundle;


import Domain.SceneLoader;
import Domain.UserSession;
import Entity.Job;
import Entity.User;
import Service.JobService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton menu;

    @FXML
    private MenuItem personalOffice;

    @FXML
    private MenuItem exit;

    @FXML
    private MenuItem addNewVacancy;

    @FXML
    private VBox listOfWork;

    @FXML
    void initialize() {
        User.getUsers().clear();
        Job.setListOfJobs(new JobService().getAll());
        Job.getListOfJobs().forEach(e->{
            if (!e.isSelected()){
                Hyperlink hyperlink = new Hyperlink(e.getName());
                hyperlink.setOnAction(x->{
                    //При нажатии на ссылку выбранная работа помещается в UserSession
                    UserSession.setSelectedJob(e);
                    hyperlink.getScene().getWindow().hide();
                    SceneLoader loader = new SceneLoader("/Views/jobDescription.fxml");
                    loader.loadPage();
                });
                listOfWork.getChildren().add(hyperlink);
            }
        });

        menu.setText(UserSession.getSessionUser().getUsername());
        addNewVacancy.setOnAction(event->{
            menu.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/jobAdd.fxml");
            loader.loadPage();
        });
        //Выход с аккаунта,пользователь сессии устанавливается в null
        exit.setOnAction(event -> {
            UserSession userSession = new UserSession();
            userSession.setSessionUser(null);
            menu.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/entrance.fxml");
            loader.loadPage();
        });
        personalOffice.setOnAction(event -> {
            menu.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/personalCabinet.fxml");
            loader.loadPage();
        });
    }
}
