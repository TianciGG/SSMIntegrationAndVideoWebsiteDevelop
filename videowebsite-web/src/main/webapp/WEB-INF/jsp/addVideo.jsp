<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加视频资源</title>
</head>
<body>
    <center>
        <h1>后台添加视频资源</h1>
        <form action="addVideo" style="font-size: 14px;" method="post"
            ENCTYPE="multipart/form-data">
            <table>
                <tr>
                    <td>视频名称:</td>
                    <td><input type="text" name=videoName></td>
                </tr>
                <tr>
                    <td>视频类型:</td>
                    <td><select name="videoTypeId" style="width: 170px;">
                            <c:forEach items="${listVideoType}" var="p">
                                <option value="${p.id}">${p.typeName}</option>
                            </c:forEach>

                    </select></td>
                </tr>
                <tr>
                    <td>B站播放URL:</td>
                    <td><textarea rows="10" cols="30" name="videoHtml"></textarea></td>
                </tr>
                <tr>
                    <td>上传封面:</td>
                    <td><input type="file" name="file"></td>
                </tr>
                <tr> <td colspan="2"><input type="submit" value="提交"></td></tr>
            </table>
        </form>
    </center>
</body>
</html>
