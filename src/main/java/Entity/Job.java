package Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "coast")
    private BigDecimal coast;
    @Column(name = "description")
    private  String description;
    @Column(name = "name")
    private  String name;
    @Column(name = "is_selected")
    private boolean selected;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "executor_id")
    private User executor;


    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "employer_id")
    private User user;

    private static List<Job> listOfJobs;

    //Constructors

    public Job() {
    }

    public Job(String name, String description, BigDecimal coast,  User user) {
        this.coast = coast;
        this.description = description;
        this.name = name;
        this.user = user;
        selected = false;
        executor = null;
    }

    public Job(BigDecimal coast, String description, String name, boolean selected, User user, User executor) {
        this.coast = coast;
        this.description = description;
        this.name = name;
        this.selected = selected;
        this.user = user;
        this.executor = executor;
    }

    public Job(long id, BigDecimal coast, String description, String name, boolean selected, User user) {
        this.id = id;
        this.coast = coast;
        this.description = description;
        this.name = name;
        this.selected = selected;
        this.user = user;
    }

    public Job(BigDecimal coast, String description, String name, boolean selected, User user) {
        this.coast = coast;
        this.description = description;
        this.name = name;
        this.selected = selected;
        this.user = user;
    }

    //Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getCoast() {
        return coast;
    }

    public void setCoast(BigDecimal coast) {
        this.coast = coast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static List<Job> getListOfJobs() {
        return listOfJobs;
    }

    public static void setListOfJobs(List<Job> listOfJobs) {
        Job.listOfJobs = listOfJobs;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }
}