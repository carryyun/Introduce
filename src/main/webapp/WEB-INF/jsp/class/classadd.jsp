<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>클래스 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/classadd.css">
    <link href='/css/common.css' rel='stylesheet' />
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
    
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
    <!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
    
    <!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script> -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
    <link href='/css/fullcalendar.css' rel='stylesheet' />
    <!-- <link href='/css/fullcalendar.min.css' rel='stylesheet' type="text/javascript" /> -->
    <link href='/css/fullcalendar.print.min.css' rel='stylesheet' media='print'/>
    <script src='/js/moment.min.js'></script>
    <script src='/js/fullcalendar.min.js'></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="/js/jquery.datetimepicker.full.min.js"></script>
    <link rel="stylesheet" href="/css/jquery.datetimepicker.min.css" >
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"  type="text/javascript"></script>
    
    <style type="text/css">
    button.note-btn.btn.btn-default.btn-sm{
    	font-size: 12px !important;
    }
    #mainNav .navbar-brand{
    	margin-bottom: 50px !important;
    }
    .modal-backdrop.in{
    	display:none !important;
    }
    </style>
    </head>
    
<body style="background-color:#F2F4F7;">
<div class="container">
<div class="row">
<div class="col" style="position: absolute; height: 105px; background-color: white">
			<!-- 헤더 배경색 적용 -->
		</div>
<div class="col-lg-12" style="z-index: 100">
				 	 
 <div id="classadd">
  <div>
      <h1>클래스 등록</h1>
  </div>
  <!--method="post"  enctype="multipart/form-data"-->
  <form action="classadd" method="post" id="uploadForm" enctype="multipart/form-data">
             <div>
              <input type="text" name="titl" id="ctitl" maxlength="50" placeholder="#제목을 입력해주세요  #Haru #클래스등록">
             </div>
              <div id="classinfo">
               <div style="width: 500px; height: auto; float: right; top:0">
                <div id="type-chk-btn">
                  	<input type="radio" id="contactChoice1" name="typeChk" value="단기" checked="checked">
				    <label for="contactChoice1">단기</label>
				    <input type="radio" id="contactChoice2" name="typeChk" value="장기">
				    <label for="contactChoice2">장기</label>
                </div>
                <div id="calendar"></div>
                <div id="oneday-btn"><input type="text" class="view" readonly value="수업 날짜">
                <input type="button" id="sledel" value="선택삭제" style="float: right;'">
                <select id="daylist" size="5" style="width:500px;"></select>
                </div>
                </div>
                <div style="position:absolute; width: 500px; float:right; top: 0;">
                <div id="tagselcetdiv">
  				<input type="text" class="view" readonly value="대분류 선택">
	                <select id="bigtagSel" style="width:25%; height:26px;">
		                <option hidden selected></option>
	    	      	 	 <c:forEach  items="${BTlist}" var="bt" varStatus="c">
			                <c:if test="${bt.no ne 1}">
			                <option value='${bt.no}'>${bt.name}</option>
		    	            </c:if>
	            		</c:forEach>
                </select>
              	  <input type="text" class="view" readonly value="중분류 선택">	
	                <c:forEach  items="${BTlist}" var="bt" varStatus="c">
				                <c:if test="${bt.no ne 1}">
					                <select id="MiddletagSel${bt.no}" style="width:25%; height:26px; display:none;">
					                	<c:forEach  items="${MTlist}" varStatus="j">
							                <c:if test="${bt.no eq MTlist[j.index].bigTag.no}">
						        	  			<option hidden selected></option>
						          				<option value="${MTlist[j.index].no}">${MTlist[j.index].name}</option>
						    	            </c:if>
							            </c:forEach>
				    	            </select>
			    	            </c:if>
	            	</c:forEach>
                 <select id="MiddletagSelBase" style="width:25%; height:26px;">
                <option hidden selected></option>
                </select> 
   				</div>
               <div id="pay-div">
                <input type="text" class="view" readonly value="시간당 금액" >
                <input type="number" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                name="pric" id="cpay" maxlength="6" placeholder="시간당 수업금액을 입력해주세요.">
               </div> 
               <div id="allday-btn" style="display:none;">
               <input type="text" class="view" readonly value="수업날짜">
               <input type="text" name="date" id="cdate" readonly placeholder="시작날짜">~
               <input type="text" name="edate" id="cdate2" readonly placeholder="종강날짜">
               </div>
               <div id="alldaytime">
                <input type="text" class="view" readonly value="수업시간">
                <input type="text" name="stime" id="ctime" readonly placeholder="시작시간">~
                <input type="text" name="etime" id="ctime2" readonly placeholder="종료시간"><br>
                </div>
                <div id="onetime">
                <input type="text"  class="view" readonly value="일 수업시간">
                <input type="text" name="time" id="cttime" readonly  >
               </div>
               <div id="divcapa">
                <input type="text" class="view" readonly value="모집인원">
                <input type="number" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"name="capa" id="rnumber"  min="1" maxlength="2" placeholder="모집인원을 입력해주세요.">
               </div>
                <div id="pst">
                    <input type="text" id="posi" readonly value="수업장소"><br>
                    <input type="text" name="pstno" id="sample6_postcode" readonly placeholder="우편번호">
                    <input type="button" id="findpstno" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                    <input type="text" name="basAddr" id="sample6_address" readonly placeholder="주소">
                    <input type="text" name="detAddr" id="sample6_address2" maxlength="25" placeholder="상세주소">
                 </div>
                 <div id="file-box">
                     <input type="text" class="view" id="video-url" readonly value="동영상  URL"><br>
                     <input type="url" name="cfile" id="imgInput"  />
                 </div> 
                 <div id="filetable">
                       <div>
                       <button class="btn btn-primary inputFile" style="border: none; background-color: #FFB53C;font-weight:bold;">파일 업로드</button>
                        <input type="file" id="files" name="files" class="1" style="position:absolute; width:100px;height:33px ; top:318px; opacity: 0;"
                        onChange="fileCheck(this.form.files)" multiple accept="image/*" />
                       
                       
                       <input type="file" id="files" name="files" multiple
						accept="image/*" onChange="fileCheck(this.form.files)" style="display :none;"><br />
	
						<div id="selectedFiles" ></div>
                	 </div>
               </div>
             </div>
             </div>
            
             <h2>강사소개</h2>
                 <textarea id="classcowdog" name="tinfo"></textarea>
             <h2>강의설명</h2>
                 <textarea id="classtteok" name="cinfo"></textarea>
                 <input id="days" type="hidden" name="days">
                 <input id="removefiles" type="hidden" name="removefiles">
                 <input type="hidden" id="type" name="type" value="단기"> 
                 <input type="button" id="back-home-btn" onclick="back_btn()" value="뒤로가기">  
              	 <input type="button" id="clsinsert" onclick="emptychk();" value="클래스 등록" />
              	 <input type="hidden" id="selbigtag" name="selbtag">
              	 <input type="hidden" id="selmtag" name="selmtag"> 
              </form>
            </div>
        </div>
        </div>
    </div>


