package Service;

import Helper.DBHelper;
import Model.Car;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarService {
//        public List<Car> getAllCar() {
//        List<Car> carList = new ArrayList<>();
//        Connection conn = DBHelper.getConn();
//        String query = "SELECT * FROM car";
//        PreparedStatement ps = null;
//        ResultSet set = null;
//        try {
//            ps = conn.prepareStatement(query);
//            set = ps.executeQuery();
//            while (set.next()) {
//                carList.add(
//                        new Car(
//                                set.getInt("cID"),
//                                set.getInt("seat"),
//                                set.getInt("price"),
//                                set.getString("regNo"),
//                                set.getString("model"),
//                                set.getBoolean("available")
//                        )
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//            DBHelper.closeConn(conn, ps, set);
//        return carList;
//    }

    public List<Car> getCarRegNo() {
        List<Car> carList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT * FROM car";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while (set.next()) {
                carList.add(
                        new Car(
                                set.getInt("cID"),
                                set.getInt("seat"),
                                set.getInt("price"),
                                set.getString("regNo"),
                                set.getString("model"),
                                set.getBoolean("available")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return carList;
    }

    public Car getCarByRegNo(String regNo) {
        Car car = null;
        String query = "SELECT * FROM car where regNo=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1,regNo);
            set = ps.executeQuery();
            while (set.next()) {
                car = new Car(
                        set.getInt("cID"),
                        set.getInt("seat"),
                        set.getInt("price"),
                        set.getString("regNo"),
                        set.getString("model"),
                        set.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return car;
    }

    public Car getCarByID(int id) {
        Car car = null;
        String query = "SELECT * FROM car where cID=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            set = ps.executeQuery();
            while (set.next()) {
                car = new Car(
                        set.getInt("cID"),
                        set.getInt("seat"),
                        set.getInt("price"),
                        set.getString("regNo"),
                        set.getString("model"),
                        set.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return car;
    }

    public boolean updateCarForAvailable(Car car){
        boolean condition=false;
        String query="UPDATE car SET regNo=?,model=?,seat=?,price=?,available=? where cID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,car.getRegNo());
            ps.setString(2,car.getModel());
            ps.setInt(3,car.getSeat());
            ps.setInt(4,car.getPrice());
            ps.setBoolean(5,car.isAvailable());
            ps.setInt(6,car.getId());

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

    public boolean deleteCar(int id){
        boolean condition=false;
        String query="DELETE FROM car where cID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setInt(1,id);
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

    public boolean saveCar(Car car) {
        boolean condition = false;
        String query = "INSERT INTO car (regNo,model,seat,price,available) VALUES (?,?,?,?,?)";
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, car.getRegNo());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getSeat());
            ps.setInt(4, car.getPrice());
            ps.setBoolean(5, car.isAvailable());

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

    public boolean updateCar(Car car){
        boolean condition=false;
        String query="UPDATE car SET regNo=?,model=?,seat=?,price=?,available=? where cID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,car.getRegNo());
            ps.setString(2,car.getModel());
            ps.setInt(3,car.getSeat());
            ps.setInt(4,car.getPrice());
            ps.setBoolean(5,car.isAvailable());
            ps.setInt(6,car.getId());

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



