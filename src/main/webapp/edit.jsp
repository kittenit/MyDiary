<%@ page contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<%@ include file="music/music.jsp" %>
<%@ page import="model.DiaryEntry" %>
<%
DiaryEntry entry = (DiaryEntry) request.getAttribute("entry");
%>
<h2>
<img src="images/つばさ.gif" alt="Start" style="height: 50px; vertical-align: middle; margin-right: 8px;">
修正
<img src="images/翼.gif" alt="End" style="height: 50px; vertical-align: middle; margin-left: 8px;">

</h2>

<form method='post' action='diary'>
    <input type='hidden' name='id' value='<%= entry.getId() %>'>
    
    <textarea name='content'><%= entry.getContent() %></textarea><br>
    
    <button type='submit'>修正</button>
</form>


<a href='diary'>戻る</a>

<%@ include file="common/footer.jsp" %>