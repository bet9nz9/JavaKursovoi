package Models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "employer")
public class Employer extends User {
    //связь один ко многим к таблице работ
    @OneToMany(mappedBy = "EMPLOYER", cascade = CascadeType.ALL)
    private ArrayList<Job> jobs = new ArrayList<Job>();

}
