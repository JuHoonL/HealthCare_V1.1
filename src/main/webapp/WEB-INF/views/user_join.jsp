<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>

	section {
		margin-top: 50px;
		width: 100%;
		height: 100%;
	}

	#user-field {
		width: 30%;
		margin: 10px auto;
		height: 50%;
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
		margin: 10px;
	}
	
	input, select {
		border: 1px soild lightgray;
		margin: 10px;
		margin-left: 15px;
		height: 25px;
		width: 50%;
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
	 
	 $("#btn-join").click(function(){
		var userId = $("#userId").val()
		var userName = $("#userName").val()
		var password = $("#password").val()
		var re_password = $("#re_password").val()
		var birth = $("#birth").val()
		var height = $("#height").val()
		var weight = $("#weight").val()
		var activityindex = $("#activityindex").val()
		 
		if(userId == "") {
			alert("id를 반드시 입력하세요")
			$("#userId").focus();
			return false;
		} 
		if(userName == "") {
			alert("이름을 반드시 입력하세요")
			$("#userName").focus();
			return false;
		}
		if(password == "") {
			alert("비밀번호를 반드시 입력하세요")
			$("#password").focus();
			return false;
		}
		if(re_password == "") {
			alert("비밀번호 확인을 반드시 입력하세요")
			$("#re_password").focus();
			return false;
		}
		if(birth == "") {
			alert("생년월일을 반드시 입력하세요")
			$("#birth").focus();
			return false;
		}
		if(height == "") {
			alert("키를 반드시 입력하세요")
			$("#height").focus();
			return false;
		}
		if(weight == "") {
			alert("몸무게를 반드시 입력하세요")
			$("#weight").focus();
			return false;
		}
		if(m_password != m_re_password) {
			alert("비밀번호와 확인이 일치하지 않습니다")
			$("#m_password").val("")
			$("#m_re_password").val("")
			$("#m_password").focus()
			return false;
		}
		$("form").submit()
	 })
	 
	 
	 $("#userId").blur(function(event){
		
		event.preventDefault()
		
		let userid= $("#userId").val()

		if(userid == "") {
			alert("아이디를 입력하세요")
			
			return false;
		}
		
		$.ajax({
			
			url : "<c:url value='/id_check' />",
			method:"POST",
			data : {userId:userid},
			success:function(result) {
				
				if(result=="true"){
					$(".errorMsg").css("display","block")
					$("#errorMessage").text("사용할 수 있는 ID 입니다.")
					$("#userName").focus();
				}
				if(result=="false"){
					$(".errorMsg").css("display","block")
					$(".errorMsg").text("이미 등록된 ID 입니다")
		 			$("#userId").val("");
					$("#userId").focus();
				}
			},
			error:function(){
				alert("서버오류")
			}
		})
	})
	 
	
	 $("#btn-reset").click(function(){
		 location.href="${pageContext.request.contextPath}/"
	 })
 })
</script>
<style>
	.errorMsg {
		display: none;
		margin-left: 190px;
		color: red;
		font-weight: bold;
	}
</style>
</head>
	<section>
		<form action="user_join" method="POST">
		<fieldset id="user-field">
			<legend>회원가입</legend>
			<label for="userId">ID</label>
			<input type="text" id="userId" name="userId"
			placeholder="아이디를 입력하세요" ><br/>
			
			<span id="errorMessage" class="errorMsg"></span>
		
			<label for="userName">이름</label>
			<input type="text" id="userName" name="userName"
			placeholder="이름을 입력하세요"><br/>
			
			<label for="password">비밀번호</label>
			<input type="password" id="password" name="password"
			placeholder="비밀번호를 입력하세요" ><br/>
			
			<label for="re_password">비밀번호확인</label>
			<input type="password" id="re_password" name="re_password"
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
