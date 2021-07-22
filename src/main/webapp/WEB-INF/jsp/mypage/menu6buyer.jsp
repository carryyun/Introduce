<%@ page import="com.yun.board.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	.view{
		width: 30%;
		text-align: center;
		background-color:#2c98f0;
		margin-bottom:1px;
		color:#fff;
		border:1px solid #2c98f0;
	}
	#submitdelbtn{
		float:right;
	}
	#delivery{
		width: 30%;
		height: 30px;
		margin-bottom: 3px;
	}
	#delnum{
		width: 100%;
		margin-bottom: 5px;
	}
	#delnum::-webkit-inner-spin-button,
    #delnum::-webkit-outer-spin-button {
        -webkit-appearance: none;             
        margin: 0;         
    } 
    
</style>

<div class="col-lg-12"> 
	<div class="panel panel-default">
	

    <span id="menu6re" style="dispay:inline; font-size:24px; font-weight:900; color: #80848F;  vertical-align: middle;" >상품 목록</span>&nbsp;<img src="/upload/img/nexticon.png" width="4%">
    <span style="dispay:inline; width:200px; font-size:24px; color : black;  font-weight: 900; vertical-align: middle; ">주문자 목록</span>
 
 
		<div class="panel-body">
		<table class="table table-condensed" style="border-collapse: collapse;">

                <thead>
                    <tr id="th-pay">

                        <th width="5%">No.</th>
                        <th width="25%">결제일자<br>(주문번호)</th>
                        <th width="20%">주문자</th>
                        <th width="35%">결제금액[수량]<br>(결제방법)      </th>
                        <th width="15%">상태</th>

                    </tr>
                </thead>

                <tbody>
                    
                  
                    <c:forEach items="${pmanage2}" var="p" varStatus="i">
                        <tr id="tb-pay">
                            <td>${i.count}</td>
                            <td>${p.productOrder.paydt}<br></td>
                            <td><a data-toggle="modal" data-target="#buyerinfo${p.productOrder.no}" name="${p.productOrder.no}">${p.mentee2.name}</a></td>
                            <td><fmt:formatNumber value="${p.productOrder.tot_pric}" pattern="#,###" />
                            [${p.productOrder.cnt}개]<br>${p.productOrder.payopt}</td>

                            <td>
                                <span> 입금전/입금완료/발송완료 조건</span>
                                <button type="button"   onclick="clickOno(this.name)" name="${p.productOrder.no}" class="btn btn-primary" data-toggle="modal" data-target="#deliveryinfo">배송정보입력</button>
                            </td>
                            </tr>
                            
                          
                            
                    </c:forEach>
                </tbody>
                
            </table>
             <c:forEach items="${pmanage2}" var="p" varStatus="i">
              <div class="modal fade" id="buyerinfo${p.productOrder.no}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                             <table class="table table-condensed" style="border-collapse: collapse;">
                     <tr>
                        <td width="20%">상품명</td>
                        <td>${p.titl}</td>
                     </tr>
                     
                      <tr>
                        <td width="20%">수량</td>
                        <td>${p.productOrder.cnt}</td>
                     </tr>
                     
                      <tr>
                        <td width="20%">결제금액</td>
                        <td>${p.productOrder.tot_pric}</td>
                     </tr>
                     
                     
                      <tr>
                        <td width="20%">연락처</td>
                        <td>${p.mentee2.phone}</td>
                     </tr>
                     
                      <tr>
                        <td width="20%">주소</td>
                        <td>${p.mentee2.pstno}/${p.mentee2.bas_addr}/${p.mentee2.det_addr}</td>
                     </tr>
                                </tbody>
                             
                             </table>
                        </div>
                    </div>
                                                
                </div>
                                               
            
            </div>
              </c:forEach>
             		<div class="modal fade" id="deliveryinfo" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                          <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="repdelet">배송 정보입력</h4>
                                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                                </div>
                                                <div class="modal-body">
                                                    <!-- content goes here -->
                                                    <div>
                                                      <input type="text" class="view" readonly value="택배 회사명" ><br>
                                                      <select id="delivery" >
                                                      <option hidden selected></option>
                                                      <option value="우체국택배">우체국택배</option>
                                                      <option value="CJ대한통운">CJ대한통운</option>
                                                      <option value="현대택배">현대택배</option>
                                                      <option value="한진택배">한진택배</option>
                                                      <option value="로젠택배">로젠택배</option>
                                                      <option value="대신택배">대신택배</option>
                                                      <option value="UPS">UPS</option>
                                                      <option value="DHL">DHL</option>
                                                      <option value="경동택배">경동택배</option>
                                                      <option value="KG로지스">KG로지스</option>
                                                      <option value="KGB택배">KGB택배</option>
                                                      <option value="합동택배">합동택배</option>
                                                      <option value="천일택배">천일택배</option>
                                                      <option value="씨브이에스넷">씨브이에스넷</option>
                                                      </select>
                                                    </div>
                                                    <div>
                                                      <input type="text" class="view" readonly value="송장 번호" >
                                                      <input oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
													    type = "number" maxlength = "20" id="delnum"  />
                                                    </div>	
                                                      <button type="button" class="btn btn-primary" data-dismiss="modal"id="submitdelbtn"  role="button">취소</button>
                                                      <button type="button" class="btn btn-primary" id="submitOno" name="" onClick="submitDelivery(this.name)">입력 완료</button>
                                                     
                                                </div>
                                            </div>
                                          </div>
                                        </div>
            
		</div>

	</div>


</div>



<script>

$("#submitdelbtn").click(function(){
  		$("#deliveryinfo")
    .find("#delnum,select")
       .val('')
       .end();
});
    
    

    
function clickOno(ono){
   
    console.log("ono : "+ono);
    
    $('#submitOno').attr('name',ono)
    
    console.log( "setono"+$('#submitOno').attr('name'));
    
}




     
 function submitDelivery(getOno){
		console.log($("#delnum").val().length);
		console.log($("#delivery option:selected").val());
		  
		if($("#delnum").val() == ""){
			swal({
		        text: "송장번호를 적어주세요.",
		        timer:3000,
		        button:"확인"
			});
			return false;
		}else if($("#delivery option:selected").val() == ""){
			swal({
		        text: "택배사를 선택해주세요.",
		        timer:3000,
		        button:"확인"
			});
			return false;
		}else{
	 $.ajax({
		 	type:"POST",
			data : {
				parcname: $("#delivery option:selected").val(),
				parcno	: $("#delnum").val(),
				ono : getOno
			},
			url : "deliveryinsert.do",
			success : function(data){
				if(data>0){
					swal({
				        text: "배송정보가 등록되었습니다.",
				        timer:3000,
				        button:"확인"
					}).then(function() {
						$("#deliveryinfo").hide();
						$(".modal-backdrop.fade.in").hide();
						$("#deliveryinfo")
					    .find("#delnum,select")
					       .val('')
					       .end();
						
			        });
				}else{
					swal({
						 text:"배송정보등록에  실패하였습니다.",
						 timer:3000,
						 button:"확인"
					  });
				}
			}
		});
	}
} 
   

$("#menu6re").click(function(){
 
    $("#menu6buyer").fadeOut(200);
    
    setTimeout(function() {
        $("#menu6").load("/app/mypage/menu6");
        $("#menu6").fadeIn(200);
    }, 200);
   
});


</script>

