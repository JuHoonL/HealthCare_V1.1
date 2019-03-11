<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>헬스</title>
<link rel="stylesheet" href="<c:url value='/css/home2.css' />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body>
<%@ include file="/WEB-INF/views/include/header2.jspf" %>
<c:if test="${BODY == 'MAIN'}">
	<%@ include file="/WEB-INF/views/include/main.jspf" %>
</c:if>
<c:if test="${BODY == 'FOOD'}">
	<%@ include file="/WEB-INF/views/include/food_selectHome.jspf" %>
</c:if>
<c:if test="${BODY == 'SPORTS'}">
	<%@ include file="/WEB-INF/views/include/sports_list.jsp" %>
</c:if>
<c:if test="${BODY == 'USERDB'}">
	<%@ include file="/WEB-INF/views/include/user_DB1.jspf" %>
</c:if>
<c:if test="${BODY == 'CHPASS'}">
	<%@ include file="/WEB-INF/views/include/confirm_password.jspf" %>
</c:if>
<c:if test="${BODY == 'CHPASS2'}">
	<%@ include file="/WEB-INF/views/include/password2.jspf" %>
</c:if>
</body>
</html>
