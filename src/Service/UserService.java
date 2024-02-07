package Service;

import Helper.DBHelper;
import Helper.MyDialog;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT * FROM customer";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while (set.next()) {
                userList.add(
                        new User(
                                set.getInt("custID"),
                                set.getInt("phone"),
                                set.getString("name"),
                                set.getString("nrc"),
                                set.getString("email"),
                                set.getString("password"),
                                set.getString("address"),
                                set.getBoolean("renting")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return userList;
    }

    public boolean loginUser(String name, String password) {
        boolean flag = false;

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        String query = "SELECT * FROM customer WHERE name=? AND password=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);

            set = ps.executeQuery();
            if (set.next())
                flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return flag;
    }

    public boolean checkName(String inputName) {
        boolean flag = false;

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        String query = "SELECT * FROM customer";

        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while(set.next()){
                String dbName = set.getString("name");
                if(inputName.equals(dbName )){
                    flag = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return flag;
    }

    public boolean checkNRC(String inputNrc) {
        boolean flag = false;

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        String query = "SELECT * FROM customer";

        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while(set.next()){
                String dbName = set.getString("nrc");
                if(inputNrc.equals(dbName )){
                    flag = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return flag;
    }

    public boolean checkEmail(String inputEmail) {
        boolean flag = false;

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        String query = "SELECT * FROM customer";

        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while(set.next()){
                String dbName = set.getString("email");
                if(inputEmail.equals(dbName)){
                    flag = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return flag;
    }

    public Integer getIdByName(String name) {
        int id = 0;
        Connection conn = DBHelper.getConn();
        String query = "SELECT custID FROM customer where name=?";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);

            set = ps.executeQuery();
            if (set.next())
                id = set.getInt("custID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return id;
    }

    public User getUserByID(int id) {
        User user = null;
        String query = "SELECT * FROM customer where custID=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            set = ps.executeQuery();
            while (set.next()) {
                user = new User(
                        set.getInt("custID"),
                        set.getInt("phone"),
                        set.getString("name"),
                        set.getString("nrc"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("address"),
                        set.getBoolean("renting")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return user;
    }

    public boolean saveUser(User user) {
        boolean condition = false;
        String query = "INSERT INTO customer (name,nrc,email,password,address,phone) VALUES (?,?,?,?,?,?)";
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getNrc());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getPhone());

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

    public boolean updateUser(User user){
        boolean condition=false;
        String query="UPDATE customer SET name=?,nrc=?,email=?,password=?,address=?,phone=? where custID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getNrc());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPassword());
            ps.setString(5,user.getAddress());
            ps.setInt(6,user.getPhone());
            ps.setInt(7,user.getId());

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

    public User getUserByName(String name) {
        User user = null;
        String query = "SELECT * FROM customer where name=?";

        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet set = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            set = ps.executeQuery();
            while (set.next()) {
                user = new User(
                        set.getInt("custID"),
                        set.getInt("phone"),
                        set.getString("name"),
                        set.getString("nrc"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("address"),
                        set.getBoolean("renting")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return user;
    }

    public boolean updateUserForRenting(User user){
        boolean condition=false;
        String query="UPDATE customer SET name=?,nrc=?,email=?,password=?,address=?,phone=?,renting=? where custID=?";
        Connection conn=DBHelper.getConn();
        PreparedStatement ps=null;

        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getNrc());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPassword());
            ps.setString(5,user.getAddress());
            ps.setInt(6,user.getPhone());
            ps.setBoolean(7,user.isRenting());
            ps.setInt(8,user.getId());

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

    public boolean deleteUser(int id){
        boolean condition=false;
        String query="DELETE FROM customer where custID=?";
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
}
