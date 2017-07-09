<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="static/css/head.css" />
<script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="static/js/forumHead.js" ></script>


<div id="head">
	<h2 class="logo">
		<a  href="index.do"><img id="logoImg"
			src="static/image/logo.png" width="400px" height="100px" /></a>
	</h2>
	<c:choose>
		<c:when test="${empty USER}">
			<p class="user" style="margin-top: 30px;">
				<a href="login.html?type=log">登录</a>
				<a href="login.html?type=reg">注册</a>
			</p>
		</c:when>
		<c:otherwise>
			<p class="user" style="margin-top:10px;">
				<a href="userInfo.do?mods=info">${USER['user'] }</a> <a href="userInfo.do?mods=info">我的资料</a> <a href="userInfo.do?mods=message">我的消息</a>
				<a href="logOut.do">登出</a> <img id="userimg"
					src="${USER['portrait']}" width="50px" height="50px" />
			</p>
			<p class="user">
				<a href="userInfo.do?mods=integral">积分:${USER.uie.total_integral }</a> <a href="userInfo.do?mods=group">用户组:${UGE.gname }</a>
			</p>
		</c:otherwise>
	</c:choose>
	<div id="pilot">
		<ul>
			<c:forEach var="ih" items="${INDEX_HEAD }">
				<li><a href="${ih['pliot_url'] }">${ih['pliot_name'] }</a></li>
			</c:forEach>
		</ul>
	</div>
	<div id="search">
		<input type="text" id="searchInput" value="${NAME}" name="name">
		<!-- <input id="searchButton" onclick="search()" type="button" value="搜索" /> -->
		<a href="javascript:search();"  class="searchA">搜索</a>
		<span id="SearchError"></span>
	</div>

</div>