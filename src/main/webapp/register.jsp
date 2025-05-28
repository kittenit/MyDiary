

<%@ page contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="music/music.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<form method='post' action='user'>
    
    <form method='post' action='user'>
    <input type='hidden' name='action' value='register'>

    <span style="color: #cc3366;"> ユーザー名:</span>
    <img src="images/踊り猫.gif" alt="Start" style="height: 100px; vertical-align: middle; margin-right: 8px;"> 
     <input type='text' name='username'><br>
    
     <span style="color: #cc3366;">パスワード:</span>
     <input type='password' name='password'><br>

    <button type='submit'>登録</button>
</form>


<%
    String error = request.getParameter("error");
    if ("1".equals(error)) {
%>
    <p style="color: red;">登録に失敗しました。</p>
    
<%
    }
%>
<a href='login.jsp'>ログイン</a>

<%@ include file="common/footer.jsp" %>