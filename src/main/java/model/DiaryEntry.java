package model;

import java.sql.Date;

public class DiaryEntry {
    private int id;
    private int userId;
    private Date date;
    private String content;
    public DiaryEntry() {}
    public DiaryEntry(int userId, Date date, String content) {
        this.userId = userId;
        this.date = date;
        this.content = content;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
