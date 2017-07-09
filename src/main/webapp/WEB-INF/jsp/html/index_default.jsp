<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${PLATE_LIST }" var="pl">
	<tr>
		<td width="5%" align="center"><img id="hpImg" src="${pl['img_url'] }" width="30" height="30" /></td>
		<td width="70%">
			<a href="forum.go?fid=${pl['post_url'] }&page=1">${pl['plate_name'] }</a>
		</td>
		<td width="5%">${pl['post_count'] }/<em>0</em></td>
		<td width="20%">最后发表:${pl['last_issue'] }</td>
	</tr>
</c:forEach>