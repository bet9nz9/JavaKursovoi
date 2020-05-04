package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.Job;
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
        UserSession.getSessionUser().getJobs().forEach(e->{
            Hyperlink hyperlink = new Hyperlink(e.getName());
            hyperlink.setOnAction(x->{
            });
            listOfCreated.getChildren().add(hyperlink);
        });
        //list of received
       Hyperlink hyperlink=new Hyperlink(UserSession.getSessionUser().getSelectJob().getName());
       listOfReceived.getChildren().add(hyperlink);

       changeDescriptionButton.setOnAction(event -> {
           UserSession.getSessionUser().setDescription(descriptionText.getText());
       });

    }
}
