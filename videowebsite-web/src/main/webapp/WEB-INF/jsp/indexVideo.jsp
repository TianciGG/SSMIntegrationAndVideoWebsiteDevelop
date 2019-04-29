<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台视频管理系统</title>
</head>
<body>
	<center>
		<h1>视频网站后台管理系统</h1>
		<a href="locaAddVideo">添加资源</a>
		<table style="BORDER-COLLAPSE: collapse; text-align: center;"
			borderColor=#000000 height=40 cellPadding=1 width="70%"
			align="center" border=1>
			<thead>
				<tr>
					<th>图片</th>
					<th>视频名称</th>
					<th>视频类型</th>
					<th>预览视频</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listVideo}" var="p">
					<tr style="font-size: 18px">
						<td><img alt="" width="150px;" height="150px;"
							src="/static/imgs/${p.videoUrl}"></td>
						<td>${p.videoName}</td>
						<td>${p.typeName}</td>
						<td><a href="videoDetails?id=${p.id}"
							style='text-decoration: none;'>预览视频</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

	</center>
</body>
</html>