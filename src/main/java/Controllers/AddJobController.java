package Controllers;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.Job;
import Service.JobService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddJobController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField jobName;

    @FXML
    private TextArea jobDescription;

    @FXML
    private TextField paymentField;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
            JobService jobService = new JobService();
            jobService.add(new Job(new BigDecimal(paymentField.getText()), jobDescription.getText(), jobName.getText(), false, UserSession.getSessionUser()));
            SceneLoader loader = new SceneLoader("/Views/mainMenu.fxml");
            loader.loadPage();
        });
        //закрыть окно
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/mainMenu.fxml");
            loader.loadPage();
        });
    }
}
