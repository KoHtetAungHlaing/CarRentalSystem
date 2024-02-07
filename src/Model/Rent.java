package Model;

public class Rent {
    int rentID,dID,custID,cID,price,noOfDay,totalPrice;
    String fromDate,toDate;
    private boolean returnCar;

    public Rent(int rentID, int dID, int custID, int cID, int price, int noOfDay, int totalPrice, String fromDate, String toDate, boolean returnCar) {
        this.rentID = rentID;
        this.dID = dID;
        this.custID = custID;
        this.cID = cID;
        this.price = price;
        this.noOfDay = noOfDay;
        this.totalPrice = totalPrice;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.returnCar = returnCar;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public int getdID() {
        return dID;
    }

    public void setdID(int dID) {
        this.dID = dID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNoOfDay() {
        return noOfDay;
    }

    public void setNoOfDay(int noOfDay) {
        this.noOfDay = noOfDay;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean isReturnCar() {
        return returnCar;
    }

    public void setReturnCar(boolean returnCar) {
        this.returnCar = returnCar;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentID=" + rentID +
                ", dID=" + dID +
                ", custID=" + custID +
                ", cID=" + cID +
                ", price=" + price +
                ", noOfDay=" + noOfDay +
                ", totalPrice=" + totalPrice +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", returnCar=" + returnCar +
                '}';
    }
}
