<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% pageContext.setAttribute("newLine", "\n"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>normalboardList.jsp</title>
</head>
<body>
	<div>
		<h1>게시판리스트</h1>
		<hr>
		<table border="1">
			<tr>
				<td>idx</td>
				<td>제목</td>
				<td>내용</td>
				<td>아이디</td>
				<td>작성일자</td>
			</tr>
			<c:forEach var="vo" items="${vos}">
				<tr>
					<td><c:out value="${vo.idx}"/></td>
					<td><c:out value="${vo.title}"/></td>
					<td><c:out value="${vo.content}"/></td>
					<td><c:out value="${vo.mid}"/></td>
					<td><c:out value="${fn:substring(vo.wdate,0,10)}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>