<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${basePath}css/common/common.css">
</head>
<body>
	<div class="list-float">
		<ul>
			<c:if test="${!empty USER_CXT.userName}">
				<li>${USER_CXT.userName}(${USER_CXT.credit}),欢迎您的到来</li>
				<li><a href="<c:url value="/login/doLogout"/>">注销</a></li>
			</c:if>
			<c:if test="${empty USER_CXT.userName}">
				<li><a href="<c:url value="/login"/>">登录</a></li>
				<li><a href="<c:url value="/register"/>">注册</a></li>
			</c:if>
		</ul>
		<ul class="list-right">
			<c:if test="${USER_CXT.userType == 2}">
				<li><a href="<c:url value="/forum/addBoardPage.html"/>">新建论坛版块</a></li>
				<li><a href="<c:url value="/forum/setBoardManagerPage.html"/>">论坛版块管理员</a></li>
				<li><a href="<c:url value="/forum/userLockManagePage.html"/>">用户锁定/解锁</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>

