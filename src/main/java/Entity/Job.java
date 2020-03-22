package Entity;

public class Job {
    private long id;
    private  float coast;
    private  String description;
    private  String name;
    private boolean visible;
    private boolean selected;
    private long user_id;

    public Job() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getCoast() {
        return coast;
    }

    public void setCoast(float coast) {
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", coast=" + coast +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", visible=" + visible +
                ", selected=" + selected +
                ", user_id=" + user_id +
                '}';
    }
}
