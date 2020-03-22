package Entity;

public class User {
    private long id;
    private  String login;
    private  String pass;
    private  String username;
    private  String description;
    private long jobdone_id;
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

    public long getJobdone_id() {
        return jobdone_id;
    }

    public void setJobdone_id(long jobdone_id) {
        this.jobdone_id = jobdone_id;
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
                ", jobdone_id=" + jobdone_id +
                ", job_id=" + job_id +
                '}';
    }
}
