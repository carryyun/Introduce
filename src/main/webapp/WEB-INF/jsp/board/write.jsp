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
	글작성
</h1>
    <label>제목</label><br/>
    <input type="text" name="title" id="title"/><br/>
    <label>내용</label><br/>
    <textarea name="content" id="content" cols="50" rows="5"></textarea><br/>
    <button onclick="send()">작성</button>
    <button onclick="main()">글목록</button>

<script type="text/javascript">

$(function (){
	console.log("hi");
});
function send(){
	$.ajax({
		url:"/app/board/write.do",
		type:"POST",
		data:{
			title:$("#title").val(),
			content:$("#content").val()
			},
		success: function(result){
			$("div.sideRight").load("/app/board/main");
		},
		error: function(result){
			console.log("에러");
		}
	})
}
function main(){
	$("div.sideRight").load("/app/board/main");
}
</script>

</body>
</html>
