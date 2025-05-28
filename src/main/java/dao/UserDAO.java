package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO{
    private String url = "jdbc:postgresql://localhost:5432/testdb";
    private String user = "testuser";        
    private String password = "testpass";     // パスワード
    private static final String driverName = "org.postgresql.Driver"; // PostgreSQL Driver name

    public boolean register(String username, String password) {
    	System.out.println("conn");
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try{
        	Class.forName(driverName);
        	Connection conn = DriverManager.getConnection(url, user, this.password);
        	System.out.println(conn);
    		PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace(); //エラーコンソールに残る
            return false;
        }
    }

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try {
        	Class.forName(driverName);
        	Connection conn = DriverManager.getConnection(url, user, this.password);
    		PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	System.out.println("ログイン成功");
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(username);
                return u;
            }else {
            	System.out.println("ログイン失敗");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}