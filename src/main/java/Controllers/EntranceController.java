package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.User;
import Service.UserService;
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
        User.setUsers(new UserService().getAll());

        registrationButton.setOnAction(event->{
            registrationButton.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/registrationScene.fxml");
            loader.loadPage();
        });

        /* В коллекции юзеров ищется необходимый по логину,после чего сравнивается пароль,если он неправильный - выскакивает алерт
        В UserSession заносятся данные пользователя
         */
        signButton.setOnAction(event->{
            User.getUsers().forEach(user->{
                if (user.getLogin().equals(loginField.getText())){
                    if (user.getPass().equals(passField.getText())){
                        UserSession session = new UserSession();
                        session.setSessionUser(user);
                        signButton.getScene().getWindow().hide();
                        SceneLoader loader = new SceneLoader("/Views/mainMenu.fxml");
                        loader.loadPage();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("");
                        alert.setContentText("Wrong login or password!");
                        alert.showAndWait();
                    }
                }
            });
        });
    }
}
