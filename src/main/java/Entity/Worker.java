package Entity;

/*@Entity
@Table(name = "worker")*/
public class Worker extends User {
    /*//связь один к одному
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name = "selectJob")
    private Job selectJob;

    private static List<Worker> workers;

    //Constructors
    public Worker() {
    }

    public Worker(Job selectJob, List<Worker> workers) {
        this.selectJob = selectJob;
        this.workers = workers;
    }


    //getters and setters

    public Job getSelectJob() {
        return selectJob;
    }

    public void setSelectJob(Job selectJob) {
        this.selectJob = selectJob;
    }

    public static List<Worker> getWorkers() {
        return workers;
    }

    public static void setWorkers(List<Worker> workers) {
        Worker.workers = workers;
    }*/
}
