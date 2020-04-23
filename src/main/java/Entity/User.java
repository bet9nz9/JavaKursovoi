package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "login")
    private  String login;
    @Column(name = "password")
    private  String pass;
    @Column(name = "username")
    private  String username;
    @Column(name = "description")
    private  String description;

    //связь один к одному
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "selectJob")
    private Job selectJob;

    //связь один ко многим к таблице работ
    @OneToMany(targetEntity = Job.class,mappedBy = "user", cascade = CascadeType.ALL)
    private List<Job> jobs;

    private static List<User> users;

    //Constructors

    public User() {
    }

    public User(String login, String pass, String username) {
        this.login = login;
        this.pass = pass;
        this.username = username;
        this.description = null;
        this.jobs = null;
        this.selectJob = null;
    }

    public User(long id, String login, String pass, String username, String description, Job selectJob, List<Job> jobs) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.username = username;
        this.description = description;
        this.selectJob = selectJob;
        this.jobs = jobs;
    }

    //Getters and setters


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

    public Job getSelectJob() {
        return selectJob;
    }

    public void setSelectJob(Job selectJob) {
        this.selectJob = selectJob;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        jobs.forEach(a->{
            a.setUser(this);
        });
        this.jobs = jobs;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        User.users = users;
    }
}
