<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천운동 목록</title>
<style>
  	
	#div-sports {
		margin: 0px auto; 
		padding-top: 35px;
		display: flex;
		flex-direction: column;
		width: 100%;
		height: 780px;
		overflow: auto;
		background-color: #dededc;
	}
	
	#view-kcal {
		flex: 2;
		width: 450px;
		margin: 0px auto;
		text-align: center;
		font-size: 15pt;
		
	}
	
	#for-center-div {
		flex: 3;
		width: 450px;
		margin: 0px auto;
		text-align: center;
		line-height: 120%;
		font-size: 15pt;
	}
	
	
	.workspace{
		text-align: center;
		padding: 50px;
		font-size: 15pt;
		height: 50px;
		color: red;
		font-weight: bold;
	}
	
	#activitylist{
		padding: 10px;
		height: 50px;
		margin: 50px;
		font-size: 15pt;
		border: 2px solid gray;
	  	border-radius: 12px;
	
	}
	
	#btn-submit {
		width: 30%;
		background-color: #333333;
		color: white;
	}
	
	.btn-re{
		height:100px;
		margin: 1px auto;
		text-align: center;
		flex: 1;
		width: 100%;
	}
	
	#btn-return {
		width: 20%;
		height: 50px;
		background-color: #333333;
		color: white;
	}

	#view-list1{
		color: green;
	}
	#view-list3{
		color: red;	
		font-weight: bolder;
	}
	
	#span-content {
		flex: 3;
		width: 50%;
		margin: 0px auto;
	}
	
	#ppp {
		text-align: center;
		font-size: 15pt;
		font-weight: bold;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btn-submit").click(function(){
		var kg = ${WEIGHT}
		var kcal = ${OVERKCAL}
		var num = $("#activitylist").val()
		
		$.ajax({
			url:"<c:url value='/sports_AJAX' />",
			method: "POST",
			data:{kG:kg,kCAL:kcal,num:num},
			success:function(result){
				$(".workspace").text(result)
			},
			error:function(){
				
			}
		})
	})
	
	$("#btn-return").click(function(){
		location.href="<c:url value='food_select' />"
	})
})
</script>
<div id="div-sports">
	<div id="view-kcal">
		<p>하루 권장칼로리 : <span class="view-list" id="view-list1"> ${STANDKCAL} </span> kcal</p>
		<p>하루동안 먹은칼로리 : <span class="view-list" id="view-list2"> ${TOTALKCAL}</span> kcal</p>
		<p>오버된 칼로리 : <span class="view-list" id="view-list3"> ${OVERKCAL}</span> kcal</p>
	</div>
	<div id="for-center-div">
		<form action="activity_list" method="POST">
			<fieldset id="activity">
				<label for="activitylist">운동선택</label>
					
					<select id="activitylist"  name="activitylist">
						<option value="0">걷기</option>
						<option value="1">등산</option>
						<option value="2">싸이클</option>
						<option value="3">훌라후프</option>
						<option value="4">자전거</option>
						<option value="5">줄넘기</option>
						<option value="6">달리기</option>
						<option value="7">윗몸일으키기</option>
						<option value="8">스쿼트</option>
						<option value="9">런닝머신</option>
						<option value="10">요가</option>
						<option value="11">계단</option>
					</select><br />
					
					<label></label>
				<button type="button" id="btn-submit" class="button-submit">확  인</button>
				
			</fieldset>
		</form>
	</div>
		<div id="span-content">
			<p id="ppp">운동시간을 확인하세요</p>
			<p class="workspace"></p>
		</div>	
		<div class="btn-re"><button type="button" id="btn-return" >음식선택 다시하기</button></div>
</div>