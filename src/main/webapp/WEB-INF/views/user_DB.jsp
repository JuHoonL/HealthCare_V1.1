<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin.css" >
<style>
	
* {
	box-sizing: border-box;
	-webkit-box-sizing:border-box;
	-moz-box-sizing:border-box;
}


button {
	border-radius: 10px;
	background-color: gray;
	color: white;
	margin: 5px;
	font-weight: bold;
	position: relative;
	left: 200px;
	height: 30px;
	width: 100px;
	
}

button:hover{
	color: black;
}


#div-userDB {
	
	width: 150px;
	margin: 1px auto;
	display: inline-block;
	text-align: right;
}

#div-userDB2 {

	width: 300px;
	margin: 1px auto;
	display: inline-block;
}

.div-userDB{
	align-content: center;
}
h3{	
	padding: auto;
	display: inline-block;
}


i{
	font-size: 50px;
}

#div-main {
	width: 500px;
	margin: 1px auto;
}

</style>

</head>
<body>
<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
     <div style ="text-align:right; width:100%;">
    <label style = "color:white;">Id</label> <input type ="text" style = "text-align:right; ">
    <label style = "color:white;">PassWord</label> <input type ="password" style = "text-align:right; ">
     
    
    
    </div>
	<a class="btn btn-link btn-sm text-white ml-auto " style = "width:100px;"
	href="sports" >
	로그인
    </a>
	<a class="btn btn-link btn-sm text-white"  style = "width:100px;"
	href="user_join" >
	회원가입
    </a>

    </nav>
</header>
<section>
<i class='far fa-id-card'></i>
<h4>마이페이지</h4>


<div id="div-main">
<div id="div-userDB" class="div-userDB">
	<h3>ID :</h3><br/><br/>
	<h3>이름 :</h3><br/><br/>
	<h3>비밀번호 : </h3><br/><br/>
	<h3>생년월일 : </h3><br/><br/>
	<h3>키 : </h3><br/><br/>
	<h3>몸무게 : </h3><br/><br/>
	<h3>활동지수 : </h3>
</div>
<div id="div-userDB2" class="div-userDB">
	<h3> ${USER.id }</h3><br/><br/>
	<h3> ${USER.userName }</h3><br/><br/>
	<h3> ${USER.password }</h3><br/><br/>
	<h3> ${USER.birth }</h3><br/><br/>
	<h3> ${USER.height }</h3><br/><br/>
	<h3> ${USER.weight }</h3><br/><br/>
	<h3> ${USER.activityindex }</h3>
</div>	


<div id="div-button">
	<button type="button" id="btn-update" >정보수정</button>
	<button type="button"id="btn-delete">회원탈퇴</button>
</div>
</div>
</section>
</body>
</html>


