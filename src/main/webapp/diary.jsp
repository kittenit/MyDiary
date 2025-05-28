<%@ page contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<%@ include file="music/music.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="model.DiaryEntry" %>
<%@ page import="model.User" %>
<%
User user = (User) session.getAttribute("user");
if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}
List<DiaryEntry> entries = (List<DiaryEntry>) request.getAttribute("entries");
%>

<h2>
    <img src="images/つばさ.gif" alt="Start" style="height: 50px; vertical-align: middle; margin-right: 8px;">
    <%= user.getUsername() %>のダイアリー
    <img src="images/翼.gif" alt="End" style="height: 50px; vertical-align: middle; margin-left: 8px;">
</h2>

<form method='post' action='diary'>
    <textarea name='content' rows='5' cols='40'></textarea><br>
    <button type='submit'>作成</button>
</form>
<h3>
記録
</h3>
<% for (DiaryEntry entry : entries) { %>
    <p><%= entry.getDate() %><br>
    <%= entry.getContent() %><br>
    <a href='edit?id=<%= entry.getId() %>'>修正</a>
    <a href='delete?id=<%= entry.getId() %>'>削除</a></p>
<% } %>
<a href='user'>ログアウト</a>

<%@ include file="common/footer.jsp" %>
