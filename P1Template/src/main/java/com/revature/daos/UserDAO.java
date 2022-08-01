package com.revature.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class UserDAO implements UserDaoInterface {

	public static String url = "jdbc:postgresql://bootcampone.c7pvo8uwp5jq.us-east-2.rds.amazonaws.com/postgres";
    public static String username = "postgres";
    public static String confirmation = "password";

    public static void main(String[] args){
        UserDAO n = new UserDAO();
        Reimbursement x = new Reimbursement(1, 21.00, 1,1,1);
        Employee f = n.find("user1", "1234");

    }

    public static int getId(String user){
        int id=-1;

        try (Connection conn = DriverManager.getConnection(url, username, confirmation)) {

            String sql = "SELECT ers_users_id FROM ers_users WHERE ers_username =?";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user);


            ResultSet rs = ps.executeQuery(); // executeQUERY not executeUpdate

            if (rs.next()) {
               id = rs.getInt("ers_users_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> results = new ArrayList<>();
        Employee temp = null;

        try (Connection conn = DriverManager.getConnection(url, username, confirmation)) {

            String sql = "SELECT * FROM ers_users";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            ResultSet rs = ps.executeQuery(); // executeQUERY not executeUpdate


            while(rs.next()){
                temp = new Employee(
                        rs.getInt("ers_users_id"),
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_email"),
                        rs.getInt("user_role_id")
                );
                results.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;

    }

    @Override
    public Map<Employee, Reimbursement> get() {
        return null;
    }


    public static Employee find(String user, String password) {
        Employee account = null;
        try (Connection conn = DriverManager.getConnection(url, username, confirmation)) {

            String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery(); // executeQUERY not executeUpdate

            if (rs.next()) {
                account = new Employee(
                        rs.getInt("ers_users_id"),
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_email"),
                        rs.getInt("user_role_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
