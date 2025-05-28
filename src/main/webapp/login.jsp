<%@ page contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="music/music.jsp" %>



<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

	<form method='post' action='user'>
    <input type='hidden' name='action' value='login'>
    
    <span style="color: #cc3366;">ユーザー名:</span>
    <img src="images/猫ちゃん.gif" alt="Start" style="height: 100px; vertical-align: middle; margin-right: 8px;"> 
    <input type='text' name='username'><br>
    
    <span style="color: #cc3366;">パスワード: </span>
    <input type='password' name='password'><br>
    
    <button type='submit'>ログイン</button>
	</form>

	
	<%
    String error = request.getParameter("error");
    if ("1".equals(error)) {
%>
    <p style="color: red;">ログインに失敗しました。
    ユーザー名またはパスワードが間違っています。</p>
    
<%
    }
%>
	
<a href='register.jsp'>登録</a>

<%@ include file="common/footer.jsp" %>

