package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DiaryEntry;

public class DiaryDAO {
    private String url = "jdbc:postgresql://localhost:5432/testdb";
    private String user = "testuser";
    private String password = "testpass";

    public void addEntry(int userId, String content) {
        String sql = "INSERT INTO diary (user_id, date, content) VALUES (?, CURRENT_DATE, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, content);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEntry(int id, String content) {
        String sql = "UPDATE diary SET content=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, content);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void deleteEntry(int id) {
	        String sql = "DELETE FROM diary WHERE id=?";
	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	public DiaryEntry getEntryById(int id) {//修正
	    String sql = "SELECT * FROM diary WHERE id=?";
	    try (Connection conn = DriverManager.getConnection(url, user, password);
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            DiaryEntry entry = new DiaryEntry();
	            entry.setId(rs.getInt("id"));
	            entry.setDate(rs.getDate("date"));
	            entry.setContent(rs.getString("content"));
	            return entry;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

    public List<DiaryEntry> getEntriesByUserId(int userId) {
        List<DiaryEntry> list = new ArrayList<>();
        String sql = "SELECT * FROM diary WHERE user_id=? ORDER BY date DESC";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiaryEntry entry = new DiaryEntry();
                entry.setId(rs.getInt("id"));
                entry.setDate(rs.getDate("date"));
                entry.setContent(rs.getString("content"));
                list.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
