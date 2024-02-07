package Service;

import Helper.DBHelper;
import Helper.MyDialog;
import Model.Rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentService {

    public List<Rent> getAllRent() {
        List<Rent> rentList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT * FROM rent_table where returnCar=?";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, false);
            set = ps.executeQuery();
            while (set.next()) {
                rentList.add(
                        new Rent(
                                set.getInt("rentID"),
                                set.getInt("dID"),
                                set.getInt("custID"),
                                set.getInt("cID"),
                                set.getInt("price"),
                                set.getInt("noOfDay"),
                                set.getInt("totalPrice"),
                                set.getString("fromDate"),
                                set.getString("toDate"),
                                set.getBoolean("returnCar")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return rentList;
    }

    public boolean saveRentInfo(Rent rent) {
        boolean condition = false;
        String query = "INSERT INTO rent_table (dID,custID,cID,price,noOfDay,totalPrice,fromDate,toDate) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, rent.getdID());
            ps.setInt(2, rent.getCustID());
            ps.setInt(3, rent.getcID());
            ps.setInt(4, rent.getPrice());
            ps.setInt(5, rent.getNoOfDay());
            ps.setInt(6, rent.getTotalPrice());
            ps.setString(7, rent.getFromDate());
            ps.setString(8, rent.getToDate());

            int result = ps.executeUpdate();
            if (result == 1)
                condition = true;
            else condition = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, null);
        return condition;
    }

    public List<Rent> getAllRentForReturnCarFalse() {
        List<Rent> rentList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT * FROM rent_table where returnCar=? ";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, false);
            set = ps.executeQuery();
            while (set.next()) {
                rentList.add(
                        new Rent(
                                set.getInt("rentID"),
                                set.getInt("dID"),
                                set.getInt("custID"),
                                set.getInt("cID"),
                                set.getInt("price"),
                                set.getInt("noOfDay"),
                                set.getInt("totalPrice"),
                                set.getString("fromDate"),
                                set.getString("toDate"),
                                set.getBoolean("returnCar")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return rentList;
    }

    public Rent getRentByID(int id) {
        Rent rent = null;
        String query = "SELECT * FROM rent_table where rentID=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            set = ps.executeQuery();
            while (set.next()) {
                rent = new Rent(
                        set.getInt("rentID"),
                        set.getInt("dID"),
                        set.getInt("custID"),
                        set.getInt("cID"),
                        set.getInt("price"),
                        set.getInt("noOfDay"),
                        set.getInt("totalPrice"),
                        set.getString("fromDate"),
                        set.getString("toDate"),
                        set.getBoolean("returnCar")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return rent;
    }

    public boolean updateRentIsAvailable(Rent rent){
        boolean condition=false;
        String query="UPDATE rent_table SET dID=?,custID=?,cID=?,price=?,noOfDay=?,totalPrice=?,fromDate=?,toDate=?,returnCar=? where rentID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setInt(1,rent.getdID());
            ps.setInt(2,rent.getCustID());
            ps.setInt(3,rent.getcID());
            ps.setInt(4,rent.getPrice());
            ps.setInt(5,rent.getNoOfDay());
            ps.setInt(6,rent.getTotalPrice());
            ps.setString(7,rent.getFromDate());
            ps.setString(8,rent.getToDate());
            ps.setBoolean(9,rent.isReturnCar());
            ps.setInt(10,rent.getRentID());

            int result=ps.executeUpdate();
            if(result==1){
                condition=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBHelper.closeConn(conn,ps,null);
        return condition;
    }
}
