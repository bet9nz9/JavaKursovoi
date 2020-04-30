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
    @Column(name = "visible")
    private boolean visible;
    @Column(name = "is_selected")
    private boolean selected;
    //связь один к одному к таблице работодателей
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
        visible = true;
        selected = false;
    }

    public Job(BigDecimal coast, String description, String name, boolean visible, boolean selected, User user) {
        this.coast = coast;
        this.description = description;
        this.name = name;
        this.visible = visible;
        this.selected = selected;
        this.user = user;
    }

    public Job(long id, BigDecimal coast, String description, String name, boolean visible, boolean selected, User user) {
        this.id = id;
        this.coast = coast;
        this.description = description;
        this.name = name;
        this.visible = visible;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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
}
