package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.SceneLoader;
import Domain.UserSession;
import Entity.Job;
import Service.JobService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.jws.soap.SOAPBinding;

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
        jobName.setText(UserSession.getJob().getName());
        username.setText(UserSession.getJob().getUser().getUsername());
        hobDescription.setText(UserSession.getJob().getDescription());

        acceptJobButton.setOnAction(event -> {
            UserSession.getJob().setVisible(false);
            Job.getListOfJobs().forEach(e->{
                if (e.equals(UserSession.getJob())){
                    UserSession.getSessionUser().setSelectJob(e);
                    e.setVisible(false);
                    JobService service = new JobService();
                    service.update(UserSession.getJob());
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
