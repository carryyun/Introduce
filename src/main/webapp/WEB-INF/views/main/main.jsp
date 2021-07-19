<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Yun gunhee</title>
    <link rel="stylesheet" href="/resources/css/mainCSS.css">
</head>
<body>

<div class="wrap">
    <div class="sideLeft">
        <span class="sideTitle" onclick="location.href='/main/main'">PORT</span><br/>
        <span class="sideTitle" onclick="location.href='/main/main'">FOLIO</span><br/>
        
        <div class="circle">
            <img class="circleImg" src="/resources/img/me.png" alt="/resources/img/me.png"/>
        </div>
        <ul>
            <li onclick="callPage('/main/introduce')"><span>소개</span></li>
            <li onclick="callPage('/board/main')"><span>게시판</span></li>
            <li><span>Haru</span></li>
            <li><span>가드</span></li>
            
        </ul>
    </div>
    <div class="sideRight">
        
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(function(){
	$(".sideRight").load("/main/introduce");
});

function callPage(url){
	$(".sideRight").load(url);
}
</script>
</body>
</html>
