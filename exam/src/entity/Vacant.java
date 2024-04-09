package entity;

public class Vacant {
    int id;
    int company_id;
    String title;
    String description;
    String state;
    String duration;
    String tecnology;

    //CONSTRUCTOR


    public Vacant(int company_id, String title, String description, String state, String duration, String tecnology) {
        this.company_id = company_id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.duration = duration;
        this.tecnology = tecnology;
    }

    public Vacant() {
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTecnology() {
        return tecnology;
    }

    public void setTecnology(String tecnology) {
        this.tecnology = tecnology;
    }
    public String info() {
        return "Vacant{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", tecnology='" + tecnology + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Vacant{" +
                ", company_id=" + company_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", tecnology='" + tecnology + '\'' +
                '}';
    }
}
