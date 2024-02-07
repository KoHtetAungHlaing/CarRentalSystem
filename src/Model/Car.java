package Model;

public class Car {
    private int id,seat,price;
    private String regNo,model;
    private boolean available;

    public Car(int id, int seat, int price, String regNo, String model, boolean available) {
        this.id = id;
        this.seat = seat;
        this.price = price;
        this.regNo = regNo;
        this.model = model;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", seat=" + seat +
                ", price=" + price +
                ", regNo='" + regNo + '\'' +
                ", model='" + model + '\'' +
                ", available=" + available +
                '}';
    }
}
