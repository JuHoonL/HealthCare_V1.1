<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="<c:url value='/css/food-select.css' />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
  	$(function(){
  		var foodList = Array()
  		
  		var sk = $("#T-kcal").text()
		var kcal = parseFloat(sk == "" ? 0 : sk)
  		
		$(".td-foodname").click(function(){
			let code = $(this).attr("data-d-code")
			foodList.push(code)
		
			$.ajaxSettings.traditional = true;
			
			$.ajax({
				url:"${rootPath}/user_select_food1",
				method:"POST",
				traditional:true, 
				data:{foodList:foodList},
				//contentType:"application/json",
				//data:JSON.stringify(foodList),
				success:function(result){
					var sFood = ""
					
					for(let i = 0 ; i < result.length ; i++) {
						sFood = result[i].foodName + "(" + result[i].foodkcal + ")" 
						kcal += Math.round(parseFloat(result[i].foodkcal))
						if(i < result.length -1) {
							sFood += "" + "+" + ""
						}
					}
					$(".calcekcal").append("<span>" + sFood + "&nbsp" + "&nbsp" + "</span>")
					$("#T-kcal").text(kcal)
					
				},
				error:function(){
					alert("서버와 통신오류!!")
				}
			})
		})
	})
</script>
<style>
	td a {
		color: black;
		font-weight: bold;
	}	
	
</style>
	<c:set var="i" value="0" />
	<c:set var="j" value="5" />
	<table>
	<c:choose>
		<c:when test="${empty CATEFOOD}">
			<h3> 대분류를 선택해 주세요 </h3>
		</c:when>
		<c:otherwise>
			<c:forEach var="FoodVO" items="${CATEFOOD}">
				<c:if test="${i%j == 0}">
					<tr>
				</c:if>
					<td><a href="javascript:void(0)" class="td-foodname" data-d-code="${FoodVO.id}">${FoodVO.foodName}</a></td>
				<c:if test="${i%j == j-1}">
					</tr>
				</c:if>
			<c:set var="i" value="${i+1}" />
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>


	

