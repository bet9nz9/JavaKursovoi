package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Entity.User;
import Service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        registryButton.setOnAction(event->{
            User.getUsers().add(new User(login.getText(),password.getText(),username.getText()));
            UserService userService = new UserService();
            userService.add(new User(login.getText(),password.getText(),username.getText()));
            registryButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/entrance.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}
