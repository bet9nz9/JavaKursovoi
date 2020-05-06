package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.Job;
import Entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PersonalCabinetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text usernameText;

    @FXML
    private VBox listOfReceived;

    @FXML
    private VBox listOfCreated;

    @FXML
    private Button changeDescriptionButton;

    @FXML
    private Text loginText;

    @FXML
    private Button backButton;

    @FXML
    private TextField descriptionText;

    @FXML
    void initialize() {
        usernameText.setText(UserSession.getSessionUser().getUsername());
        descriptionText.setText(UserSession.getSessionUser().getDescription());
        loginText.setText(UserSession.getSessionUser().getLogin());
        //list of created
        Job.getListOfJobs().forEach(e->{
            System.out.println(UserSession.getSessionUser().getUsername()+"///"+e.getUser().getUsername());
            System.out.println(UserSession.getSessionUser().getLogin()+"///"+e.getUser().getLogin());
            System.out.println(UserSession.getSessionUser()+"///"+e.getUser());
            if(UserSession.getSessionUser().getId().equals(e.getUser().getId())){
                Hyperlink hyperlink = new Hyperlink(e.getName());
                hyperlink.setOnAction(x->{
                    hyperlink.getScene().getWindow().hide();
                    SceneLoader loader = new SceneLoader("/Views/jobDescription.fxml");
                    loader.loadPage();
                });
                listOfCreated.getChildren().add(hyperlink);
            }
            if (e.getExecutor() instanceof User){
                if (UserSession.getSessionUser().getId().equals(e.getExecutor().getId())){
                    Hyperlink hyperlink = new Hyperlink(e.getName());
                    hyperlink.setOnAction(x->{
                        hyperlink.getScene().getWindow().hide();
                        SceneLoader loader = new SceneLoader("/Views/jobDescription.fxml");
                        loader.loadPage();
                    });
                    listOfReceived.getChildren().add(hyperlink);
                }
            }
        });

        //ДОБВИТЬ ИЗМЕНИЕ В БАЗЕ
        changeDescriptionButton.setOnAction(event -> {
            UserSession.getSessionUser().setDescription(descriptionText.getText());
        });

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/mainMenu.fxml");
            loader.loadPage();
        });

    }
}