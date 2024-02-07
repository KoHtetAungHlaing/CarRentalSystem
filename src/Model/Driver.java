package Model;

public class Driver {
    private int id,phone;
    private String name,nrc,address;
    private boolean available;

    public Driver(int id, int phone, String name, String nrc, String address, boolean available) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.nrc = nrc;
        this.address = address;
        this.available = available;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", nrc='" + nrc + '\'' +
                ", address='" + address + '\'' +
                ", available=" + available +
                '}';
    }
}
