package entity;

public class Hiring {
    int id;
    int vacant_id;
    int coder_id;
    String date_aplication;
    String state;
    float salary;

    //CONSTRUCTORS


    public Hiring(int vacant_id, int coder_id, String state, float salary) {
        this.vacant_id = vacant_id;
        this.coder_id = coder_id;
        this.state = state;
        this.salary = salary;
    }

    public Hiring() {
    }

//GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVacant_id() {
        return vacant_id;
    }

    public void setVacant_id(int vacant_id) {
        this.vacant_id = vacant_id;
    }

    public int getCoder_id() {
        return coder_id;
    }

    public void setCoder_id(int coder_id) {
        this.coder_id = coder_id;
    }

    public String getDate_aplication() {
        return date_aplication;
    }

    public void setDate_aplication(String date_aplication) {
        this.date_aplication = date_aplication;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Hiring{" +
                "id=" + id +
                ", vacant_id=" + vacant_id +
                ", coder_id=" + coder_id +
                ", state='" + state + '\'' +
                ", salary=" + salary +
                '}';
    }
}