<script> 

	$(document).ready(function(){ 
	    $("input:radio[name=typeChk]").click(function() 
	    { 
	    	$("#type").val($("input[name=typeChk]:checked").val());
	    });
		/*$(".note-image-input.note-form-control.note-input").remove;
	    console.log("되니?");*/
	    
	    
	     /* $('#mainNav .navbar-brand').css('margin-bottom', '50');
	     $('.navbar-brand').css('margin-bottom', '50');
	     $('#mainNav').css("padding", "0");
	     $('#mainNav').css("border", "0"); */
	});
	
function emptychk(){
	if($("#ctitl").val().length < 3){
		swal({
			text:"제목은 최소 3글자이상 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#imgInput").val().length > 0 && !($("#imgInput").val().substr(0 , 16) == 'https://youtu.be' || 
			$("#imgInput").val().substr(0 , 23) == 'https://www.youtube.com')) {
				swal({
				text:"유튜브 URL만 가능합니다.",
				button:"확인"
				});
				return false;
	}else if($("#rnumber").val() == ""){
		swal({
			text:"모집인원을 입력해주세요",
			button:"확인"
		});
		return false;
	}else if($("#cpay").val() == ""){
		swal({
			text:"가격을 입력해주세요",
			button:"확인"
		});
		return false;
	}else if($("#rnumber").val() > 50){
			swal({
				text:"최대 모집인원은 50명입니다.",
				button:"확인"
			});
			return false;
	}else if($("#classcowdog").val().length < 100){
		swal({
			text:"강의 소개는 최소100글자이상 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#classtteok").val().length < 100){
		swal({
			text:"강의 설명은 최소100글자이상 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($('#files').val().length < 1){
		swal({
			text:"사진한장이상 선택해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#sample6_postcode").val() == ""){
		swal({
			text:"우편번호를 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#sample6_address").val() == ""){
		swal({
			text:"기본주소를 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#ctime").val().length < 1){
		swal({
			text:"시간을 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#ctime2").val().length < 1){
		swal({
			text:"시간을 입력해주세요.",
			button:"확인"
		});
		return false;
	}else if($("#type").val() == '장기' && $("#cdate").val().length < 1){
			swal({
				text:"날짜를 선택해주세요.",
				button:"확인"
			});
			return false;
	}else if($("#type").val() == '장기' && $("#cdate2").val().length < 1){
			swal({
				text:"날짜를 선택해주세요.",
				button:"확인"
			});
			return false;
	}else if($("#type").val() == '단기' && $('#daylist option').length < 1){
			swal({
				text:"날짜를 선택해주세요.",
				button:"확인"
			});
			return false;
	}else if($("#cpay").val() < 1000){
		swal({
			text:"시간당 최소금액은 1000원이상입니다.",
			button:"확인"
		});
		return false;
	}else if($("#rnumber").val() < 1){
		swal({
			text:"모집인원의 최소인원은 1명이상입니다.",
			button:"확인"
		});
		return false;
	}else if($("#ctime2").val().substr(0,2) < $("#ctime").val().substr(0,2)){
    		swal({
				text:"시작시간이 끝나는시간보다 작아야합니다",
				button:"확인"
			});
    		return false;
	}else if($("#ctime2").val().substr(0,2) == $("#ctime").val().substr(0,2)){
    		swal({
				text:"시작시간과 끝나는시간이 같으면안됩니다.",
				button:"확인"
			});
    		return false;
	}else if($('#bigtagSel option:selected').val() == ''){
		swal({
			text:"대분류를 선택해주세요.",
			button:"확인"
		});
		return false;
	}else if($('#selmtag').val() == ''){
		swal({
			text:"중분류를 선택해주세요.",
			button:"확인"
		});
		return false;
	}else {
		swal({
		        title: "클래스 신청이 완료되었습니다.", 
		        text: "심사기간은 최대 3일입니다.",
		        timer:3000,
		        button:"확인"
		        }).then((value) => {
		       		document.getElementById('uploadForm').submit();
		        });
	}
}

function back_btn(){
	history.back();
}

$( "#bigtagSel").change(function() {
	var sel = $('#bigtagSel option:selected').val();
	if(sel == 2){
		$('#selmtag').val('');
		$('#MiddletagSel2').val('');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel2').css('display','inline-block');
		console.log($('#MiddletagSel2 option:selected').val());
		$('#MiddletagSel2').click(function(){
			$('#selmtag').val($('#MiddletagSel2 option:selected').val());
		});
	}else if(sel == 3){
		$('#selmtag').val('');
		$('#MiddletagSel3').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel3').css('display','inline-block');
		$('#MiddletagSel3').click(function(){
			$('#selmtag').val($('#MiddletagSel3 option:selected').val());
		});
	}else if(sel == 4){
		$('#selmtag').val('');
		$('#MiddletagSel4').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel4').css('display','inline-block');
		$('#MiddletagSel4').click(function(){
			$('#selmtag').val($('#MiddletagSel4 option:selected').val());
		});
	}else if(sel == 5){
		$('#selmtag').val('');
		$('#MiddletagSel5').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel5').css('display','inline-block');
		$('#MiddletagSel5').click(function(){
			$('#selmtag').val($('#MiddletagSel5 option:selected').val());
		});
	}else if(sel == 6){
		$('#selmtag').val('');
		$('#MiddletagSel6').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel6').css('display','inline-block');
		$('#MiddletagSel6').click(function(){
			$('#selmtag').val($('#MiddletagSel6 option:selected').val());
		});
	}else if(sel == 7){
		$('#selmtag').val('');
		$('#MiddletagSel7').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel7').css('display','inline-block');
		$('#MiddletagSel7').click(function(){
			$('#selmtag').val($('#MiddletagSel7 option:selected').val());
		});
	}else if(sel == 8){
		$('#selmtag').val('');
		$('#MiddletagSel8').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel9').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel8').css('display','inline-block');
		$('#MiddletagSel8').click(function(){
			$('#selmtag').val($('#MiddletagSel8 option:selected').val());
		});
	}else if(sel == 9){
		$('#selmtag').val('');
		$('#MiddletagSel9').val('');
		$('#MiddletagSel2').css('display','none');
		$('#MiddletagSel3').css('display','none');
		$('#MiddletagSel4').css('display','none');
		$('#MiddletagSel5').css('display','none');
		$('#MiddletagSel6').css('display','none');
		$('#MiddletagSel7').css('display','none');
		$('#MiddletagSel8').css('display','none');
		$('#MiddletagSelBase').css('display','none');
		$('#MiddletagSel9').css('display','inline-block');
		$('#MiddletagSel9').click(function(){
			$('#selmtag').val($('#MiddletagSel9 option:selected').val());
		});
	}
	$('#selbigtag').val($('#bigtagSel option:selected').val());
});


	
$("#contactChoice1").click(function() {
    $("#oneday-btn").show(); 
    $("#allday-btn").hide();
});
$("#contactChoice2").click(function(){
	 $("#oneday-btn").hide(); 
	 $("#allday-btn").show();
});


var selDiv = "";

document.addEventListener("DOMContentLoaded", init, false);

function init() {
    document.querySelector('#files').addEventListener('change',
            handleFileSelect, false);
    selDiv = document.querySelector("#selectedFiles");
}

function handleFileSelect(e) {
	var sumsize = 0;
    if (!e.target.files || !window.FileReader)
        return;

    selDiv.innerHTML = "";

    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);
    
    var html = "";
    html += "<div class='col-lg-12' id='imgBind'>";
    for (var i = 0; i < filesArr.length; i++) {
        
        var f = files[i];
        if (!f.type.match("image.*")) {
            return;
        }
        var j = 0;
        var reader = new FileReader();
        reader.onload = function(e) {
            //console.log("filesArr[i]="+filesArr[i] +  " ," + i);
            //console.log("filesArr[j]="+filesArr[j] +  " ," + j);
            //console.log(e.result)
            f = filesArr[j];
            /* console.log(f);
            console.log(e); */
            console.log(e);
            sumsize += e.loaded ;
            console.log(sumsize);
            if(e.loaded > 2000000){
            }else if(sumsize > 10000000){
            	$('#imgBind div').remove();
            }else{
            //else if()
            html += "<div class='row imgDiv' id='imgDiv"+j + "' style='float:left; margin:5px;'>";

            html += "<div class='col-lg-12 px-0'>";
            html += '<img class="fileImg" src=\"' + e.target.result + '\" onclick="removeImg(' + j + ' )">';
            html += "</div>";
            html += "</div>";

            selDiv.innerHTML = html;
            j++;
            }
        }
        reader.readAsDataURL(f);
    }
    selDiv.innerHTML += "</div>";

}

function removeImg(no) {
    event.preventDefault(); /* 스크립트 기본동작 중지 */
    console.log(no);
    $("div#imgDiv" + no).remove();
}

/* var removefiles = $('#removefiles');
$(document.body).on('click', '.remove-file-btn', function (event) {
    //event.preventDefault(); 
    var no = $(event.target).attr('data-fileno');
    var filename = $(event.target).attr('data-filename');
    $("div#imgDiv" + no).remove();
    
    var files = removefiles.val();
    if (files.length > 0) {
    	files += ","
    }
    files += filename;
    removefiles.val(files)
}); */

   $( "#ctime" ).timepicker({
	   interval: 60,
	   timeFormat :'HH:mm',
	   change: function(time) { 
		    var ct2 = $("#ctime2").val().substr(0,2);
			var ct1 = $("#ctime").val().substr(0,2);
	    	var alltime = ct2-ct1
 	  		$("#cttime").val(Math.abs(alltime));	 
      	    $("#ctime2").timepicker("option","minTime", time);
	   }
   });
       
      // $("#ctime2").timepicker("option","minTime", time);
  // }
	   
	 //  change: function(time) { 
		   // the input field
     //      var element = $(this), text;
           // get access to this Timepicker instance
     //      var timepicker = element.timepicker();
           //console.log(timepicker.format(time));
     //      $("#ctime2").timepicker("option","minTime", time);
     //  }
   
   
   $( "#ctime2" ).timepicker({
	   interval: 60,
	   timeFormat :'HH:mm',
	   change: function(){
			var ct2 = $("#ctime2").val().substr(0,2);
			var ct1 = $("#ctime").val().substr(0,2);
	    	var alltime = ct2-ct1
  	  		$("#cttime").val(Math.abs(alltime));	    		
	   }
   });
	 //  change: function(time) {
     //      var element = $(this), text;
     //      var timepicker = element.timepicker();
     //      $("#ctime").timepicker("option","maxTime", time);
     //  }
//    $("#cdate").datepicker({
//    	minDate: 0,
//    	dateFormat:'yy-mm-dd'
//    });
    
 //  	var newdd = $("#cdate").datepicker('getDate').getDate();
 //  	var newmm = $("#cdate").datepicker('getDate').getMonth();
 //  	var newyy = $("#cdate").datepicker('getDate').getFullYear();
    //$("#cdate").datepicker({
   // 	minDate: fullDate,
   // 	dateFormat:'yy-mm-dd',
   //		onClose: function() {
   	//	    $("#cdate2").datepicker({
   	//	      dateFormat: 'yy-mm-dd',
   		//      minDate : 0
   		    //  minDate: new Date(selector의 시작날),
   		    //  maxDate: new Date('2017-12-31')
   		//    });
  // 		}
//    });
    
var today = new Date();
var dd = today.getDate() + 3;
var mm = today.getMonth()+1; //January is 0!
var yy = today.getFullYear();
if(dd<10) {
    dd='0'+dd
} 
if(mm<10) {
    mm='0'+mm
} 
today = yy+'-' + mm+'-'+dd;
	$("#cdate").datepicker({
		dateFormat: 'yy-mm-dd',
		minDate: today,
		onSelect: function(selected) {
			$("#cdate2").datepicker("option","minDate", selected)
		}
	});
	$("#cdate2").datepicker({
		dateFormat: 'yy-mm-dd',
		onSelect: function(selected) {
			$("#cdate").datepicker("option","maxDate", selected)
		}
	});
    /* $('#calendar').fullCalendar({
   	  dayClick: function(date, jsEvent, view, resourceObj) {
   		  swal("ASD");
   	      var seldate = date.format();
   	      var option = $("<option value='"+seldate+"'>"+seldate+"</option>");
   	      if($('#daylist option').filter(function(){return this.value==seldate}).length == 0)
   	            $("#daylist").append(option);
   	  }
   	}); */
     
$("#sledel").click(function(){
    $("#daylist option:selected").remove();
    var days = new Array();
   	$('#daylist > option').each(function(i, e) {
   		days.push($(e).val())
   	});
   	$('#days').val(days);
});
   	
   	
  
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
 
        reader.onload = function (e) {
            $('#image_section').attr('src', e.target.result);
        }
 
        reader.readAsDataURL(input.files[0]);
    }
}
 

 function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
       
            var fullAddr = ''; 
            var extraAddr = ''; 

            if (data.userSelectedType === 'R') {
                fullAddr = data.roadAddress;
            } else { 
                fullAddr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }
            document.getElementById('sample6_postcode').value = data.zonecode; 
            document.getElementById('sample6_address').value = fullAddr;

            document.getElementById('sample6_address2').focus();
        }
    }).open();
}    
 
 /* function wow(){                     
         var form = $('#uploadForm')[0];
         var formData = new FormData(form);
         
         
         for (var index = 0; index < Object.keys(filelist).length; index++) {
             formData.append('filelist',filelist[index]);
         }
         
          $.ajax({
             type : 'POST',
             enctype : 'multipart/form-data',
             processData : false,
             contentType : false,
             cache : false,
             timeout : 5000,
             url : 'classinsert',
             dataType : 'JSON',
             data : formData,
             success : function(result) {
                 //이 부분을 수정해서 다양한 행동을 할 수 있으며,
                 //여기서는 데이터를 전송받았다면 순수하게 OK 만을 보내기로 하였다.
                 //-1 = 잘못된 확장자 업로드, -2 = 용량초과, 그외 = 성공(1)
                 if (result === -1) {
                     alert('jpg, gif, png, bmp 확장자만 업로드 가능합니다.');
                     return falsae;
                 } else if (result === -2) {
                     alert('파일이 10MB를 초과하였습니다.');
                     return false;
                 } else {
                     alert('이미지 업로드 성공');
                     return true;
                 }
             },
             error:function(){
            	 console.log("실패");
             }
         });
 }  */ 

  $(document).ready(function() {
     $('#classcowdog').summernote();
     $(".note-image-input.note-form-control.note-input").remove();
	    console.log("되니?");
      $('div.note-popover.popover.in.note-link-popover.bottom').remove();
     $('div.note-popover.popover.in.note-image-popover.bottom').remove();
     $('div.popover-content.note-children-container').remove();
      $('div.arrow').remove(); 
     $('div.note-popover.popover.in.note-table-popover.bottom').remove();
     
 });

 $(document).ready(function() {
     $('#classtteok').summernote();
     $(".note-image-input.note-form-control.note-input").remove();
	    console.log("되니?");
      $('div.note-popover.popover.in.note-link-popover.bottom').remove();
     $('div.note-popover.popover.in.note-image-popover.bottom').remove();
     $('div.popover-content.note-children-container').remove();
      $('div.arrow').remove(); 
     $('div.note-popover.popover.in.note-table-popover.bottom').remove(); 
     
 }); 
 
 
 
