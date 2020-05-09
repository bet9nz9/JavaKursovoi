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
    private Text jobDescription;

    @FXML
    private Button acceptJobButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        jobName.setText(UserSession.getSelectedJob().getName());
        username.setText(UserSession.getSelectedJob().getUser().getUsername());
        jobDescription.setText(UserSession.getSelectedJob().getDescription());
        /*при нажатии на ссылку работы,работа помещается в UserSession для последующего использования
        при нажатии на кнопку accept в коллекции работ ищется конткретная работа,эта работа изменяет поле "выбранная(selected)" в коллекции и в базе
        после это проводится обновления базы данных*/
        acceptJobButton.setOnAction(event -> {
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
