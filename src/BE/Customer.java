package BE;

public class Customer {

    private int id;
    private String Name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Boolean over12YearsOld;

    public Customer(int id, String name, String lastName, String phoneNumber, String email, Boolean over12YearsOld) {
        this.id = id;
        Name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.over12YearsOld = over12YearsOld;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getOver12YearsOld() {
        return over12YearsOld;
    }

    public void setOver12YearsOld(Boolean over12YearsOld) {
        this.over12YearsOld = over12YearsOld;
    }
}