$(document).ready(function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; 
        var yyyy = today.getFullYear();

        if(dd<10) {
        dd='0'+dd
        } 

        if(mm<10) {
        mm='0'+mm
        } 

        today = yyyy+'-'+mm+'-'+dd;
        today2 = yyyy+2+'-'+mm+'-'+dd;
        
    $('#calendar').fullCalendar({
       header: {
        left: 'title',
        center: '',
        right: 'today prev,next'
      },validRange: {
          start: today,
          end: today2
      },
      defaultDate: today,
      editable: false, 
      eventLimit: true, 
	      dayClick: function(date, jsEvent, view, resourceObj) {
	   	      var seldate = date.format();
	   	      var option = $("<option  value='"+seldate+"'>"+seldate+"</option>");
	   	      if($('#daylist option').filter(function(){return this.value==seldate}).length == 0)
	   	            $("#daylist").append(option);
	   	      
		   	   var days = new Array();
			   	$('#daylist > option').each(function(i, e) {
			   		days.push($(e).val())
			   	});
			   	$('#days').val(days);
		   	  }
      
    }); 
  });
function fileCheck(file)
{
	console.log("asd");
        // 사이즈체크
        var maxSize  = 10000000;    //10MB
        var fileSize = 0;
       // console.log(file[0].size);
       // console.log(file[1].size);
        console.log(file);
       // console.log(file[0].value.size);
       // console.log(file[1].value.size);
       console.log($("#files")[0].files.length);
        
        

	// 브라우저 확인
	var browser=navigator.appName;
	
	// 익스플로러일 경우
	if (browser=="Microsoft Internet Explorer")
	{
		var oas = new ActiveXObject("Scripting.FileSystemObject");
		fileSize = oas.getFile( file.value ).size;
		
	}
	// 익스플로러가 아닐경우
	else
	{
		console.log("익스플로러x 실행");
		for(var x=0; x<$("#files")[0].files.length; x++){
			if(file.files[x].size > 2000000 ){
				swal({
					text:"첨부파일 한장당 사이즈는 2MB 이내로 등록 가능합니다. ",
					button:"확인"
					});
				console.log("2MB 넘는 파일 이름 : " + file.files[x].name);
				console.log("2MB 넘는 파일 사이즈 : " +file.files[x].size);
				console.log(x);
//				removeImg(x);
				console.log(file.files[x]);
				file.files[x].remove;
				console.log(file.files[x]);
				//$('#files').html();
				$("#files").val("");
				//$("div#imgDiv" + x).remove();
			}else{
				fileSize += file.files[x].size;
				console.log(file.files[x].size);
			}
		//console.log($("#files").size); 
		//console.log("asdzxc"); 
		} 
			console.log("전체 파일 사이즈 : " + fileSize);
		
		console.log("???");
	}
	
	console.log("asdasdasd");
	//console.log(fileSize);


        if(fileSize > maxSize)
        {
        	swal({
				text:"첨부파일 전체 사이즈는 10MB 이내로 등록 가능합니다. ",
				button:"확인"
				});
            //alert("첨부파일 사이즈는 10MB 이내로 등록 가능합니다.    ");
        	$('#uploadForm input[type="file"]').val('');
        }

}
  
</script>
</body>
</html>