<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>write</title>
	
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style type="text/css">
    input#title{
        width: 380px;
    }
</style>
</head>
<body>
<h1>
	글수정
</h1>
    <label>제목</label><br/>
    <input type="text" name="title" id="title" value="<c:out value="${item.title}"></c:out>"/><br/>
    <label>내용</label><br/>
    <textarea name="content" id="content" cols="50" rows="5" ><c:out value="${item.content}"></c:out> </textarea><br/>
    <button onclick="send()">수정</button>
    <button onclick="main()">글목록</button>

<script type="text/javascript">

$(function (){
	
});
function send(){
	let getBno=${item.bno};
	$.ajax({
		url:"/board/update.do",
		type:"POST",
		data:{
			bno:getBno,
			title:$("#title").val(),
			content:$("#content").val()
			},
		success: function(result){
			$("div.sideRight").load("/board/main");
		},
		error: function(result){
			console.log("에러");
		}
	})
}
function main(){
	$("div.sideRight").load("/board/main");
}
</script>

</body>
</html>
