<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String basePath = "";%>
<%
    String path = request.getContextPath();
    // 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
    basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    // 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
    pageContext.setAttribute("basePath", basePath);
%>