package Models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker extends User {
    //связь один к одному
    @OneToOne
    @JoinColumn(name = "selectJob")
    private Job selectJob;

}
