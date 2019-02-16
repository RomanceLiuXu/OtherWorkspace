<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标题</title>
</head>
<body>
<div>${sessionScope.msg }</div>
<div>
	<c:if test="${not empty permissions }">
		<div>您的权限有：<c:forEach items="${permissions} }" var="per">
						<span>${per }</span>
						</c:forEach>
		</div>
	</c:if>
</div>

</body>
</html>