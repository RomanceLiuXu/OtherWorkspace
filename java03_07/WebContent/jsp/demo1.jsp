<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>国际化</title>
</head>
<body>
<s:textfield key="global.code"></s:textfield>
<s:textfield key="global.psw"></s:textfield>
<div>${code }</div>
</body>
</html>