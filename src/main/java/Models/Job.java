package Models;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "coast")
    private  float coast;
    @Column(name = "description")
    private  String description;
    @Column(name = "name")
    private  String name;
    @Column(name = "visible")
    private boolean visible;
    @Column(name = "is_selected")
    private boolean selected;
    //сязь один к одному к таблице работников
    @OneToOne(mappedBy = "selectJob")
    private Worker worker;
    //связь один к одному к таблице работодателей
    @ManyToOne
    @JoinColumn(name = "employeer_id")
    private Employer employer;

}
