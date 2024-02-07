package Model;

public class User {
    private int id,phone;
    private String name,nrc,email,password,address;
    private boolean renting;

    public User(int id, int phone, String name, String nrc, String email, String password, String address, boolean renting) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.nrc = nrc;
        this.email = email;
        this.password = password;
        this.address = address;
        this.renting = renting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRenting() {
        return renting;
    }

    public void setRenting(boolean renting) {
        this.renting = renting;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", nrc='" + nrc + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", renting=" + renting +
                '}';
    }
}
