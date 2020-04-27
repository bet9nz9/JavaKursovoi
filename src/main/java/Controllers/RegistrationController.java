package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import Domain.SceneLoader;
import Entity.User;
import Service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registryButton;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void initialize() {
        //я мог бы выпить море
        registryButton.setOnAction(event->{
            //Создаю стрим из юзеров, если есть юзер с таким же логином кидаю алерт и перезагружаю текущую
            //можно место перезагрузки обнулять поля
            //если же все хорошо, добавляется юзер в коллекцию и в бд
            Stream<User> stream =  User.getUsers().stream();
            if(stream.anyMatch(x->x.getLogin().equals(login.getText()))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setContentText("Login is already used.");
                alert.showAndWait();
                login.setText("");
                password.setText("");
                username.setText("");
                registryButton.getScene().getWindow().hide();
                SceneLoader loader = new SceneLoader("/Views/registrationScene.fxml");
                loader.loadPage();
            }else {
                // я мог бы стать другим
                User.getUsers().add(new User(login.getText(),password.getText(),username.getText()));
                UserService userService = new UserService();
                userService.add(new User(login.getText(),password.getText(),username.getText()));
                registryButton.getScene().getWindow().hide();
                SceneLoader loader = new SceneLoader("/Views/entrance.fxml");
                loader.loadPage();
            }// Вечно молодой, вечно пьяный
        });

    }
}
