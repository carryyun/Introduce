<%@ page import="com.yun.board.domain.ClassOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-12">
    <div class="panel panel-default">
       
                          
        <div class="panel-body">
            <table class="table table-condensed" style="border-collapse:collapse;">
 
                <thead> 
                    <tr id="th-pay">
                       
                         <th width="5%">No.</th>
                         <th width="10%">사진</th>
                         <th width="30%">클래스</th>
                         <th width="15%">멘토</th>
                         <th width="15%">시작일</th>
                         <th width="15%">수업시간</th>
                         <th width="10%">수료상태</th>
 
                         
                    </tr>
                </thead>
                <tbody>

   <c:forEach items="${colist}" var="c" varStatus="i">
     

                    <tr id="tb-pay" >
                                              
                       <td>${i.count}</td>
                        <td><a href="../class/detail?no=${c.classes.no}"><img src="${c.classFile.fname}" width="100px" height="70px"></a></td>
                        <td><a href="../class/detail?no=${c.classes.no}">${c.classes.titl}</a></td>
                        <td>${c.mentornick}</td>
                        <td>${c.timetable.date}</td>
                         <td>${c.timetable.stime}<br>(${c.classes.time}시간)<br>${c.tot_pric}</td>
                        <td>
                            
                        <c:choose>
                        
                            <c:when test="${c.cert.no == null }">
                                                          미수료 <br>
                            </c:when>
                             
                            <c:when test="${c.cert.no != null }">
                                <c:if test="${c.cert.type == '수료증' }">
                                                          
                                                                 수료<br>                      
                                    <div style="border:2px solid black">
                                    <b>${c.cert.type}</b><br>
                                    ${c.bigTag.name}<br>
                                    ${c.middleTag.name}<br>
                                    </span>
                                    <%-- ${c.cert.cnt}<br>
                                    ${c.cert.ctdt}<br>
                                    ${c.cert.edt} --%>
                               
                               </c:if>
                             </c:when>
                             
                         </c:choose>
                                
                                



                            
                            
                                
                        <%-- ${c.cert.type}수료증 if문처리(필요한것 : 클래스중분류,사용가능기한,발급횟수) --%>
                        
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
<nav aria-label="Page navigation"  class="pn-center" >
  <ul class="pagination" >
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>
            