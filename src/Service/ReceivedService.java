package Service;

import Helper.DBHelper;
import Helper.MyDialog;
import Model.Received;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceivedService {
    public boolean saveReturnInfo(Received returnCar) {
        boolean condition = false;
        String query = "INSERT INTO car_received (rentID,returnDate,extraDay,extraMoney,totalPrice) VALUES (?,?,?,?,?)";
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, returnCar.getRentID());
            ps.setString(2, returnCar.getReturnDate());
            ps.setInt(3, returnCar.getExtraDay());
            ps.setInt(4, returnCar.getExtraMoney());
            ps.setInt(5, returnCar.getTotalPrice());

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

    public List<Received> getAllReceivedForReturnList() {
        List<Received> receivedList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        //String query = "SELECT * FROM car_received";
        String query = "SELECT c.* FROM car_received as c, rent_table as r WHERE c.rentID= r.rentID AND r.returnCar=?";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, true);
            set = ps.executeQuery();
            while (set.next()) {
                receivedList.add(
                        new Received(
                                set.getInt("returnID"),
                                set.getInt("rentID"),
                                set.getInt("extraDay"),
                                set.getInt("extraMoney"),
                                set.getInt("totalPrice"),
                                set.getString("returnDate")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return receivedList;
    }

    public List<Received> getAllReceivedForUpdate() {
        List<Received> receivedList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT c.* FROM car_received as c, rent_table as r WHERE c.rentID= r.rentID";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while (set.next()) {
                receivedList.add(
                        new Received(
                                set.getInt("returnID"),
                                set.getInt("rentID"),
                                set.getInt("extraDay"),
                                set.getInt("extraMoney"),
                                set.getInt("totalPrice"),
                                set.getString("returnDate")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return receivedList;
    }

    public boolean updateCarForReturnCar(Received received){
        boolean condition=false;
        String query="UPDATE car_received SET returnDate=?,extraDay=?,extraMoney=?,totalPrice=? where returnID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,received.getReturnDate());
            ps.setInt(2,received.getExtraDay());
            ps.setInt(3,received.getExtraMoney());
            ps.setInt(4,received.getTotalPrice());
            ps.setInt(5,received.getReturnID());

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
