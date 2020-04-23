package Entity;

/*@Entity
@Table(name = "employer")*/
public class Employer extends User {
    /*private static List<Employer> employers;
    //связь один ко многим к таблице работ
    @OneToMany(mappedBy = "EMPLOYER", cascade = CascadeType.ALL)
    private List<Job> jobs = new ArrayList<Job>();

    //Constructors
    public Employer() {
    }

    public Employer(List<Employer> employers, ArrayList<Job> jobs) {
        this.employers = employers;
        this.jobs = jobs;
    }

    public Employer(List<Employer> employers) {
        this.employers = employers;
    }

    //Getters and setters

    public static List<Employer> getEmployers() {
        return employers;
    }

    public static void setEmployers(List<Employer> employers) {
        Employer.employers = employers;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }*/
}
