<%@ page import="com.yun.board.domain.ProductOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-12"> 
	<div class="panel panel-default">


		<div class="panel-body">
		<table class="table table-condensed" style="border-collapse: collapse;">

                <thead>
                    <tr id="th-pay">
                        <th width="5%">No.</th>
                        <th width="10%">사진</th>
                        <th width="40%">상품명</th> 
                        <th width="15%">판매자</th>
                        <th width="20%">결제정보</th>
                        <th width="15%">상태</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${polist}" var="p" varStatus="i">

                        <tr id="tb-pay">
                            <td>${i.count}</td>
                            <td><a href="../product/detail?no=${p.no}"><img src="${p.product.phot}" width="130px" height="100px"/></a></td>
                            <td><a href="../product/detail?no=${p.no}">${p.product.titl}</a></td>
                            <td>${p.sellernick}</td>
                            <td><fmt:formatNumber value="${p.tot_pric}" pattern="#,###" />[${p.cnt}개]<br>${p.payopt}<br>${p.paydt}</td>
                            <td>
                            <span id="productState" name="${p.parc_no}"></span>
                                <button type="button" class="btn btn-primary"
                                    onclick="searchparc()" style="margin-top:5px">배송조회</button>
                                    
                                    <script>
                                    function searchparc(){
                                        swal("배송조회", "배송업체 : ${p.parc_name }\n송장번호 : ${p.parc_no}");
                                        }
                                    </script>
                                    
                            </td>
                            </tr>

                    </c:forEach>

                </tbody>
                
            </table>

		</div>

	</div>

	<!-- Paging 처리 -->
	<div id="paging">
		<!--        ${pageCode}-->
	</div>

</div>


<!-- page navigation -->
<nav aria-label="Page navigation" class="pn-center">
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="#"
			aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
				class="sr-only">Previous</span>
		</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#"
			aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
				class="sr-only">Next</span>
		</a></li>
	</ul>
</nav>



<script>


$(document).ready(function() {
    
    var judge = $('#productState').attr('name')
    
    if(judge == null){
        
        $('#productState').text('결제완료')
    }
   
    else if(judge != null){
        
    $('#productState').text('배송중')
        
    }
    
});

</script>
