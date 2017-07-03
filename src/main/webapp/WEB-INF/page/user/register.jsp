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
<form id="loginForm" class="form-horizontal" action="register"
      method="post" onsubmit="return registercheck()">
    <div class="form-group">
        <table class="table-login">
            <tr>
                <td><label class="col-sm-2 control-label">Username:</label></td>
                <td><input id="userName" name="userName" type="text"
                           class="form-control" placeholder="User Name" value="${userName}" onblur="usernameValid()"/>
                </td>
                <td id="userNameMsg" class="tdMsg">
                </td>
            </tr>
            <tr>
                <td><label class="col-sm-2 control-label">Password:</label></td>
                <td><input id="password" name="password" type="password"
                           class="form-control" placeholder="Password" onblur="passwordValid()"/></td>
                <td id="pwdMsg" class="tdMsg"></td>
            </tr>
            <tr>
                <td><label class="col-sm-2 control-label">CnfirmPassword:</label></td>
                <td><input id="passwordCnfirm" name="passwordCnfirm"
                           type="password" class="form-control" placeholder="Password"
                           onblur="passwordCnfValid()"/></td>
                <td id="pwdCnfMsg" class="tdMsg"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit"
                                                      class="btn btn-default" value="submmit"/></td>
            </tr>
        </table>
    </div>
</form>
<script src="${basePath}js/libs/jquery-2.0.2.min.js"></script>
<script src="${basePath}js/customer/common.js"></script>
<script src="${basePath}js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
    function usernameValid() {
        var username = document.getElementById("userName").value;
        var usernameDIV = document.getElementById("userNameMsg");
        // TODO 用户名校验
        if (username.length < 6) {
            usernameDIV.innerHTML = "<div class=\"errMsg\">用户名长度至少6位</div>";
            return false;
        } else {
            usernameDIV.innerHTML = "";
            return true;
        }
    }

    /* 密码安全性校验*/
    function passwordValid() {
        var pwd = document.getElementById("password").value;
        var pwdMsgDIV = document.getElementById("pwdMsg");
        if (pwd.length < 6) {
            pwdMsgDIV.innerHTML = "<div class=\"errMsg\">密码长度至少6位</div>";
            return false;
        } else {
            pwdMsgDIV.innerHTML = "";
            return true;
        }
    }

    /* 两次密码一致性校验 */
    function passwordCnfValid() {
        var pwd = document.getElementById("password").value;
        var pwdCnf = document.getElementById("passwordCnfirm").value;
        var pwdCnfMsgDIV = document.getElementById("pwdCnfMsg");
        if (pwd != pwdCnf) {
            pwdCnfMsgDIV.innerHTML = "<div class=\"errMsg\">两次密码不一致</div>";
            return false;
        } else {
            pwdCnfMsgDIV.innerHTML = "";
            return true;
        }
    }

    // 表单提交前校验
    function registercheck() {
        if (usernameValid() && passwordValid() && passwordCnfValid) {
            return true;
        } else {
            return false;
        }
    }

    window.onload = function () {
        var usernameDIV = document.getElementById("userNameMsg");
        if ("${errorMsg}".length > 0) {
            usernameDIV.innerHTML = "<div class=\"errMsg\">${errorMsg}</div>";
        } else {
            usernameDIV.innerHTML = "";
        }
    }
</script>
</body>
</html>