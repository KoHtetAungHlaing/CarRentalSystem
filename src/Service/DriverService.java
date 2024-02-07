package Service;

import Helper.DBHelper;
import Model.Driver;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverService {
    public List<Driver> getAllDriver() {
        List<Driver> driverList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT * FROM driver";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while (set.next()) {
                driverList.add(
                        new Driver(
                                set.getInt("dID"),
                                set.getInt("phone"),
                                set.getString("name"),
                                set.getString("nrc"),
                                set.getString("address"),
                                set.getBoolean("available")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return driverList;
    }

    public Driver getDriverByName(String name) {
        Driver driver = null;
        String query = "SELECT * FROM driver where name=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            set = ps.executeQuery();
            while (set.next()) {
                driver = new Driver(
                        set.getInt("dID"),
                        set.getInt("phone"),
                        set.getString("name"),
                        set.getString("nrc"),
                        set.getString("address"),
                        set.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return driver;
    }

    public Driver getDriverByID(int id) {
        Driver driver = null;
        String query = "SELECT * FROM driver where dID=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            set = ps.executeQuery();
            while (set.next()) {
                driver = new Driver(
                        set.getInt("dID"),
                        set.getInt("phone"),
                        set.getString("name"),
                        set.getString("nrc"),
                        set.getString("address"),
                        set.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return driver;
    }

    public boolean updateDriverForAvailable(Driver driver){
        boolean condition=false;
        String query="UPDATE driver SET name=?,nrc=?,phone=?,address=?,available=? where dID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,driver.getName());
            ps.setString(2,driver.getNrc());
            ps.setInt(3,driver.getPhone());
            ps.setString(4,driver.getAddress());
            ps.setBoolean(5,driver.isAvailable());
            ps.setInt(6,driver.getId());

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

    public boolean deleteDriver(int id){
        boolean condition=false;
        String query="DELETE FROM driver where dID=?";
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

    public boolean updateDriver(Driver driver){
        boolean condition=false;
        String query="UPDATE driver SET name=?,nrc=?,phone=?,address=?,available=? where dID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,driver.getName());
            ps.setString(2,driver.getNrc());
            ps.setInt(3,driver.getPhone());
            ps.setString(4,driver.getAddress());
            ps.setBoolean(5,driver.isAvailable());
            ps.setInt(6,driver.getId());

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

    public boolean saveDriver(Driver driver) {
        boolean condition = false;
        String query = "INSERT INTO driver (name,nrc,phone,address,available) VALUES (?,?,?,?,?)";
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getNrc());
            ps.setInt(3, driver.getPhone());
            ps.setString(4, driver.getAddress());
            ps.setBoolean(5, driver.isAvailable());

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
}
