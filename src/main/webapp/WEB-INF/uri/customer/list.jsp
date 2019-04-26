<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List</title>
</head>
<body>
고객 정보 리스트<br>
번호, 이름<br>
<c:forEach items="${list}" var="ci">
${ci.ciNum}, ${ci.ciName}<br>
${list}
</c:forEach>
</body>
</html>