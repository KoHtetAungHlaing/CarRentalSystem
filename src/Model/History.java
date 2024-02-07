package Model;

public class History {
    private String name,fromDate,toDate;
    private int count,totalPrice;

    public History(String name, String fromDate, String toDate, int count, int totalPrice) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "History{" +
                "name='" + name + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
