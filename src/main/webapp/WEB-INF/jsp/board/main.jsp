<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>board</title>
	<style type="text/css">
	   table.collapse{
	       border-collapse: collapse;
	       width: 100%;
	   }
	   table.collapse th{
	       border-bottom: 2px solid #808080;
	   }
	   table.collapse th:nth-child(1){
	       width: 10%;
	       text-align: center;
	   }
	   table.collapse th:nth-child(2){
           width: 45%;
       }
       table.collapse th:nth-child(3){
           width: 15%;
       }
       table.collapse th:nth-child(4){
           width: 30%;
       }
	   
	   table.collapse tr.postTr{
	       border-bottom: 1px solid rgba(30,30,30,0.2);     
       }
       div.pageWrap{
           display:table;
           margin: 0 auto;
       }
       div.pageNumber{
           display:table-cell;
           cursor: pointer;
           width: 20px;
           height: 20px;
           border: 1px solid #7676ff;
           vertical-align: middle;
           text-align: center;
       }
        
	</style>
</head>
<body>
<h1>
	게시판  
</h1>

<div id="wrap">
    <table class="collapse">
	    <thead>
	       <tr>
	           <th>번호</th>
	           <th>제목</th>
	           <th>작성자</th>
	           <th>게시일</th>
           </tr>
	    </thead>
	    <tbody>
	       <c:forEach items="${list}" var="item" varStatus="i">
	           <tr class="postTr" onclick="detail(${item.bno})" >
		          <td><c:out value="${item.bno}"></c:out></td>
		          <td><c:out value="${item.title}"></c:out></td>
		          <td><c:out value="${item.userVO.name}"></c:out></td>   
		          <fmt:formatDate var="regDate" value="${ item.regDate }" pattern="yy-MM-dd HH:mm:ss" />
		          <td><c:out value="${regDate}"></c:out></td>   
	          </tr>
	       </c:forEach>
	    </tbody>
    </table>
    <div class="pageWrap">
	    <c:forEach items="${pageList}" var="i">
		    <div class="pageNumber" onclick="movePage(${i})">
		        <c:out value="${i}"/>
		    </div>
	    </c:forEach>
    </div>
    <button onclick="$('div.sideRight').load('/app/board/write')">글쓰기</button>
    <!-- <button onclick="location.href='/board/write'">글쓰기</button> -->
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
function detail(bno){
	$("div.sideRight").load("/app/board/detail?bno="+bno);
}
function movePage(pageNo){
    $("div.sideRight").load("/app/board/main?pageNo="+pageNo);
}

</script>
</body>
</html>
