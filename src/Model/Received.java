package Model;

public class Received {
    private int returnID,rentID,extraDay,extraMoney,totalPrice;
    String returnDate;

    public Received(int returnID, int rentID, int extraDay, int extraMoney, int totalPrice, String returnDate) {
        this.returnID = returnID;
        this.rentID = rentID;
        this.extraDay = extraDay;
        this.extraMoney = extraMoney;
        this.totalPrice = totalPrice;
        this.returnDate = returnDate;
    }

    public int getReturnID() {
        return returnID;
    }

    public void setReturnID(int returnID) {
        this.returnID = returnID;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public int getExtraDay() {
        return extraDay;
    }

    public void setExtraDay(int extraDay) {
        this.extraDay = extraDay;
    }

    public int getExtraMoney() {
        return extraMoney;
    }

    public void setExtraMoney(int extraMoney) {
        this.extraMoney = extraMoney;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Received{" +
                "returnID=" + returnID +
                ", rentID=" + rentID +
                ", extraDay=" + extraDay +
                ", extraMoney=" + extraMoney +
                ", totalPrice=" + totalPrice +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
