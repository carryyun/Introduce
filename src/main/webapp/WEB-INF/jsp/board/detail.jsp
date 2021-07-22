<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>write</title>
	
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body>
<h1>
	조회
</h1>
    <label>제목</label><br/>
    <span><c:out value="${item.title}"></c:out> </span><br/>
    <label>내용</label><br/>
    <%
    pageContext.setAttribute("wn", "\n");
    pageContext.setAttribute("br", "<br/>");
    %>
    <span>${fn:replace(item.content, wn, br)}</span><br/>
    <button onclick="edit()">수정</button>
    <button onclick="main()">글목록</button>

<script type="text/javascript">
function edit(){
	$("div.sideRight").load("/app/board/edit?bno="+ ${item.bno} );
}
function main(){
    $("div.sideRight").load("/app/board/main");
}
</script>

</body>
</html>
