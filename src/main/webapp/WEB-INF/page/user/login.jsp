<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${basePath}css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${basePath}css/common/common.css">
    <title>Login Page</title>
</head>
<body>
<form id="loginForm" class="form-horizontal" action="login"
      method="post" onsubmit="return logincheck()">
    <div class="form-group">
        <table class="table-login">
            <tr>
                <td><label class="col-sm-2 control-label">Username:</label></td>
                <td><input id="userName" name="userName" type="text"
                           class="form-control" placeholder="User Name" value="${userName}"/></td>
            </tr>
            <tr>
                <td><label class="col-sm-2 control-label">Password:</label></td>
                <td><input id="password" name="password" type="password"
                           class="form-control" placeholder="Password"/></td>
            </tr>
            <c:if test="${!empty errorMsg }">
                <tr>
                    <td colspan="2">
                        <div class="errMsg">${errorMsg}</div>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td align="center"><input type="submit" value="submmit" class="btn btn-default"/></td>
                <td><input id="remember" name="remember" type="checkbox"/><label>Remember
                    Me</label></td>
            </tr>
        </table>
    </div>
</form>
<script src="${basePath}js/libs/jquery-2.0.2.min.js"></script>
<script src="${basePath}js/customer/common.js"></script>
<script src="${basePath}js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
    window.onload = function () {
        if ("on" == "${remember}") {
            var checkbox = document.getElementById("remember");
            checkbox.checked = true;
        }
    }
</script>
</body>
</html>