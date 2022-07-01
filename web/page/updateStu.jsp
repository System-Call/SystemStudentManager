<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="sid" />
		姓名:<input type="text" name="sname" /><br/><br/>
		性别:男<input type="radio"  value="男" name="gender"/>
		          女<input type="radio"  value="女" name="gender"/><br/><br/>
		生日:<input class="Wdate" value="${s.sbir}" name="sbir" type="text" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"><br/><br/>
		爱好:
			抽烟<input type="checkbox"  value="抽烟" name="hobby"/>
			喝酒<input type="checkbox" value="喝酒" name="hobby"/>
			rap<input type="checkbox"  value="rap" name="hobby"/>
			烫头<input type="checkbox"  value="烫头" name="hobby"/><br/><br/>
	             头像:
	        <input type="file" name="file">
	        <br/>
	     <input type="submit" value="修改学生">
	</form>
</body>
</html>