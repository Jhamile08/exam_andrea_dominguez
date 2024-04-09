package entity;

public class Company {
    int id;
    String name;
    String sector;
    String ubication;
    String contact;

    //CONSTRUCTORS

    public Company(String name, String sector, String ubication, String contact) {
        this.name = name;
        this.sector = sector;
        this.ubication = ubication;
        this.contact = contact;
    }

    public Company() {
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", ubication='" + ubication + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
