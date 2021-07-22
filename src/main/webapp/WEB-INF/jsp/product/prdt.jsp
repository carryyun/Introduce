<%@page import="com.yun.board.domain.Product"%>
<%@page import="com.yun.board.domain.BigTag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>하루 - 전체 상품목록</title>

<!-- ===============필수포함=============== -->
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">

<link href="/css/owl.carousel.css" rel="stylesheet">
<link href="/css/list.css" rel="stylesheet">
<link href="/css/clean-blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
<link href="/css/animateNew.css" rel="stylesheet">

<!-- ===============필수포함=============== -->
<style type="text/css">
ul#RankingUl{
    margin-bottom: 0;
}
ul#RankingUl li:nth-child(odd){
    background-color: #ffffff;
}
ul#RankingUl li:nth-child(even){
    background-color: #f9f9f9; 
}
ul#RankingUl li:hover{
    background-color: #FFB53C;
}

select {
  -webkit-appearance: none;
  -moz-appearance: none;
  -ms-appearance: none;
  appearance: none;
  outline: 0;
  box-shadow: none;
  border: 0 !important;
  background: #e9e9e9;
  background-image: none;
}
select {
  width: 100%;
/*   height: 100%; */
  margin: 0;
  padding: 0 0 0 .5em;
  color: #5f5f5f;
  border: 1px solid #c9c9c9;
  cursor: pointer;
}
.select {
  position: relative;
  display: block;
  width: 100%;
  height: 3em;
  line-height: 3;
  background: #2c3e50;
  overflow: hidden;
  border-radius: .25em;
}
/* Arrow */
.select::after {
  content: '\25BC';
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  padding: 0 1em;
  background: #FFB53C;
  pointer-events: none;
}
/* Transition */
.select:hover::after {
  color: #fff;
}
.select::after {
  -webkit-transition: .25s all ease;
  -o-transition: .25s all ease;
  transition: .25s all ease;
}
</style>
<style>
	.area_hotkeyword.PM_CL_realtimeKeyword_base{
	    font-size: 14px;
		margin-top:10px;
	}
	.area_hotkeyword.PM_CL_realtimeKeyword_base li{
		padding: 0.5rem;
		padding-right: 0;

/* 		margin-top:10px; */
	}
	.area_hotkeyword.PM_CL_realtimeKeyword_base li:hover{ background-color: #FFB53C}
	.area_hotkeyword.PM_CL_realtimeKeyword_base .ah_k{
		color: black;
	}
	.area_hotkeyword.PM_CL_realtimeKeyword_base .ah_r{
		margin-right:2px;
		color: black;
		font-weight:bolder;
	}
	div.loading{
	   background-image: url('/upload/img/loading2.gif');
	   z-index: 500000;
	   opacity: 0.6;
	   background-repeat: no-repeat;
	   background-size: 100%;
	   position:fixed;
	   z-index:15912591;
	   width:100%;
	   height:100%;
	}
</style>
</head>
<body>
<div class="" id="loadingDiv">
</div>
	<div id="wrap" style="background-color: #fff">
		<div class="col-lg-12 px-0"
            style="position: absolute; height: 147px; background-color: white">
            <!-- 헤더 배경색 적용 -->
        </div>
        <div class="col-lg-12 px-0" 
            style="position: absolute; top:147px; height: 387px; background-color: #f3f3f3">
            <!-- 헤더 배경색 적용 -->
        </div>

		<div class="container" style="background-color: white; margin-bottom: 80px">
			<!-- Header (스크립트로 임시 inclue) -->
			<div class="row">
				<div class="col-lg-12" >
					<jsp:include page="../headerMain.jsp"></jsp:include>
				</div>

				<!-- 카테고리 nav -->
				<div class="col-lg-12">
					<jsp:include page="../headerNav.jsp"></jsp:include>
				</div>

				<!-- Main Content -->
				<div class="container col-lg-12 my-3" style="background-color: #white">
					<div class="row">
						<!-- 오늘의 핫 아이템(카르셀) -->
						<div class="col-lg-9">
							<div class="row">
								<div class="col" style="border-right: 1px solid rgb(217, 217, 217);">
									<h2 style="font-size: 1.5rem; font-weight: 700;">오늘의 핫 아이템</h2>
									<hr color="#FFB53C" style="height:4px;margin-top:10px;margin-bottom:15px"/>
									<div id="owl-hotItem" class="owl-carousel col-lg-10 mt-2" style="margin: 0 auto"></div>
									<div class="owl-btns">
										<div class="cusnextPrdt">
											<i class="fas fa-angle-right" style="color: rgb(217, 217, 217)"></i>
										</div>
										<div class="cusprevPrdt">
											<i class="fas fa-angle-left" style="color: rgb(217, 217, 217)"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 text-left">
						<h2 style="font-size: 1.5rem; font-weight: 700;">상품 검색</h2>
						<hr color="#FFB53C" style=" height:4px;margin-top:10px;margin-bottom:15px"/>
						
						  <input type="text" id="serchconts" style="height:40px; width:98%; border: 4px solid #FFB53C;" onkeypress="if(event.keyCode==13) {serchProduct();}"> 
						  <button onclick="serchProduct()" style="border:none; background: none;"><i style="position:relative;margin-left:-50px ;font-size: 20px;" class="fas fa-search"></i></button>
							<div>
							<div class="area_hotkeyword PM_CL_realtimeKeyword_base">
							<div class="ah_roll PM_CL_realtimeKeyword_rolling_base" aria-hidden="false">
							<h3 class="blind" style="font-size: 1.5rem; font-weight: 700;">인기 주문 목록</h3>
							<div class="ah_roll_area PM_CL_realtimeKeyword_rolling"> 
							<ul class="ah_l" id="RankingUl">
							<c:forEach items="${hotItemlist}" var="h" varStatus="o">
							<li class="ah_item">
							<a href="detail?no=${h.no}" target="_blank" class="ah_a" data-clk="lve.keyword" >
							<c:choose>
                                    <c:when test="${o.count == 1 }">
                                        <img style="width: 18px; height: 24px; margin-right: 9px" alt="/upload/img/Goldmedal.png" src="/upload/img/Goldmedal.png">
                                    </c:when>
                                    <c:when test="${o.count == 2 }">
                                        <img style="width: 18px; height: 24px; margin-right: 9px" alt="/upload/img/Silvermedal.png" src="/upload/img/Silvermedal.png">
                                    </c:when>
                                    <c:when test="${o.count == 3 }">
                                        <img style="width: 18px; height: 24px; margin-right: 9px" alt="/upload/img/Bronzemedal.png" src="/upload/img/Bronzemedal.png">
                                    </c:when>
                                    
                                    <c:otherwise> 
                                        <span class="ah_r" style="margin-left: 5px;margin-right: 15px;">${o.count}</span>
                                    </c:otherwise>
                            </c:choose>
                            
							<c:choose>
								<c:when test="${fn:length(h.titl) > 17}">
					              <span class="ah_k">${fn:substring(h.titl,0,17)}...</span>
					            </c:when>
					            <c:otherwise>
					              <span class="ah_k">${h.titl}</span>
					            </c:otherwise> 
							</c:choose>
							</a>
							</li>
							</c:forEach>
							</ul>
							</div>
							</div>
							</div>	
						</div>
						
						

						<hr class="FhrMargin" style="background:none ;">
					</div>

					<div class="col-lg-12 mx-auto my-3">
						<div class="post-preview">
							<a href="post.html"></a>
							<div class="row">

								<div class="container">
									<div class="col-lg-12 px-0 text-right">
										<a class="btn btn-primary mb-3" id="certBtn"
											data-toggle="modal" href="#"
											onclick="checkSession('${sessionScope.loginUser.no}',event)">상품 등록
										</a>
									</div>
									<div class="row" id="prdtlist">

										<c:forEach items="${productList}" var="pl" varStatus="i">

											<div class="col-lg-4">
												<article class="card-wrapper">
													<div class="image-holder">
														<a href="#" onclick="openInNewTab('detail?no=${pl.no}')" class="image-holder__link"></a>
														<div class="image-liquid image-holder--original">
															<a href="#" onclick="openInNewTab('detail?no=${pl.no}');" ><img alt="${i.count}" src="${pl.phot}"
																style="width: 100%; height: 100%"></a> <img src="${pl.mentee.phot}"
																class="mentorimg" alt="${pl.mentee.phot}">
															<div style="padding: 0 5px; top: 75px; width: auto; height: auto; position: absolute; background-color: #f58500; color: white; border-bottom-right-radius: 10px">${pl.mentee.name}
															</div>
															<div style="padding: 0 5px; top: 100px; width: auto; height: auto; position: absolute; background-color: #333873; color: white; border-bottom-right-radius: 10px">${pl.mentee.nick}
															</div>
														</div>
													</div>
													<div class="product-description">
														<!-- 제목 -->

														<div class="product-description__title">
															<div class="row">
																<div class="col-lg-12 mb-2">
																<c:choose>
																	<c:when test="${fn:length(pl.titl) > 20}">
																	   <a href="#" onclick="openInNewTab('detail?no=${pl.no}')">${fn:substring(pl.titl,0,20)}...</a>
														            </c:when>
														            <c:otherwise>
														              <a href="#" onclick="openInNewTab('detail?no=${pl.no}')">${pl.titl}</a>
														            </c:otherwise> 
																</c:choose>
																</div>
															</div>

															<!-- 분류명 , 가격 -->
															<div class="row">
																<div class="col-lg-7 product-description__category secondary-text">
																	<%
                                                                      Product p = (Product) pageContext.getAttribute("pl");
                                                                      for (int i = 0; i < 5; i++) {
                                                                        if (i < p.getStar()) {
                                                                    %>
                                                                    <img alt="star-on-big" class='starimg' src="/upload/img/raty/star-on-big.png">
                                                                    <%
                                                                      } else {
                                                                    %>
                                                                    <img alt="star-off-big" class='starimg' src="/upload/img/raty/star-off-big.png">
                                                                    <%
                                                                      }
                                                                      }
                                                                    %>
																</div>
																<div class="col-lg-5 product-description__price"><fmt:formatNumber value="${pl.pric}" groupingUsed="true"/>원</div>
															</div>
															<hr class="NoMarginHr">
															<!-- 멘토 이름 -->
															<div class="sizes-wrapper">
																<b>판매자 - ${pl.mentee.name}</b>
															</div>
														</div>
													</div>
												</article>
											</div>

										</c:forEach>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		

		<div class="modal fade" id="squarespaceModal" tabindex="-1"
			role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="lineModalLabel">인증서 선택하기</h4>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						</button>
					</div>
					<div class="modal-body" id="modal-body"></div>
				</div>
			</div>
		</div>
		
		<!-- <select>
		  <option onselect="">
		</select> -->
		
	</div>
</div>
		<footer>
			<div class="col px-0">
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
		</footer>
</div>

	<!-- ===============필수포함=============== -->
	<!-- Bootstrap core JavaScript -->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- js 추가 -->
	<script src="/js/clean-blog.js"></script>
	<script src="/js/owl.carousel.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!-- ===============필수포함=============== -->

	<script>
        var owlPrdt = $("#owl-hotItem");
        $(document).ready(function() {
            
            var data = {
                "items": ${pp_list}
            };
            console.log(data);
            owlPrdt.owlCarousel({
                nav: false,
                loop: true,
                items: 3,
                margin: 10,
                jsonPath: 'json/customData.json',
                jsonSuccess: customDataSuccess(data),
                dots: false

            });

            function customDataSuccess(data) {
                var content = "";
                var style =
                    "cursor:pointer;" +
                    "background-color:weat;" +
                    "text-align:center;"
                for (var i in data["items"]) {
                    var ptno = data["items"][i].product.no;
                    var phot = data["items"][i].product.phot;
                    var titl = data["items"][i].product.titl;
                    var star = data["items"][i].product.star;
                    var pric = data["items"][i].product.pric;
                    var mtname = data["items"][i].middleTagName;
                    var stname = data["items"][i].smallTagName;
                    var nick = data["items"][i].nick;
                    
                    content += "<a href='detail?no="+ ptno +"'>"
                    content += "<div class='col' id='owl-col'>" 
                    content += "<div class='row' id='owl-row'>"
                    content += '<div class="imgcover col-lg-12" style="height: 200px;position:absolute;">'
                    content += '</div>'
                    content += '<div style="padding: 0 5px; top: 20px; width: auto; height: auto; position: absolute; background-color: #f58500; color: white; border-bottom-right-radius: 10px">'+nick+'</div>'
                    content += "<img id='owl-img' src=\"" + phot + "\" alt=\"" + titl + "\">"
                    if(titl.length>21){
                        content += "<div class='col-lg-9' id='owl-col2'>" + titl.substring(0,21) + "...</div>"
                    }else{
                        content += "<div class='col-lg-9' id='owl-col2'>" + titl + "</div>" 
                    }
                    content += "<div class='col-lg-3' id='owl-coltag'>" + stname + "</div>"
                    content += "<div class='col-lg-6' id='owl-colstar'>"
                    for(var j=0; j<5; j++) {
                        if(j<star){
                            content += "<img id='owl-star' width='15px' height='15px' src='/upload/img/raty/star-on.png' alt='star-on'>"
                        }else{
                            content += "<img id='owl-star' width='15px' height='15px' src='/upload/img/raty/star-off.png' alt='star-off'>"
                        }
                    }
                    content += "</div>"
                    pric = "" + pric;
                    pric = pric.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,')
                    content += "<div class='col-lg-6' id='owl-col3'>" + pric + "원</div>"
                    content += "</div>"
                    content += "</div>"
                    content += "</a>"
                }
                owlPrdt.html(content);
            }

        });
        $(".cusnextPrdt").click(function() {
            owlPrdt.trigger('next.owl.carousel');
        });

        $(".cusprevPrdt").click(function() {
            owlPrdt.trigger('prev.owl.carousel');
        });
    </script>
    
	<script>
	function getCtno(){
	    $('#ctno').val($('#cert option:selected').attr('id'));
	}
	function checkSession(no,e){
	    if('${sessionScope.loginUser}' == ''){
	        e.preventDefault();
	        e.stopPropagation();
	        swal({
                text : "로그인 후 이용가능합니다..",
                button : "확인",
              });
            return false;
	    }else{
	        showCert(no,e);
	    }
	    
	}
    function showCert(no,e){
        $.ajax({
            data : {
                no : no
            },
            url : "getCertList.do",
            success : function(data) {
                if(data.length<1){
                    e.preventDefault();
                    e.stopPropagation();
                    swal({
                        text : "발급받은 인증서가 없습니다. 클래스 수료 후 이용해주세요.",
                        button : "확인",
                      });
                    console.log(data.length);
                    return false;
                }else{
                    $('#certBtn').attr('data-target','#squarespaceModal');
                    $('#squarespaceModal').modal();
                }
                
                var html= "";
                
                html+='<form action="prodRegister" method="post">';
                html+='<div class="form-group text-center">';
                html+='<div class="select">';
                html+='<select name="mtno" id="cert" onclick="getCtno()" >';
                for(var i=0;i<data.length; i++){
                    html+='<option id="'+ data[i].no +'" value="'+data[i].classes.mtno+'">'+data[i].classes.titl+'</option>';
                }
                html+='</select>';
                html+='</div>';
                html+='<input type="hidden" name="ctno" id="ctno" value=""';
                html+='</div><br>';
                html+='<div class="text-center" style="margin-top:10px">'

                html+='<button type="button" onclick="openPopUp(this.form)" class="btn btn-primary" style="background-color:#FFB53C !important;border:none;margin:5px">등록</button>';

                html+='<button type="button" class="btn btn-primary" style="background-color:#c9c9c9 !important;border:none;margin:5px" data-dismiss="modal" role="button">취소</button>';
                html+='</div>';
                html+=' </form>';
                var setDiv = document.querySelector("#modal-body");
                setDiv.innerHTML=html;
                $('#ctno').val($('#cert option:selected').attr('id'));
            }
        });
        
    }
    function openPopUp(frm){
     
        $('#squarespaceModal').modal('toggle');
        var openWin;
        
        var url    = "prodRegister";
        var title  = "하루 - 상품등록";
        var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=1300, height=750, top=-1000,left=100"; 
        openWin = window.open("", title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
                                                  //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
                                                  //가능합니다.
        frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
        frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
        frm.method = "post";
        frm.submit();  
        
        }

    </script>
<script>
function serchProduct(){
    var conts = $('input#serchconts').val();
    location.href='prdtSerch?titl='+conts;
}

function openInNewTab(url) {
    var win = window.open(url, '_blank');
    win.focus();
  }
</script>

<script>
var prdtlist = $('div#prdtlist'); 
var pageNo=parseInt(2);

$(window).scroll(function() {
//     console.log($(window).scrollTop());
//     console.log($(document).height()-window.innerHeight);
    if($(window).scrollTop() == $(document).height() - window.innerHeight) {
//         console.log("$(window).scrollTop()=" + $(window).scrollTop());
//         console.log("else = " + ($(document).height() - window.innerHeight+17));
        var html = "";
        $.ajax({
            type : "POST" , 
            data : {
                "pageNo" : pageNo
            },
            url : "prdt.do" ,
            /* 
                ajax 로딩처리
                beforeSend : function(){
                $('div#loadingDiv').addClass('loading');
                setTimeout(function() {
                 }, 2000);
            },
            complete:function(){
                $('div#loadingDiv').removeClass('loading');
            }, */
            success : function(data) {
                for(var j=0; j<6;j++){
                    $('div#animateTarget'+j).removeClass('animated fadeInUp');
                    $('div#animateTarget'+j).removeAttr('id')
                }
                html ="";
                for (var i in data) {
                    var ptno = data[i].no;
                    var titl = data[i].titl; 
                    var pric = data[i].pric;
                    var basAddr = data[i].basAddr;
                    var prdtphot = data[i].phot;
                    var star = data[i].star;
                    var name = data[i].mentee.name;
                    var nick = data[i].mentee.nick;
                    var phot = data[i].mentee.phot;
                    
                    
                    html+= '<div class="col-lg-4 animated fadeInUp" id="animateTarget'+i+'">'
                        html+= '    <article class="card-wrapper">'
                        html+= '        <div class="image-holder" onClick="openInNewTab(\'detail?no='+ptno+'\')">'
                        html+= '            <a href="detail?no='+ptno+'" class="image-holder__-link"></a>'
                        html+= '            <div class="image-liquid image-holder--original">'
                        html+= '<a href="#" onclick="openInNewTab(\'detail?no='+ ptno +'  \');">'
                        html+= '    <img alt="'+ i +'" src="'+ prdtphot +'" style="width: 100%; height: 100%">'
 
                        html+= '</a>'
                        html+= '<img src="'+phot+'"'
                        html+= '                    class="mentorimg" alt="'+phot+'">'
                        html+= '                <div '
                        html+= '                style="padding: 0 5px; top: 75px; width: auto; height: auto; position: absolute; background-color: #f58500; color: white; border-bottom-right-radius: 10px">'+name+''
                        html+= '                </div>'
                        html+= '                <div'
                        html+= '                    style="padding: 0 5px; top: 100px; width: auto; height: auto; position: absolute; background-color: #333873; color: white; border-bottom-right-radius: 10px">'+nick+''
                        html+= '                    멘토</div>'
                        html+= '            </div>'
                        html+= '        </div>'
                        html+= '        <div class="product-description">'
                        html+= '            <div class="product-description__title">'
                        html+= '                <div class="row">'
                        html+= '                    <div class="col-lg-12 mb-2">'
                        if(titl.length<30){
                            html+= '                        <a href="detail?no='+ptno+'">'+titl+'</a>'
                        }else{
                            html+= '                      <a href="detail?no='+ptno+'">'+titl.substring(0,30)+'...</a>'
                        }
                        html+= '                    </div>'
                        html+= '                </div>'
                        html+= '                <div class="row">'
                        html+= '                    <div class="col-lg-7 product-description__category secondary-text">'
                                                            for(var j=0; j<5; j++) {
                                                            if (j<star) {
                        html+= '                        <img alt="star-on-big" class="starimg" src="/upload/img/raty/star-on-big.png">'
                                                          } else {
                        html+= '                        <img alt="star-off-big" class="starimg" src="/upload/img/raty/star-off-big.png">'
                                                          }
                                                      }
                        html+= '                    </div>'
                        pric = "" + pric;
                        pric = pric.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,')
                        html+= '                    <div class="col-lg-5 product-description__price">'+pric+'원</div>'
                        html+= '                </div>'
                        html+= '                <hr class="NoMarginHr">'
                        html+= '                <div class="sizes-wrapper">'
                        html+= '                    <b>판매자 - '+name+'</b>'
                        html+= '                </div>'
                        html+= '                <div class="color-wrapper">'
                        html+= '                    <b>기본 주소 - '+basAddr+'</b>'
                        html+= '                </div>'
                        html+= '            </div>'
                        html+= '        </div>'
                        html+= '    </article>'
                        html+= '</div>'
                }
                var setDiv = document.querySelector("div#prdtlist");
                setDiv.innerHTML+=html;
                
            },error : function(error,status){
                swal({
                    text : "안됨",
                    button : "확인",
                  })
            }
        }).done(function(json) {
            pageNo++;
        });
    }
});

</script>

</body>

</html>