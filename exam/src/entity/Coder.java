package entity;

public class Coder {
    int id;
    String name;
    String surname;
    String identity;
    int cohorte;
    String cv;
    String clan;

    //CONSTRUCTORS

    public Coder(String name, String surname, String identity, int cohorte, String cv, String clan) {
        this.name = name;
        this.surname = surname;
        this.identity = identity;
        this.cohorte = cohorte;
        this.cv = cv;
        this.clan = clan;
    }

    public Coder() {
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getCohorte() {
        return cohorte;
    }

    public void setCohorte(int cohorte) {
        this.cohorte = cohorte;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }
    public String info() {
        return "Coder" +
                "id:" + id +
                ", name : " + name + " " + surname + '\'' +
                ", identity: " + identity + '\'' +
                ", cohorte: " + cohorte +
                ", cv: " + cv + '\'' +
                ", clan: " + clan + '\'' +
                '}';
    }
    @Override
    public String toString() {
        return "Coder: " +
                ", name: " + name + ' ' + surname + '\'' ;
    }
}
