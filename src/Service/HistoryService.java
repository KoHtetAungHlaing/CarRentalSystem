package Service;

import Helper.DBHelper;
import Model.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    public List<History> getAllHistory() {
        List<History> historyList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        String query = "SELECT d.name as Name, Count(a.custID) as Count, SUM(c.totalPrice) as TotalPrice, MIN(a.fromDate) as FromDate, MAX(c.returnDate) as ToDate\n" +
                "FROM rent_table AS a\n" +
                "JOIN driver AS d ON a.dID = d.dID\n" +
                "JOIN car_received AS c ON a.rentID = c.rentID\n" +
                "GROUP BY a.dID\n" +
                "ORDER BY SUM(c.totalPrice) DESC";
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps = conn.prepareStatement(query);
            set = ps.executeQuery();
            while (set.next()) {
                historyList.add(
                        new History(
                                set.getString("name"),
                                set.getString("fromDate"),
                                set.getString("toDate"),
                                set.getInt("count"),
                                set.getInt("totalPrice")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBHelper.closeConn(conn, ps, set);
        return historyList;
    }
}
