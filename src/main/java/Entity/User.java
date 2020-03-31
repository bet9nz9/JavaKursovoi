package Entity;

public class User {
    private long id;
    private  String login;
    private  String pass;
    private  String username;
    private  String description;
    private long jobDone_id;
    private long job_id;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getJobDone_id() {
        return jobDone_id;
    }

    public void setJobDone_id(long jobDone_id) {
        this.jobDone_id = jobDone_id;
    }

    public long getJob_id() {
        return job_id;
    }

    public void setJob_id(long job_id) {
        this.job_id = job_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", jobDone_id=" + jobDone_id +
                ", job_id=" + job_id +
                '}';
    }
}
