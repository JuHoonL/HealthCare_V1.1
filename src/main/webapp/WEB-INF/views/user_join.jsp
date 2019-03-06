<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	#user-field {
		width: 500px;
		margin: 10px auto;
	}
	
	legend {
		font-weight: bold;
		font-size: 25pt;
		color:#3E65FF;
		text-align: center;
	}
	
	label {
		display: block;
		width: 150px;
		float: left;
		text-align: right;
		margin: 8px;
	}
	
	input, select {
		border: 1px soild lightgray;
		margin: 8px;
		margin-left: 15px;
	}
	
	#btn-join {
		margin-left : 15px;
	}
	
	.button-join {
		width:100px;
		margin: 8px;
	}
	
	
</style>
<script>
 $(function(){
	 $("#btn-reset").click(function(){
		 location.href="${pageContext.request.contextPath}/"
	 })
 })
</script>
</head>
<body>
	<section>
		<form action="user_join" method="POST">
		<fieldset id="user-field">
			<legend>회원가입</legend>
			<label for="userId">ID</label>
			<input type="text" id="userId" name="userId"
			placeholder="아이디를 입력하세요" ><br/>
		
			<label for="userName">이름</label>
			<input type="text" id="userName" name="userName"
			placeholder="이름을 입력하세요"><br/>
			
			<label for="password">비밀번호</label>
			<input type="password" id="password" name="password"
			placeholder="비밀번호를 입력하세요" ><br/>
			
			<label for="birth">생년월일</label>
			<input type="date" id="birth" name="birth"
			placeholder="생년월일을 입력하세요"><br/>
			
			<label for="height">키</label>
			<input type="text" id="height" name="height"
			placeholder="본인의 키를 입력하세요"><br/>
			
			<label for="weight">몸무게</label>
			<input type="text" id="weight" name="weight"
			placeholder="본인의 몸무게를 입력하세요" ><br/>
			
			<label for="activityindex">활동지수</label>
			<select id="activityindex"  name="activityindex">
				<option value="31">평소 운동량이 적은 사람</option>
				<option value="33">하루 한시간 운동하는 사람</option>
				<option value="35">하루 두세시간 운동하는 사람</option>
				<option value="40">힘든 육체노동을 하는 사람</option>
				<option value="43">전문 운동선수</option>
			</select><br />
			
			<label></label>
			<button id="btn-join" class="button-join">회원가입</button>
			<button type="button" id="btn-reset" class="button-join">취소</button>
		</fieldset>
		</form>
	</section>

</body>
</html>