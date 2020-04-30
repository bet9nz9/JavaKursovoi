package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EntranceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passField;

    @FXML
    private Button registrationButton;

    @FXML
    private Button signButton;

    @FXML
    void initialize() {
        //Sweet home Alabama, where the skies are so blue
        //SWEET HOME ALABAMA, LORD I'M COMING HOME TO YOU
        registrationButton.setOnAction(event->{
            registrationButton.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/registrationScene.fxml");
            loader.loadPage();
        });

        signButton.setOnAction(event->{
            for (User user : User.getUsers()){
                if (user.getLogin().equals(loginField.getText())){
                    if (user.getPass().equals(passField.getText())){
                        UserSession session = new UserSession();
                        session.setSessionUser(user);
                        signButton.getScene().getWindow().hide();
                        SceneLoader loader = new SceneLoader("/Views/mainMenu.fxml");
                        loader.loadPage();
                    }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("");
                        alert.setContentText("Wrong login or password!");
                        alert.showAndWait();
                    }
                }
            }

        });
    }
}
