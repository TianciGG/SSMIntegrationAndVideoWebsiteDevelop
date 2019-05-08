<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${videoInfo.videoName}</title>
</head>
<body>
    <h1>${videoInfo.videoName}</h1>
    <iframe src="${videoInfo.videoHtml} }" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
</body>
</html>