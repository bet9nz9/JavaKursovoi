package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.Job;
import Service.JobService;
import Service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class DescriptionOfJobController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text jobName;

    @FXML
    private Text username;

    @FXML
    private Text hobDescription;

    @FXML
    private Button acceptJobButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        jobName.setText(UserSession.getSelectedJob().getName());
        username.setText(UserSession.getSelectedJob().getUser().getUsername());
        hobDescription.setText(UserSession.getSelectedJob().getDescription());

        acceptJobButton.setOnAction(event -> {
            //UserSession.getJob().setVisible(false);
            Job.getListOfJobs().forEach(e->{
                if (e.equals(UserSession.getSelectedJob())){
                    e.setSelected(true);
                    UserSession.getSelectedJob().setExecutor(UserSession.getSessionUser());
                    JobService jobService = new JobService();
                    jobService.update(UserSession.getSelectedJob());
                    UserService userService = new UserService();
                    userService.update(UserSession.getSessionUser());
                }
            });
        });

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            SceneLoader loader = new SceneLoader("/Views/mainMenu.fxml");
            loader.loadPage();
        });
    }
}
